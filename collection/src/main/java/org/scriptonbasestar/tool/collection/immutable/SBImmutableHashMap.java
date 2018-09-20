package org.scriptonbasestar.tool.collection.immutable;

import org.scriptonbasestar.tool.core.exception.SBDisabledException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author archmagece
 * @CreatedAt 2016-08-29 11
 * @see java.util.Collections#unmodifiableMap(Map) <? extends K,? extends V> m)
 */
@Deprecated
public class SBImmutableHashMap<K, V> extends HashMap<K,V>{

	@Override
	public V put(K key, V value) {
		throw new SBDisabledException("cannot change. This collection is immutable");
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new SBDisabledException("cannot change. This collection is immutable");
	}

//	@Override
//	public V putIfAbsent(K key, V value) {
//		return super.putIfAbsent(key, value);
//	}

}
