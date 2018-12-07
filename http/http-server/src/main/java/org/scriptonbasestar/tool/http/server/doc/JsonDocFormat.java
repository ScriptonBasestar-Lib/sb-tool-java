package org.scriptonbasestar.tool.http.server.doc;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-06-02-19
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonDocFormat<T> {
	private List<T> samples = new ArrayList<>();

	public static <T> JsonDocFormat<T> c(T... tArr) {
		JsonDocFormat obj = new JsonDocFormat();
		return obj.a(tArr);
	}

	public JsonDocFormat<T> a(T... tArr) {
		for (T t : tArr) {
			this.samples.add(t);
		}
		return this;
	}
}
