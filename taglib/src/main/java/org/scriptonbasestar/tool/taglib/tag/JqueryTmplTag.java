package org.scriptonbasestar.tool.taglib.tag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author archmagece
 * @since 2014. 9. 5.
 */
public class JqueryTmplTag extends SimpleTagSupport {
	private final static String outputBody = "<script id=\"%s\" type=\"%s\">%s</script>";

	@Getter
	@Setter
	private String id = "jquery-tmpl-id";

	@Getter
	@Setter
	private String type = "text/x-jquery-tmpl";

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = super.getJspContext().getOut();

		StringWriter sw = new StringWriter();
		JspFragment body = getJspBody();
		if(body!=null){
			body.invoke(sw);
		}
		out.print(String.format(outputBody, id, type, sw.toString()));
	}

}
