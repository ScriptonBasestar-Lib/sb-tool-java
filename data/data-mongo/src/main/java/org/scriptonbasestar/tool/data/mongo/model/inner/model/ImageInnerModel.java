package org.scriptonbasestar.tool.data.mongo.model.inner.model;

import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;

import java.io.Serializable;

/**
 * Created by archmagece on 2015-10-01.
 */
//@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ImageInnerModel implements Serializable {
	@PersistenceConstructor
	public ImageInnerModel(String path, String name, String extension, Long size) {
		this.path = path;
		this.name = name;
		this.extension = extension;
		this.size = size;
	}

	private String path;
	private String name;
	private String extension;
	private Long size;
}
