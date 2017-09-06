package org.scriptonbasestar.tool.transfer;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-09-14-20
 * <p>
 * 데이터를 전달하는 프로토콜
 */
@Data
public final class DataObject<DATA extends Serializable> extends ADataObject<DATA> {

	private DataObject() {
		this.results = new ArrayList<>();
	}

	public static <T extends Serializable> DataObject<T> create(Collection<T> t) {
		return new DataObject<T>().add(t);
	}

	public static <T extends Serializable> DataObject<T> create(T... t) {
		return new DataObject<T>().add(t);
	}

	public DataObject<DATA> add(Collection<DATA> ts) {
		this.results.addAll(ts);
		return this;
	}

	public DataObject<DATA> add(DATA... ts) {
		for (DATA t : ts) {
			this.results.add(t);
		}
		return this;
	}

	public DataObject<DATA> pagingValue(PagingValue pagingValue) {
		this.pagingValue = pagingValue;
		return this;
	}
}
