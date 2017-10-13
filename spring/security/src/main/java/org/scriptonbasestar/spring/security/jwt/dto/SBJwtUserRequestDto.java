package org.scriptonbasestar.spring.security.jwt.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author chaeeung.e
 * @since 2017-10-13
 *
 * jwt header 인증시 넣어준 값을
 * spring request parameter 받아서 쓰는용도
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
