package org.scriptonbasestar.tools.collection.builder;

import java.util.ArrayList;
import java.util.List;

public final class ListBuilder<ITEM> {

	private final List<ITEM> list;

	private ListBuilder() {
		this.list = new ArrayList<>();
	}

	private ListBuilder(List<ITEM> list) {
		this.list = list;
	}

	public static <ITEM1> ListBuilder<ITEM1> create() {
		return new ListBuilder<>();
	}

	public static <ITEM2> ListBuilder<ITEM2> create(Class<ITEM2> itemType) {
		return new ListBuilder<>();
	}

	public static <ITEM3> ListBuilder<ITEM3> create(List<ITEM3> list) {
		return new ListBuilder<>(list);
	}

	public static <ITEM4> ListBuilder<ITEM4> create(ITEM4... entity) {
		ListBuilder<ITEM4> builder = new ListBuilder<>();
		builder.add(entity);
		return builder;
	}

	public ListBuilder<ITEM> add(ITEM... entities) {
		for (ITEM e : entities) {
			this.list.add(e);
		}
		return this;
	}

	public ListBuilder<ITEM> add(List<ITEM> list) {
		this.list.addAll(list);
		return this;
	}

	public List<ITEM> build() {
		return this.list;
	}

}
