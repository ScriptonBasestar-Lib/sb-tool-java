package org.scriptonbasestar.tool.collection.immutable;

import org.scriptonbasestar.tool.core.exception.runtime.SBDisabledException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 *
 * @see java.util.Collections.unmodifiableList(List<? extends T> list)
 */
@Deprecated
public class SBImmutableArrayList<E> extends ArrayList<E>{
	@Override
	public boolean add(E e) {
		throw new SBDisabledException("cannot change. This collection is immutable.");
	}

	@Override
	public void add(int index, E element) {
		throw new SBDisabledException("cannot change. This collection is immutable");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new SBDisabledException("cannot change. This collection is immutable");
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new SBDisabledException("cannot change. This collection is immutable");
	}
}
