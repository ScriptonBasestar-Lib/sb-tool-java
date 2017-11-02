package org.scriptonbasestar.tool.core.type;

/**
 * @author archmagece
 * @date 2015-12-09
 */
public enum  InOutType {
	In('I'),Out('O'),UnKnown('_');

	public final char val;
	InOutType(char val){
		this.val = val;
	}
	InOutType(String val){
		switch (val.toUpperCase()){
			case "IN":
				this.val = 'I';
				break;
			case "OUT":
				this.val = 'O';
				break;
			default:
				this.val = '_';
		}
	}
}
