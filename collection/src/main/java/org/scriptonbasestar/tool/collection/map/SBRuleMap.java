package org.scriptonbasestar.tool.collection.map;

import org.scriptonbasestar.tool.core.exception.SBBadParameterException;
import org.scriptonbasestar.tool.core.type.ElementRuleOption;

import java.util.HashMap;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 18
 */
public final class SBRuleMap extends HashMap<String, ElementRuleOption> {

	private final boolean defaultAllow;

	public SBRuleMap(){
		defaultAllow = true;
	}

	public SBRuleMap(boolean defaultAllow){
		this.defaultAllow = defaultAllow;
	}

	public boolean check(String key) {
		boolean include = super.containsKey(key);
		ElementRuleOption elementRuleOption = super.get(key);

		if (include && elementRuleOption == ElementRuleOption.ESSENTIAL) {
			return true;
		} else if (include && elementRuleOption == ElementRuleOption.BAN){
			throw new SBBadParameterException("허용되지 않는 파라미터입니다");
		} else if(include && elementRuleOption == ElementRuleOption.IGNORE) {
			return false;
		}else if(defaultAllow){
			return true;
		}
		return false;
	}

}
