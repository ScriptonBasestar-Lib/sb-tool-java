package org.scriptonbasestar.tool.jwt.token

import org.scriptonbasestar.tool.jwt.JwtHeader
import org.scriptonbasestar.tool.jwt.JwtPayload

class JwtEncodedToken(val header: JwtHeader, val payload: JwtPayload)