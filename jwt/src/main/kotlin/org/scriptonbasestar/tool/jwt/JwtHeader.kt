package org.scriptonbasestar.tool.jwt

import com.google.gson.Gson
import java.util.*

class JwtHeader {
	companion object {
		val gson = Gson()
	}

	val json: String

	constructor(json: String) {
		this.json = json

	}

	val algorithm: String = "alg"

	enum class Algorithm {
		HS256, RS256
	}

	val type: String = "typ"

	enum class Type {
		JWT
	}

	fun toBase64() {
		Base64.getDecoder().decode(json)
	}
}
