package org.scriptonbasestar.tool.jwt

import java.util.*

class JwtHeader(val json: String) {
    val algorithm:String = "alg"
    enum class Algorithm {
        HS256, RS256
    }
    val type:String="typ"
    enum class Type {
        JWT
    }
    fun toBase64(){
        Base64.getDecoder().decode(json)
    }
}
