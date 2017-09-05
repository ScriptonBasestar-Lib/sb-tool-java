package org.scriptonbasestar.tool.collection.map;

import lombok.extern.slf4j.Slf4j;
import org.scriptonbasestar.tool.core.exception.BSDisabledException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author archmagece
 * @CreatedAt 2016-08-29 11
 */
@Slf4j
public class BSImmutableHashMap<K, V> extends HashMap<K,V>{

	@Override
	public V put(K key, V value) {
		throw new BSDisabledException("cannot change immutable collection");
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new BSDisabledException("cannot change immutable collection");
	}

//	@Override
//	public V putIfAbsent(K key, V value) {
//		return super.putIfAbsent(key, value);
//	}

}
