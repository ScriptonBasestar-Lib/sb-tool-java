package org.scriptonbasestar.tool.taglib.tag;

import org.scriptonbasestar.tool.core.prop.PropGetter;

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
public class PropTag extends SimpleTagSupport {

//	@Setter
	private PropGetter prop;
	public PropTag(PropGetter prop){
		this.prop = prop;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = super.getJspContext().getOut();

		StringWriter sw = new StringWriter();
		JspFragment body = getJspBody();
		if(body!=null){
			body.invoke(sw);
		}
//		sw.toString() == name
		out.print(prop.getProperty(sw.toString()));
	}

}
