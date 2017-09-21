/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.scriptonbasestar.spring.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


/**
 * An {@link org.springframework.security.core.Authentication} implementation that is designed for simple presentation
 * of a username and password.
 * <p>
 * The <code>principal</code> and <code>credentials</code> should be set with an <code>Object</code> that provides
 * the respective property via its <code>Object.toString()</code> method. The simplest such <code>Object</code> to use
 * is <code>String</code>.
 *
 * @author Ben Alex
 */
public class UsernameOnlyAuthenticationToken extends UsernamePasswordAuthenticationToken {

	public UsernameOnlyAuthenticationToken(Object principal) {
		super(principal, null);
	}
	public UsernameOnlyAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}
}
