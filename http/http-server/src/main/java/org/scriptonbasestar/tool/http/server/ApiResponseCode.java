package org.scriptonbasestar.tool.http.server;

public enum ApiResponseCode {
	OK(200),
	BAD_REQUEST(400),
	NOT_FOUND(404),
	UNKNOWN_ERROR(500),
	OVER_SERVICE_LIMIT(600),
	REQUEST_DENIED(999),
	BAD_HEADER(1001),
	LOGIC_ERROR(1002),
	BAD_PARAMETER(1003),
	BAD_USERKEY(1004),
	NOT_EXIST_PARAMETER(1005),
	BAD_APINUMBER(1006);

	private int value;

	ApiResponseCode(int value) {
		this.value = value;
	}
}
