package org.scriptonbasestar.tool.collection.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scriptonbasestar.tool.core.exception.BSDisabledException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 16
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BSDefinedStringMap extends HashMap<String, String> {

	private BSRuleMap elementRule;

	BSDefinedStringMap(BSRuleMap elementRule){
		this.elementRule = elementRule;
	}

	@Override
	public String put(String key, String value) {
		if(elementRule.check(key)){
			return super.put(key, value);
		}
		return null;
	}

	@Deprecated
	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		throw new BSDisabledException("불허한다");
//		super.putAll(m);
	}

//	@Override
//	public String putIfAbsent(String key, String value) {
//		return super.putIfAbsent(key, value);
//	}

}
