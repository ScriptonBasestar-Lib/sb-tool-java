package org.scriptonbasestar.tool.http.server.request;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author archmagece
 * @date 2015-10-13
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestExtractor {

	/**
	 * ip 가져오기.
	 *
	 * @param request
	 *
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getMACAddress(String ip) {
		String str = "";
		String macAddress = "";
		//FIXME 오류나서 제거.
//		try {
//			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
//			InputStreamReader ir = new InputStreamReader(p.getInputStream());
//			LineNumberReader input = new LineNumberReader(ir);
//			for (int i = 1; i <100; i++) {
//				str = input.readLine();
//				if (str != null) {
//					if (str.indexOf("MAC Address") > 1) {
//						macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
//						break;
//					}
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace(System.out);
//		}
		return macAddress;
	}

}
