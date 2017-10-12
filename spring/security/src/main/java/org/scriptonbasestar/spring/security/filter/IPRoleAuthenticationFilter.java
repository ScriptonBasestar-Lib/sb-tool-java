package org.scriptonbasestar.spring.security.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
public class IPRoleAuthenticationFilter
		extends OncePerRequestFilter {

	@Getter
	@Setter
	private String targetRole;

	@Getter
	@Setter
	private List<String> allowedIPAddresses;

	@Override
	public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws
				IOException,
				ServletException {

		// before we allow the request to proceed, we'll first get the user's
		// findUserRole
		// and see if it's an administrator
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && targetRole != null) {
			boolean shouldCheck = false;
			// look if the user is the target findUserRole
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (authority.getAuthority().equals(
						targetRole)) {
					shouldCheck = true;
					break;
				}
			}
			// if we should check IP, then check
			if (shouldCheck && allowedIPAddresses.size() > 0) {
				boolean shouldAllow = false;
				for (String ipAddress : allowedIPAddresses) {
					if (req.getRemoteAddr().equals(
							ipAddress)) {
						shouldAllow = true;
						break;
					}
				}

				if (!shouldAllow) {
					// fail the request
					throw new AccessDeniedException("Access has been denied for your IP address: " + req.getRemoteAddr());
				}
			}
		} else {
			log.warn("The IPRoleAuthenticationFilter should be placed after the user has been authenticated in the filter chain.");
//			logger.warn("The IPRoleAuthenticationFilter should be placed after the user has been authenticated in the filter chain.");
		}
		chain.doFilter(
				req, res);
	}
}
