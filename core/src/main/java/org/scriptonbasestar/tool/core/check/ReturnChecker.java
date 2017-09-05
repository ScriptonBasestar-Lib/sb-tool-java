package org.scriptonbasestar.tool.core.check;

import lombok.experimental.UtilityClass;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-30 14
 */
@UtilityClass
public class ReturnChecker {

	public static <T> T notNull(T source) {
		Check.notNull(source, "ReturnChecker.notNull : not allow null result");
		return source;
	}

}
