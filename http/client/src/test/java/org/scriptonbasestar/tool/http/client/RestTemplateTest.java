package org.scriptonbasestar.tool.http.client;

import org.apache.http.impl.client.HttpClients;

/**
 * @author chaeeung.e
 * @since 2017-09-01
 */
public class RestTemplateTest {

//	public static void main(String[] args) {
//		ClientHttpRequestFactory requestFactory = new
//				HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
//		restTemplate = new RestTemplate(requestFactory);
//		List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
//		for(HttpMessageConverter<?> converter : converters){
//			if(converter instanceof MappingJackson2HttpMessageConverter){
//				ObjectMapper objectMapper = ((MappingJackson2HttpMessageConverter) converter).getObjectMapper();
//				objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//				SimpleModule simpleModule = new SimpleModule();
////				simpleModule.addSerializer();
////				simpleModule.addDeserializer();
//				objectMapper.registerModule(simpleModule);
//			}
//		}
//	}

}
