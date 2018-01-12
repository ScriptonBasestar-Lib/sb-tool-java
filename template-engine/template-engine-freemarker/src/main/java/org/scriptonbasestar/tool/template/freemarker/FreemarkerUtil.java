package org.scriptonbasestar.tool.template.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.scriptonbasestar.tool.core.prop.ResourceReader;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by archmagece on 2016-04-22.
 */
public class FreemarkerUtil {

	Configuration cfg;
	public FreemarkerUtil() throws IOException {
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.24) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		cfg = new Configuration(Configuration.VERSION_2_3_23);

		// Specify the source where the template files come from. Here I set a
		// plain directory for it, but non-file-system sources are possible too:
		cfg.setDirectoryForTemplateLoading(new File(ResourceReader.resourceRootPath(FreemarkerUtil.class)+"/email"));

		// Set the preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		cfg.setDefaultEncoding("UTF-8");

		// Sets how errors will appear.
		// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
//		cfg.setTesetLogTemplateExceptions(false);
	}

//	public String makeTemplate(String templateName, Map<String, Object> root) throws IOException, TemplateException {
	public String makeTemplate(String templateName, Object root) throws IOException, TemplateException {
		        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
//		Map<String,Object> root = new HashMap();
//		root.put("signupUrl", "Big Joe");
//		root.put("code", "Big Joe");
//		root.put("link", "Big Joe");
//		root.put("exit", "Big Joe");

        /* Get the template (uses cache internally) */
//		Template temp = cfg.getTemplate("email-test.html");
		Template temp = cfg.getTemplate(templateName+".html");

		Writer out = new StringWriter();
		temp.process(root, out);
		out.close();
		return out.toString();
		// Note: Depending on what `out` is, you may need to call `out.close()`.
		// This is usually the case for file output, but not for servlet output.
	}


}
