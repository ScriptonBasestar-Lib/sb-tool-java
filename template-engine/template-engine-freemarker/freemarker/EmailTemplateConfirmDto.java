package org.beansugar.sso.web.user.beanutil.freemarker;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by archmagece on 2016-04-22.
 */
@Data
public class EmailTemplateConfirmDto implements Serializable {
	private String code;
	private String link;
	private String exit;
}
