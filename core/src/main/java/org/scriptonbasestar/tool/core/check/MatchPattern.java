package org.scriptonbasestar.tool.core.check;

import lombok.experimental.UtilityClass;

/**
 * @author archmagece
 * @since 2015-05-10
 */
@UtilityClass
public final class MatchPattern {
	public static final String username = "^[a-z0-9_-]{2,20}$";
	public static final String password = "^[a-zA-Z0-9_-]{6,18}$";
	public static final String hex = "^#?([a-f0-9]{6}|[a-f0-9]{3})$";
	public static final String slug = "^[a-z0-9-]+$";

	public static final String cellPhoneKorea = "^01([0|1|6|7|8|9]?)-\\d{3,4}-\\d{4}$";
	public static final String telePhoneKorea = "^\\d{2,4}-\\d{3,4}-\\d{4}$";
	//	http://phoneregex.com/
	public static final String phoneInternational = "^\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|4[987654310]|3[9643210]|2[70]|7|1)\\d{1,14}$";
	public static final String phoneUsCanada = "^\\d{2,4}-\\d{3,4}-\\d{4}$";
	public static final String telePhoneUsCanada = "^\\d{2,4}-\\d{3,4}-\\d{4}$";

	//	https://emailregex.com/
//	public static String email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
//	(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
	public static final String email = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	//	http://urlregex.com/
	public static String urlDomainHttp = "^(https?:\\/\\/)([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
	public static final String urlHttp = "^https?://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$";
	//	^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
	public static final String url = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]$";
	public static final String urlCustom = "^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+$";

	//	http://ipregex.com/
	public static final String ip = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	public static final String html = "^<([a-z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$";
}
