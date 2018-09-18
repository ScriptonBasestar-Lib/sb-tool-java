package org.scriptonbasestar.tool.http.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 파라미터 전달받는 값들.. 대분류, 중분류, api명
 * category, name, endpoint순서.
 * @author archmagece@gmail.com
 *
 */
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class SBKey {
	public String category1;
	public String category2;
	public String endpoint;

	public SBKey(String category1, String category2, String endpoint){
		this.category1 = category1;
		this.category2 = category2;
		this.endpoint = endpoint;
	}

	//KeyObject는 무조건 세개값을 다 넣어야해서 new써도 비슷하지만
	//ValueObject와의 통일성을 유지하기 위해서.
	public static SBKey create(String category1, String category2, String endpoint){
		return new SBKey(category1, category2, endpoint);
	}
}
