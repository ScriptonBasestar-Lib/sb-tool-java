package org.scriptonbasestar.tool.http.client.rest.type;

import lombok.Getter;

/**
 * @author : archmagece@gmail.com
 * @since: 2014-03-06 11:30
 * hello world, hello venus, hello alice
 */
public enum EncodingType {
	UTF8("UTF-8"), EUCKR("EUC-KR");

	@Getter
	String encoding;

	EncodingType(String encoding) {
		this.encoding = encoding;
	}
}
