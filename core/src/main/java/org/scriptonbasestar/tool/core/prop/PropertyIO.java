package org.scriptonbasestar.tool.core.prop;

import org.scriptonbasestar.tool.core.check.Check;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-06-22-11
 */
public class PropertyIO extends Properties {

	public PropertyIO(String path, Properties properties) throws IOException {
		Check.notNull(properties, "properties must not null");
		store(new FileWriter(path), "property io bean");
	}

}
