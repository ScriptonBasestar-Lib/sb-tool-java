package org.scriptonbasestar.tool.collection.joiner;


import org.scriptonbasestar.tool.core.check.Check;
import org.scriptonbasestar.tool.core.exception.SBBadParameterException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author archmagece
 * @with sb-toolbox-basic
 * @since 2015-06-10-15
 */
public final class Joiner<ITEM> {

	private final String separator;

	private final Collection<ITEM> toAppend;

	private Joiner(String separator) {
		this(separator, new ArrayList<>());
	}

	private Joiner(String separator, Collection<ITEM> toAppend) {
		Check.notNull(separator, "separator should not be null");
		this.separator = separator;
		this.toAppend = toAppend;
	}

	public static Joiner on(String separator) {
		return new Joiner(separator);
	}

	public static Joiner on(char separator) {
		return new Joiner(String.valueOf(separator));
	}

	public Joiner append(ITEM... entities) {
		for (ITEM e : entities) {
			this.toAppend.add(e);
		}
		return this;
	}

	public Joiner append(Collection<ITEM> entities) {
		this.toAppend.addAll(entities);
		return this;
	}

	public String join() {
		if(toAppend.isEmpty()){
			throw new SBBadParameterException("컬렉션이 공백입니다.");
		}
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
