package com.scriptonbasestar.tool.data.mongo.model.inner.converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.scriptonbasestar.tool.data.mongo.model.inner.model.ImageInnerModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * Created by archmagece on 2015-10-01.
 */
@WritingConverter
public class ImageWriteConverter implements Converter<ImageInnerModel, DBObject> {
	@Override
	public DBObject convert(ImageInnerModel source) {
		return source == null ? null :
				new BasicDBObject()
						.append("path", source.getPath())
						.append("name", source.getName())
						.append("extension", source.getExtension())
						.append("size", source.getSize());
	}
}
