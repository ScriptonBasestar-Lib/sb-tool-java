package org.scriptonbasestar.tool.core.reflection;

import lombok.experimental.UtilityClass;
import org.scriptonbasestar.tool.core.check.ReturnChecker;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-30 12
 */
@UtilityClass
public class StrictCastingUtil {

	public static <T> T casting(Object source, Class<T> clazz) {
		return TolerantCastingUtil.casting(source, clazz);
	}

	public static String castingString(Object source) {
		return ReturnChecker.notNull(TolerantCastingUtil.castingString(source));
	}

	public static Integer castingInt(Object source) {
		return ReturnChecker.notNull(TolerantCastingUtil.castingInt(source));
	}

	public static Long castingLong(Object source) {
		return ReturnChecker.notNull(TolerantCastingUtil.castingLong(source));
	}

	public static Float castingFloat(Object source) {
		return ReturnChecker.notNull(TolerantCastingUtil.castingFloat(source));
	}

	public static Double castingDouble(Object source) {
		return ReturnChecker.notNull(TolerantCastingUtil.castingDouble(source));
	}

	public static Character castingChar(Object source) {
		return ReturnChecker.notNull(TolerantCastingUtil.castingChar(source));
	}
}
