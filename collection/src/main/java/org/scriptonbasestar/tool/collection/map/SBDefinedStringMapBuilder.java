package org.scriptonbasestar.tool.collection.map;

import org.scriptonbasestar.tool.core.type.ElementRuleOption;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 16
 */
public class SBDefinedStringMapBuilder {
	private final SBRuleMap elementRule;

	private SBDefinedStringMapBuilder(boolean defaultAllow){
		elementRule = new SBRuleMap(defaultAllow);
	}

	public static SBDefinedStringMapBuilder create(boolean defaultAllow){
		return new SBDefinedStringMapBuilder(defaultAllow);
	}

	public SBDefinedStringMapBuilder add(String key, ElementRuleOption rule){
		elementRule.put(key, rule);
		return this;
	}

	public SBDefinedStringMap build(){
		return new SBDefinedStringMap(elementRule);
	}


}
