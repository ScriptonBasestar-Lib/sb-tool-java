package com.scriptonbasestar.tool.data.mongo.model.inner.converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.scriptonbasestar.tool.data.mongo.model.inner.model.DateTimeScopeInnerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * Created by archmagece on 2015-10-01.
 */
@WritingConverter
public class DateTimeScopeWriteConverter implements Converter<DateTimeScopeInnerModel, DBObject> {
	@Override
	public DBObject convert(DateTimeScopeInnerModel source) {
		return source == null ? null :
				new BasicDBObject()
						.append("fromDate", source.getFromDate())
						.append("toDate", source.getToDate());
	}
}
