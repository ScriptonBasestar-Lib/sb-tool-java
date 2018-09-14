package org.scriptonbasestar.tool.http.server.dto;

import lombok.Data;

@Data
//@NoArgsConstructor
//@lombok.AllArgsConstructor
public class SBParam {

	public String name;
	public Class<?> type;

	public SBParam(String name, Class<?> type){
		this.name = name;
		this.type = type;
	}

	public static SBParam create(Class type, String name){
		return new SBParam(name, type);
	}
	public static SBParam create(String name){
		return new SBParam(name, String.class);
	}
	public static SBParam[] createList(String names){
		String[] nameSplit = names.split(",");
		SBParam[] params = new SBParam[nameSplit.length];
		for(int i=0;i<nameSplit.length;i++){
			params[i] = SBParam.create(nameSplit[i]);
		}
		return params;
	}
	public static SBParam[] createList(Class type, String names){
		String[] nameSplit = names.split(",");
		SBParam[] params = new SBParam[nameSplit.length];
		for(int i=0;i<nameSplit.length;i++){
			params[i] = SBParam.create(type, nameSplit[i]);
		}
		return params;
	}
	public static SBParam[] createList(SBParam... params){
		return params;
	}
}
