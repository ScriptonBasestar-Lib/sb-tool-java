package org.scriptonbasestar.tool.data.jpa.usertype;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.scriptonbasestar.tool.crypto.password.Bcrypt;
import org.scriptonbasestar.tool.crypto.password.SBPasswordEncoder;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author chaeeung.e
 * @since 2017-09-20
 */
public class BCryptUserType implements UserType, Serializable {

	private final SBPasswordEncoder encoder;

	private static final int type = Types.VARCHAR;

	public BCryptUserType(){
		this(new Bcrypt());
	}

	public BCryptUserType(SBPasswordEncoder encoder){
		this.encoder = encoder;
	}

	@Override
	public int[] sqlTypes() {
		return new int[]{Types.VARCHAR};
	}

	@Override
	public Class returnedClass() {
		return String.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
		final String val = rs.getString(names[0]);
		return rs.wasNull() ? null : val;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
		if(value==null){
			st.setNull(index, type);
		} else {
			st.setString(index, encoder.encrypt(value.toString()));
		}
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}
}
