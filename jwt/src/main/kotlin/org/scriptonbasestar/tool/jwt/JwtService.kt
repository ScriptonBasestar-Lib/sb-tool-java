package org.scriptonbasestar.tool.jwt

class JwtService :JwtCreator, JwtValidator{
    override fun jwt(headerString: String, payloadString: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun compare(signatureString: String, jwtString: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}