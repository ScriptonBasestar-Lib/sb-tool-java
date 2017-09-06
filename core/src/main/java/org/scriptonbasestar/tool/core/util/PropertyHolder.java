package org.scriptonbasestar.tool.core.util;

import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author archmagece
 * @since 2014. 11. 16.
 */
public class PropertyHolder implements Serializable {
	private Map<String, Object> setting = new HashMap<>();

	@Setter
	private Refresher<Map<String, Object>> refresher;

	public void refresh() {
		if (refresher == null) {
			return;
		}
		this.setting = refresher.newSetting();
	}

	public synchronized PropertyHolder put(String key, Object value) {
		setting.put(key, value);
		return this;
	}

	public String getString(String key) {
		return setting.get(key).toString();
	}

	public <Type> Type get(String key) {
		return (Type) setting.get(key);
	}
	public <Type> Type get(Class<Type> clazz, String key) {
		return (Type) setting.get(key);
	}

	@Override
	public String toString() {
		return setting.toString();
	}
}
