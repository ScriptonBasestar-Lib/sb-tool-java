package org.scriptonbasestar.tool.core.reflection;


import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 */
public class ParamMap
		extends
		LinkedHashMap<String, Object>
		implements
		Serializable {

	private Set<Object> beanSet = null;

	// --생성자--//
	public ParamMap() {
		super();
		initBeanSet();
	}

	public ParamMap(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
		initBeanSet();
	}

	public ParamMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
		initBeanSet();
	}

	public ParamMap(int initialCapacity) {
		super(initialCapacity);
		initBeanSet();
	}

	public ParamMap(Map<? extends String, ? extends Object> m) {
		super(m);
		initBeanSet();
	}

	private void initBeanSet() {
		beanSet = new HashSet<Object>();
	}

	// --/생성자--//
	// --맵--//
	public void beanToMap(Object pbean)
			throws
			IntrospectionException,
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException {

		Method[] methods = pbean.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
			if (Identify.isGetter(methods[i])) {
				Object result = methods[i].invoke(pbean);
				super.put(methods[i].getName(), result);
			}
		}
	}

	public void beanFromMap(Object pbean)
			throws
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException {

		beanSet.add(pbean);

		Method[] methods = pbean.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (Identify.isSetter(methods[i])) {
				methods[i].invoke(pbean, super.get(methods[i].getName()));
			}
		}
	}

	public <T> T tBeanFromMap(T pbean)
			throws
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException {

		// if(!beanSet.contains(pbean)){
		// return null;
		// }

		Method[] methods = pbean.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (Identify.isSetter(methods[i])) {
				methods[i].invoke(pbean, super.get(methods[i].getName()));
			}
		}
		return pbean;
	}

	// --/맵--//
	// --키워드셋팅
	// private Set<String> keys=null;

	// public Set<String> getKeys() {
	// return keys;
	// }

	// public void setKeys(Set<String> keys) {
	// this.keys = keys;
	// }

	public boolean setKeyWords(String... params) {
		boolean result = false;
		for (String s : params) {
			// keys.add(s);
			if (super.containsKey(s)) {
				result = true;
			}
			super.put(s, null);
		}
		return result;
	}

	// --/키워드셋
	// --키워드값셋
	public void setValues(String key, Object value) {
		super.put(key, value);
	}

	public void clear() {
		super.clear();
	}

	// --/키워드값셋

	public Set<Object> getBeans()
			throws
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException {
		Set<Object> result = new HashSet<Object>();
		for (Object o : beanSet) {
			result.add(tBeanFromMap(o));
		}
		return result;
	}

//	public Paging getPaging()
//			throws
//			IllegalArgumentException,
//			IllegalAccessException,
//			InvocationTargetException {
//		return tBeanFromMap(new Paging());
//	}
}
