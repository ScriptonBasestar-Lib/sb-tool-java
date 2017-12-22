package org.scriptonbasestar.tool.data.jpa.usertype;

import com.google.common.base.Objects;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StringType;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.scriptonbasestar.tool.crypto.symmetry.RC2;
import org.scriptonbasestar.tool.crypto.symmetry.SBSymmetryService;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

/**
 * @author archmagece
 * @since 2017-09-07
 */
public class RC2UserType implements UserType, ParameterizedType {

	public static final String TYPE = "org.scriptonbasestar.tool.data.jpa.usertype.RC2UserType";

	public static final String PARAM_CHARSET = "charset";

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF8");

	public static final int SQL_TYPE = Types.VARCHAR;

	private final SBSymmetryService byteEncryptor = new RC2("r390prifk0p2i03082");

	protected Charset charset;

	@Override
	public void setParameterValues(Properties parameters) {
		if (parameters != null) {
			String tmp = parameters.getProperty(PARAM_CHARSET);
			if (tmp != null) {
				try {
					charset = Charset.forName(tmp);
				} catch (IllegalCharsetNameException x) {
					throw new HibernateException("Unsupported character set " + tmp + ": " + x.getMessage(), x);
				} catch (UnsupportedCharsetException x) {
					throw new HibernateException("Unsupported character set " + tmp + ": " + x.getMessage(), x);
				}
			}
		}
		if (charset == null) {
			charset = DEFAULT_CHARSET;
		}
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { StringType.INSTANCE.sqlType() };
	}

	@Override
	public Class returnedClass() {
		return String.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return Objects.equal(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return Objects.hashCode(x);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
		try {
			String hexStr = StringType.INSTANCE.nullSafeGet(rs, names[0], session);
			if(hexStr==null){
				return null;
			}
			return StringUtils.newStringUtf8(byteEncryptor.decrypt(hexStr.getBytes()));
		} catch (Exception ex) {
			throw new HibernateException("암호화를 복원하는데 실패했습니다.", ex);
		}
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
		try {
			if(value==null){
				StringType.INSTANCE.nullSafeSet(st, null, index, session);
			}else{
				StringType.INSTANCE.nullSafeSet(st, Hex.encodeHexString(byteEncryptor.encrypt(((String) value).getBytes("UTF-8"))), index, session);
			}
		} catch (Exception ex) {
			throw new HibernateException("암호화를 수행하는데 실패했습니다.", ex);
		}
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return StringType.INSTANCE.isMutable();
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) deepCopy(value);
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return deepCopy(cached);
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return deepCopy(original);
	}
}
