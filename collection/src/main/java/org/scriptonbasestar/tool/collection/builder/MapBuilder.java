package org.scriptonbasestar.tool.collection.builder;

import org.scriptonbasestar.tool.core.reflection.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: archmagece
 * @Since: 2013-11-27 15:42
 */
public final class MapBuilder<K, V> {

	private final Map<K, V> map;

	private MapBuilder() {
		this.map = new HashMap<>();
	}
	private MapBuilder(Map<K, V> map) {
		this.map = map;
	}

	public static <K, V> MapBuilder<K, V> create(){
		return new MapBuilder<>();
	}
	public static <K, V> MapBuilder<K, V> create(Class<K> keyType, Class<V> valType){
		return new MapBuilder<>();
	}
	public static <K, V> MapBuilder<K, V> create(Map<K, V> map) {
		return new MapBuilder<>(map);
	}

	public MapBuilder<K, V> add(K key, V val) {
		this.map.put(key, val);
		return this;
	}

	public MapBuilder<K, V> add(Map<K, V> map) {
		this.map.putAll(map);
		return this;
	}

//	public MapBuilder<K, V> add(Object object) {
//		ReflectionUtil
//		return this;
//	}

	public Map<K, V> build() {
		return this.map;
	}
}
