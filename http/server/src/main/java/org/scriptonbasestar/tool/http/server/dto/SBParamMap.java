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
public class SBParamMap {

	public SBParam[] params;
	public boolean essential;
	public SELECTION_TYPE selectionType;

	public SBParamMap(SBParam[] params, boolean essential, SELECTION_TYPE selection_type){
		this.params = params;
		this.essential = essential;
		this.selectionType = selection_type;
	}

	public static SBParamMap create(SBParam[] params, boolean essencial, SELECTION_TYPE selectionType){
		return new SBParamMap(params, essencial, selectionType);
	}
	public static SBParamMap create(String names, boolean essencial, SELECTION_TYPE selectionType){
		return new SBParamMap(SBParam.createList(names), essencial, selectionType);
	}
	public static List<SBParamMap> list(SBParamMap...keys){
		return new ArrayList<SBParamMap>(Arrays.asList(keys));
	}

	public int containParamsCount(String ... names){
		int cnt = 0;
		for(SBParam param : params){
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
		for(SBParam param : params){
			for(String name : names){
				if(param.name.equals(name)){
					cnt++;
				}
			}
		}
		return cnt;
	}
}
