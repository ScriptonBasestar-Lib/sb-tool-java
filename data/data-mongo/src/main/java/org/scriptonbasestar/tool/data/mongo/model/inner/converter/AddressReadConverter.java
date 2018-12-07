package org.scriptonbasestar.tool.data.mongo.model.inner.converter;

import com.mongodb.DBObject;
import org.scriptonbasestar.tool.data.mongo.model.inner.model.AddressInnerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * @author archmagece
 * @since 2015-06-02-17
 */
@ReadingConverter
public class AddressReadConverter
	implements Converter<DBObject, AddressInnerModel> {
	@Override
	public AddressInnerModel convert(DBObject source) {
		return new AddressInnerModel((String) source.get("country"), (String) source.get("state"), (String) source.get("city"), (String) source.get("detail"), (String) source.get("zipCode"));
	}
}
