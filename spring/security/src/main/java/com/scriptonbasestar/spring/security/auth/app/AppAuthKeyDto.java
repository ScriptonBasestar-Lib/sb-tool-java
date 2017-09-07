package com.scriptonbasestar.spring.security.auth.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @author archmagece
 * @since 2015-01-26-11
 */
@Data
public class AppAuthKeyDto implements Serializable {
	private String username;
	private String secret;
	private Long expirationTime;
}
