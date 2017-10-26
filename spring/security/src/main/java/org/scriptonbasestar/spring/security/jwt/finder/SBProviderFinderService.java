package org.scriptonbasestar.spring.security.jwt.finder;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2017-10-12
 */
public interface SBProviderFinderService {
	Collection<String> AurhoritybyRoleName(String roleName);
}
