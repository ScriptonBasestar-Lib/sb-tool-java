package org.scriptonbasestar.tool.jwt

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import org.scriptonbasestar.tool.jwt.token.JwtDecodedToken
import org.scriptonbasestar.tool.jwt.token.JwtEncodedToken

/**
 * @author chaeeung.e
 * @since 2017-10-30
 */
class JwtUtil {
	companion object {
		private val gson = GsonBuilder().create()
		private val jp = JsonParser()
		fun encodedJson(jsonText:String): String {
			var elem = jp.parse(jsonText)
			return gson.toJson(elem)
		}
	}
}