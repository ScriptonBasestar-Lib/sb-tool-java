package org.scriptonbasestar.tool.jwt

interface JwtValidator {
    fun compare(signatureString: String, jwtString: String): Boolean
}