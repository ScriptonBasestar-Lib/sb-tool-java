package org.scriptonbasestar.tool.data.mongo.model.inner.converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.scriptonbasestar.tool.data.mongo.model.inner.model.AddressInnerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * @author archmagece
 * @since 2015-06-02-17
 */
@WritingConverter
public class AddressWriteConverter implements Converter<AddressInnerModel, DBObject> {
	@Override
	public DBObject convert(AddressInnerModel source) {
		return source == null ? null :
				new BasicDBObject()
						.append("country", source.getCountry())
						.append("state", source.getState())
						.append("city", source.getCity())
						.append("detail", source.getDetail())
						.append("zipCode", source.getZipCode());
	}
}
