package org.scriptonbasestar.tools.collection.builder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author archmagece
 * @since 2014. 9. 11.
 */
public final class SetBuilder<ITEM> {

	private Set<ITEM> set;

	private SetBuilder() {
		this.set = new HashSet<>();
	}

	private SetBuilder(Set<ITEM> set) {
		this.set = set;
	}

	public static <ITEM1> SetBuilder<ITEM1> create() {
		return new SetBuilder<>();
	}

	public static <ITEM2> SetBuilder<ITEM2> create(Class<ITEM2> itemType) {
		return new SetBuilder<>();
	}

	public static <ITEM3> SetBuilder<ITEM3> create(Set<ITEM3> set) {
		return new SetBuilder<>(set);
	}

	public static <ITEM4> SetBuilder<ITEM4> create(ITEM4... items) {
		SetBuilder<ITEM4> builder = new SetBuilder<>();
		builder.add(items);
		return builder;
	}

	public SetBuilder<ITEM> add(ITEM... entities) {
		for (ITEM e : entities) {
			this.set.add(e);
		}
		return this;
	}

	public SetBuilder<ITEM> add(Set<ITEM> set) {
		this.set.addAll(set);
		return this;
	}

	public Set<ITEM> build() {
		return this.set;
	}

}
