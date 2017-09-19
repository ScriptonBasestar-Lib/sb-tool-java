package com.scriptonbasestar.spring.security.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
@Data
public class JwtTokenHeaderDto implements Serializable {

	private String alg = "HS256";
	private String type = "JWT";

	/**
	 * 사용 기관명
	 */
	private String i_org;
	/**
	 * 사용 모듈명
	 */
	private String i_modulee;
	/**
	 * 발행시각
	 */
	private String i_since;
	/**
	 * 만료시각
	 */
	private String i_expired;
}
