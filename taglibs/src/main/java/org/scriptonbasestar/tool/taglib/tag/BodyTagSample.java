package org.scriptonbasestar.tool.taglib.tag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2014-09-11-16
 */
public class BodyTagSample extends BodyTagSupport {

	private final static String outputBody = "<script id=\"%s\" type=\"%s\">%s</script>";

	@Getter
	@Setter
	private String id = "jquery-tmpl-id";

	@Getter
	@Setter
	private String type = "text/x-jquery-tmpl";

	private PageContext pageContext;
	private Tag parentTag;

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	public Tag getParent() {
		return this.parentTag;
	}


	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			BodyContent bodyc=getBodyContent();
			System.out.println("===========================");
			System.out.println(bodyc);
			System.out.println("===========================");
			String body = null;
			if(getBodyContent()==null){
				body = "";
			}else{
				body = getBodyContent().getString();
			}

			out.print(String.format(outputBody, id, type,body));
		} catch (Exception e) {
			e.printStackTrace();
//			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}

}
