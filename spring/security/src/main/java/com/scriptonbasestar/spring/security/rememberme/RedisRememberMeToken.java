package com.scriptonbasestar.spring.security.rememberme;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author archmagece
 * @CreatedAt 2016-07-19 19
 */
@Slf4j
@Getter
public class RedisRememberMeToken {
	private final String username;
	private final String series;
	private final String tokenValue;
	private final Date date;

	public RedisRememberMeToken(String username, String series, String tokenValue, Date date) {
		this.username = username;
		this.series = series;
		this.tokenValue = tokenValue;
		this.date = date;
	}
}
