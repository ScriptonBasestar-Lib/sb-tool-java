package org.scriptonbasestar.tool.http.server.dto;

import lombok.Data;
import org.scriptonbasestar.tool.http.server.SELECTION_TYPE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Data
//@NoArgsConstructor
//@lombok.AllArgsConstructor
public class BSParamMap {

	public BSParam[] params;
	public boolean essential;
	public SELECTION_TYPE selectionType;

	public BSParamMap(BSParam[] params, boolean essential, SELECTION_TYPE selection_type){
		this.params = params;
		this.essential = essential;
		this.selectionType = selection_type;
	}

	public static BSParamMap create(BSParam[] params, boolean essencial, SELECTION_TYPE selectionType){
		return new BSParamMap(params, essencial, selectionType);
	}
	public static BSParamMap create(String names, boolean essencial, SELECTION_TYPE selectionType){
		return new BSParamMap(BSParam.createList(names), essencial, selectionType);
	}
	public static List<BSParamMap> list(BSParamMap ...keys){
		return new ArrayList<BSParamMap>(Arrays.asList(keys));
	}

	public int containParamsCount(String ... names){
		int cnt = 0;
		for(BSParam param : params){
			for(String name : names){
				if(param.name.equals(name)){
					cnt++;
				}
			}
		}
		return cnt;
	}
	public int containParamsCount(Set<String> names){
		int cnt = 0;
		for(BSParam param : params){
			for(String name : names){
				if(param.name.equals(name)){
					cnt++;
				}
			}
		}
		return cnt;
	}
}
