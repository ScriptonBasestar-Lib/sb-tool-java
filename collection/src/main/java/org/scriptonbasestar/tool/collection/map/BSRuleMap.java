package org.scriptonbasestar.tool.collection.map;

import lombok.extern.slf4j.Slf4j;
import org.scriptonbasestar.tool.core.exception.BSBadParameterException;
import org.scriptonbasestar.tool.core.type.ELEMENT_RULE_OPTION;

import java.util.HashMap;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 18
 */
@Slf4j
public final class BSRuleMap extends HashMap<String, ELEMENT_RULE_OPTION> {

	private final boolean defaultAllow;

	public BSRuleMap(){
		defaultAllow = true;
	}

	public BSRuleMap(boolean defaultAllow){
		this.defaultAllow = defaultAllow;
	}

	public boolean check(String key) {
		boolean include = super.containsKey(key);
		ELEMENT_RULE_OPTION elementRuleOption = super.get(key);

		if (include && elementRuleOption == ELEMENT_RULE_OPTION.ESSENTIAL) {
			return true;
		} else if (include && elementRuleOption == ELEMENT_RULE_OPTION.BAN){
			throw new BSBadParameterException("허용되지 않은 파라미터입니다");
		} else if(include && elementRuleOption == ELEMENT_RULE_OPTION.IGNORE) {
			return false;
		}else if(defaultAllow){
			return true;
		}
		return false;
	}

}
