package org.scriptonbasestar.spring.security.jwt

import io.jsonwebtoken.Claims
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
class JwtCookieUtil{
	companion object {
		fun tokenToCookie(response: HttpServletResponse, serviceName:String, signingKey:String, claims: Claims){
			var cookie = Cookie(serviceName, JwtUtil.generateToken(signingKey, claims))
			cookie.isHttpOnly = true
			cookie.secure = true
			//param??
//			cookie.domain = ""
			//다음서버로 전송되기까지의 시간만
			cookie.maxAge = 30 * 1000
			response.addCookie(cookie)
		}

		fun tokenFromCookie(request: HttpServletRequest, serviceName: String, signingKey: String):Claims? {
			request.cookies.forEach { if ( it.value.equals(serviceName)) return JwtUtil.extractClaims(signingKey, it.value) }
			return null
		}
	}
}