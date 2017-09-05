package org.scriptonbasestar.tool.http.server.dto;

import lombok.Data;

@Data
//@NoArgsConstructor
//@lombok.AllArgsConstructor
public class BSParam {

	public String name;
	public Class<?> type;

	public BSParam(String name, Class<?> type){
		this.name = name;
		this.type = type;
	}

	public static BSParam create(Class type, String name){
		return new BSParam(name, type);
	}
	public static BSParam create(String name){
		return new BSParam(name, String.class);
	}
	public static BSParam[] createList(String names){
		String[] nameSplit = names.split(",");
		BSParam[] params = new BSParam[nameSplit.length];
		for(int i=0;i<nameSplit.length;i++){
			params[i] = BSParam.create(nameSplit[i]);
		}
		return params;
	}
	public static BSParam[] createList(Class type, String names){
		String[] nameSplit = names.split(",");
		BSParam[] params = new BSParam[nameSplit.length];
		for(int i=0;i<nameSplit.length;i++){
			params[i] = BSParam.create(type, nameSplit[i]);
		}
		return params;
	}
	public static BSParam[] createList(BSParam... params){
		return params;
	}
}
