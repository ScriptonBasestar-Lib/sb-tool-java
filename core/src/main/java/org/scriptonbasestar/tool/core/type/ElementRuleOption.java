package org.scriptonbasestar.tool.core.type;

public enum ElementRuleOption {
	/**
	 * 필수 없으면 에러
	 */
	ESSENTIAL,
	/**
	 * 있어도 무시
	 */
	IGNORE,
	/**
	 * 있으면 오류
	 */
	BAN
}
