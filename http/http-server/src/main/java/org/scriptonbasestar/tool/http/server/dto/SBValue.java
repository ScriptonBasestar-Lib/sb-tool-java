package org.scriptonbasestar.tool.http.server.dto;

import lombok.Data;
import org.scriptonbasestar.tool.http.server.VALUE_TYPE;

/**
 * 주소명을 기반으로 api네임맵에서 검색하는 경우...찾게되는 값들.
 * 
 * @author archmagece@gmail.com
 *
 */
@Data
//@NoArgsConstructor
//@lombok.AllArgsConstructor
public class SBValue {
	public VALUE_TYPE type;
	public String tblname;
	public String queryName;
	public String searchKey;

	public SBValue(VALUE_TYPE type, String tblname, String queryName, String searchKey){
		this.type = type;
		this.tblname = tblname;
		this.queryName = queryName;
		this.searchKey = searchKey;
	}

	//그냥 new쓰기귀찮아서 추가된코들
	public static SBValue create(VALUE_TYPE type, String tblname, String searchKey){
		return new SBValue(type, tblname, "select_"+tblname, searchKey);
	}
	public static SBValue create(String tblname, String searchKey){
		return new SBValue(VALUE_TYPE.data, tblname, "select_"+tblname, searchKey);
	}
	public static SBValue create(VALUE_TYPE type, String tblname, String queryName, String searchKey){
		return new SBValue(type, tblname, queryName, searchKey);
	}
	public static SBValue create(String tblname, String queryName, String searchKey){
		return new SBValue(VALUE_TYPE.data, tblname, queryName, searchKey);
	}
}
