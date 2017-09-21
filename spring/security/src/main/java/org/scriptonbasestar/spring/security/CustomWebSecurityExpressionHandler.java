package org.scriptonbasestar.spring.security;

import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;


public class CustomWebSecurityExpressionHandler
		extends DefaultWebSecurityExpressionHandler {
	// public EvaluationContext createEvaluationContext(Authentication
	// authentication, FilterInvocation fi) {
	// StandardEvaluationContext ctx = (StandardEvaluationContext)
	// super.createEvaluationContext(authentication, fi);
	// SecurityExpressionRoot root = new
	// CustomWebSecurityExpressionRoot(authentication, fi);
	// ctx.setRootObject(root);
	// return ctx;
	// }
	// TODO 대체할거추가
}
