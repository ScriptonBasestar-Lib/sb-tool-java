package org.scriptonbasestar.spring.security.jwt.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author chaeeung.e
 * @since 2017-10-13
 */
@Data
public class SBJwtUserRequestDto {
	@Setter(AccessLevel.PRIVATE)
	private Long userId;

	public void setUid(Long userId) {
		this.userId = userId;
	}

	@Setter(AccessLevel.PRIVATE)
	private String nickname;

	public void setNnm(String nickname) {
		this.nickname = nickname;
	}

	@Setter(AccessLevel.PRIVATE)
	private String username;

	private void setUnm(String username) {
		this.username = username;
	}
}
