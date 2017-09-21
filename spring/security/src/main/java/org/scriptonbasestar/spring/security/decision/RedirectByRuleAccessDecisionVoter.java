package org.scriptonbasestar.spring.security.decision;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import java.util.Collection;

/**
 * Created by archmagece on 2015-09-02.
 */
public class RedirectByRuleAccessDecisionVoter implements AccessDecisionVoter {
	@Override
	public boolean supports(ConfigAttribute configAttribute) {
		return false;
	}

	@Override
	public int vote(Authentication authentication, Object o, Collection collection) {
		return 0;
	}

	@Override
	public boolean supports(Class aClass) {
		return false;
	}
}
