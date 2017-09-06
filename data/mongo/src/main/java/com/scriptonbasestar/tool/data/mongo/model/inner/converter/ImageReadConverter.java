package com.scriptonbasestar.tool.data.mongo.model.inner.converter;

import com.mongodb.DBObject;
import com.scriptonbasestar.tool.data.mongo.model.inner.model.ImageInnerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Created by archmagece on 2015-10-01.
 */
@ReadingConverter
public class ImageReadConverter implements Converter<DBObject, ImageInnerModel> {
	@Override
	public ImageInnerModel convert(DBObject source) {
		return new ImageInnerModel(
				(String) source.get("path"),
				(String) source.get("name"),
				(String) source.get("extension"),
				(Long) source.get("size")
		);
	}
}
