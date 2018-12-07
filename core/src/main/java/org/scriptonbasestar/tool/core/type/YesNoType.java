package org.scriptonbasestar.tool.core.type;

/**
 * Yes / No / None
 * type 구분할 때 사용
 */
public enum YesNoType {
	Yes('Y'),
	No('N'),
	UnKnown('_');

	public final char val;

	YesNoType(char val) {
		this.val = val;
	}

	YesNoType(String val) {
		switch (val.toUpperCase()) {
			case "YES":
				this.val = 'Y';
				break;
			case "NO":
				this.val = 'N';
				break;
			default:
				this.val = 'O';
		}
	}
}
