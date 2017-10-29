package org.scriptonbasestar.tool.jwt

import java.util.*

class JwtPayload(val json: String) {
    fun toBase64(){
        Base64.getDecoder().decode(json)
    }
}
