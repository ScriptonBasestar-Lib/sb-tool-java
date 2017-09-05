package org.scriptonbasestar.tool.collection.list;

import org.scriptonbasestar.tool.core.exception.BSDisabledException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class BSImmutableArrayList<E> extends ArrayList<E>{
	@Override
	public boolean add(E e) {
		throw new BSDisabledException("cannot change immutable collection");
	}

	@Override
	public void add(int index, E element) {
		throw new BSDisabledException("cannot change immutable collection");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new BSDisabledException("cannot change immutable collection");
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new BSDisabledException("cannot change immutable collection");
	}
}
