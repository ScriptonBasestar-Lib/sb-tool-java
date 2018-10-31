package org.scriptonbasestar.tool.collection.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scriptonbasestar.tool.core.exception.SBDisabledException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 16
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SBDefinedStringMap extends HashMap<String, String> {

	private SBRuleMap elementRule;

	SBDefinedStringMap(SBRuleMap elementRule) {
		this.elementRule = elementRule;
	}

	@Override
	public String put(String key, String value) {
		if (elementRule.check(key)) {
			return super.put(key, value);
		}
		return null;
	}

	@Deprecated
	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		throw new SBDisabledException("불허한다");
//		super.putAll(m);
	}

//	@Override
//	public String putIfAbsent(String key, String value) {
//		return super.putIfAbsent(key, value);
//	}

}
