package org.scriptonbasestar.tool.jwt

interface JwtCreator {
    fun jwt(headerString:String, payloadString:String):String
}