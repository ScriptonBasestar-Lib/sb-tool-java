package org.scriptonbasestar.tool.core.type;

/**
 * @author archmagece
 * @date 2015-12-09
 */
public enum GenderType {
	Male('M'),
	Female('F'),
	UnKnown('_');

	public final char val;

	GenderType(char val) {
		this.val = val;
	}

	GenderType(String val) {
		switch (val.toUpperCase()) {
			case "MALE":
				this.val = 'M';
				break;
			case "FEMALE":
				this.val = 'F';
				break;
			default:
				this.val = '_';
		}
	}
}
