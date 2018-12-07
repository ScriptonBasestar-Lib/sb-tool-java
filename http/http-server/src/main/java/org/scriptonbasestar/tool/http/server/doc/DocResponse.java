package org.scriptonbasestar.tool.http.server.doc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author archmagece
 * @since 2015-06-02
 * <p>
 * spring @ResponseBody 이용, jackson json 사용시
 * document 클래스 만들때 response로 샘플을 보내주는 용도로 사용
 */
public final class DocResponse<T>
	implements Serializable {
	private List<T> samples;

	private DocResponse() {
		this.samples = new ArrayList<>();
	}

	public static <T> DocResponse<T> c(T... ts) {
		return new DocResponse<T>().a(ts);
	}

	public static <T> DocResponse<T> c(Collection<T> ts) {
		return new DocResponse<T>().a(ts);
	}

	public DocResponse<T> a(T... ts) {
		for (T t : ts) {
			this.samples.add(t);
		}
		return this;
	}

	public DocResponse<T> a(Collection<T> ts) {
		for (T t : ts) {
			this.samples.add(t);
		}
		return this;
	}
}
