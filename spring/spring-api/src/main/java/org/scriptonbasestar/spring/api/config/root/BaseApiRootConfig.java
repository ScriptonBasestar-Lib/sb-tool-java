package org.scriptonbasestar.spring.api.config.root;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

/**
 * @author archmagece
 * @since 2015-02-10-15
 */
@Slf4j
@Configuration
@ComponentScan(
		includeFilters = {
				@ComponentScan.Filter(value = {Service.class}, type = FilterType.ANNOTATION)
		},
		excludeFilters = {
				@ComponentScan.Filter(value = {Configuration.class}, type = FilterType.ANNOTATION)
		}
)
@Import({BaseApiRootBeanConfig.class})
public abstract class BaseApiRootConfig {

}
