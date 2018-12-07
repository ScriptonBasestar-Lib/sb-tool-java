package org.scriptonbasestar.tool.collection.joiner;


import org.scriptonbasestar.tool.core.check.Check;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author archmagece
 * @with sb-toolbox-basic
 * @since 2015-06-10-15
 */
public final class Joiner<ITEM> {

	private final String separator;
	private static final String DEFAULT_SEPARATOR = ",";

	private final Collection<ITEM> toAppend;

	private Joiner() {
		this(DEFAULT_SEPARATOR, new ArrayList<>());
	}

	private Joiner(Collection<ITEM> toAppend) {
		this(DEFAULT_SEPARATOR, toAppend);
	}

	private Joiner(String separator) {
		this(separator, new ArrayList<>());
	}

	private Joiner(String separator, Collection<ITEM> toAppend) {
		Check.notNull(separator, "separator must not be null");
		Check.notNull(toAppend, "toAppend collection must not be null");
		this.separator = separator;
		this.toAppend = toAppend;
	}

	public static <ITEM> Joiner on(String separator) {
		return new Joiner<ITEM>(separator);
	}

	public static Joiner on(char separator) {
		return new Joiner(String.valueOf(separator));
	}

	public Joiner append(ITEM... entities) {
		Collections.addAll(this.toAppend, entities);
		return this;
	}

	public Joiner<ITEM> append(Collection<ITEM> entities) {
		this.toAppend.addAll(entities);
		return this;
	}

	public String join() {
		StringBuilder sb = new StringBuilder();
		for (Object o : this.toAppend) {
			sb
				.append(o.toString())
				.append(this.separator);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
