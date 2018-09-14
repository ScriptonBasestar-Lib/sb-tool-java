package org.scriptonbasestar.tool.data.mongo.model.inner.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;

import java.io.Serializable;

/**
 * Created by archmagece on 2015-10-01.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
