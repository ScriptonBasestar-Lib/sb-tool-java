package org.scriptonbasestar.tool.logging;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-08-10-13
 */
@Data
public class LoggingDto implements Serializable {

	private String message;
	private String logger;
	private String thread;
	private Date timestamp;
	private String level;
	private String hostname;
	private String profileName;
}
