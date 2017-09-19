package com.scriptonbasestar.spring.security.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
@Data
public class JwtTokenPayloadUserDto implements Serializable {
	private Set<String> roles;
	private long id;
	private String nickname;
}
