package org.scriptonbasestar.tool.core.check;

/**
 * @author archmagece
 * @since 2015-05-10
 */
public final class MatchPattern {
	public static String username = "^[a-z0-9_-]{3,16}$";
	public static String password = "^[a-z0-9_-]{6,18}$";
	public static String hex = "^#?([a-f0-9]{6}|[a-f0-9]{3})$";
	public static String slug = "^[a-z0-9-]+$";
	public static String email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
	//	public static String urlDomainHttp = "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
	public static String urlDomainHttp = "^(https?:\\/\\/)([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";
	public static String urlCustom = "^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+";
	public static String ip = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
	public static String html = "^<([a-z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$";
}
