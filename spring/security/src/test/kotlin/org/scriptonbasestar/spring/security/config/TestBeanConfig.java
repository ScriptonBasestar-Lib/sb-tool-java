package org.scriptonbasestar.spring.security.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author archmagece
 * @date 2015-12-09
 */
@Slf4j
@Configuration
public class TestBeanConfig {
	@Bean
	public EnvironmentStringPBEConfig EnvironmentVariablesConfiguration() {
		EnvironmentStringPBEConfig conf = new EnvironmentStringPBEConfig();
		conf.setAlgorithm("PBEWithMD5AndDES");
		conf.setPasswordEnvName("APP_ENCRYPTION_PASSWORD");
		return conf;
	}
	@Bean
	public StandardPBEStringEncryptor ConfigurationEncryptor() {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setConfig(this.EnvironmentVariablesConfiguration());
		encryptor.setPassword("9pwc3dke");
		return encryptor;
	}
}