package org.scriptonbasestar.spring.security.social.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-10-24
 */
public class SBSocialUser extends User {

	//social type enum이 되면 좋지않을까 싶기도 하지만lib니까
	private final String socialType;
	public SBSocialUser(String username, String socialType, Collection<? extends GrantedAuthority> authorities) {
		super(username, null, authorities);
		this.socialType = socialType;
	}
}
