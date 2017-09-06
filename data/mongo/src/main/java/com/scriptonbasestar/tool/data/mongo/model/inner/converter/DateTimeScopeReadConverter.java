package com.scriptonbasestar.tool.data.mongo.model.inner.converter;

import com.mongodb.DBObject;
import com.scriptonbasestar.tool.data.mongo.model.inner.model.DateTimeScopeInnerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Date;

/**
 * Created by archmagece on 2015-10-01.
 */
@ReadingConverter
public class DateTimeScopeReadConverter implements Converter<DBObject, DateTimeScopeInnerModel> {
	@Override
	public DateTimeScopeInnerModel convert(DBObject source) {
		return new DateTimeScopeInnerModel((Date) source.get("fromDate"), (Date) source.get("toDate"));
	}
}
