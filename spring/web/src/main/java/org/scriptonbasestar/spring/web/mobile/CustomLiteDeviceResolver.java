package org.scriptonbasestar.spring.web.mobile;

import org.springframework.mobile.device.LiteDeviceResolver;

import java.util.List;

/**
 * @athor archmagece
 * @since 2017-01-30 18
 *
 * 스프링 모바일 디바이스 체크할 때 사용할 기능
 *
 * 추가적인 디바이스가 있을 때 이거 추가해서 필터 생성
 */
public class CustomLiteDeviceResolver extends LiteDeviceResolver {
	public CustomLiteDeviceResolver(List<String> normalUserAgentKeywords, List<String> tabletUserAgentKeywords, List<String> mobileUserAgentKeywords){
		for(String header : normalUserAgentKeywords){
			super.getNormalUserAgentKeywords().add(header);
		}
		for(String header : tabletUserAgentKeywords){
			super.getTabletUserAgentKeywords().add(header);
		}
		for(String header : mobileUserAgentKeywords){
			super.getMobileUserAgentKeywords().add(header);
		}
	}
}