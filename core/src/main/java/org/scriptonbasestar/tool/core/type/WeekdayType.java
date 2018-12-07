package org.scriptonbasestar.tool.core.type;

/**
 * @author archmagece
 * @since 2015-03-09-17
 */
public enum WeekdayType {
	SUN(0),
	MON(1),
	TUE(2),
	WED(3),
	THR(4),
	FRI(5),
	SAT(6);
	public int val;

	WeekdayType(int val) {
		this.val = val;
	}

}
