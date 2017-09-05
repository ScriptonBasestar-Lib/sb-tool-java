package org.scriptonbasestar.tool.collection.map;

import org.scriptonbasestar.tool.core.type.ELEMENT_RULE_OPTION;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 16
 */
public class BSDefinedStringMapBuilder {
	private final BSRuleMap elementRule;

	private BSDefinedStringMapBuilder(boolean defaultAllow){
		elementRule = new BSRuleMap(defaultAllow);
	}

	public static BSDefinedStringMapBuilder create(boolean defaultAllow){
		return new BSDefinedStringMapBuilder(defaultAllow);
	}

	public BSDefinedStringMapBuilder add(String key, ELEMENT_RULE_OPTION rule){
		elementRule.put(key, rule);
		return this;
	}

	public BSDefinedStringMap build(){
		return new BSDefinedStringMap(elementRule);
	}


}
