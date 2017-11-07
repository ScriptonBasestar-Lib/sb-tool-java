package org.scriptonbasestar.spring.security.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.security.access.expression.ExpressionUtils;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.util.SimpleMethodInvocation;

import java.lang.reflect.Method;

/**
 * @author chaeeung.e
 * @since 2017-11-07
 */
@Slf4j
public class SecurityCheckService {

	private static final Method triggerCheckMethod;
	private static final SpelExpressionParser parser;

	private class SecurityObject {
		void triggerCheck() { /*NOP*/}
	}

	static {
		try {
			triggerCheckMethod = SecurityObject.class.getMethod("triggerCheck");
		} catch (NoSuchMethodException e) {
			System.err.println(e);
			throw new RuntimeException("SecurityCheckService. static initial error");
		}
		parser = new SpelExpressionParser();
	}

	private final MethodSecurityExpressionHandler expressionHandler;

	public SecurityCheckService(MethodSecurityExpressionHandler expressionHandler){
		this.expressionHandler = expressionHandler;
	}


	public boolean check(String securityExpression){
		if(log.isDebugEnabled()){
			log.debug("Checking security expression [%s]...", securityExpression);
		}
		SecurityObject securityObject = new SecurityObject();
		//MethodSecurityExpressionHandler expressionHandler = ContextLoader.getCurrentWebApplicationContext().getBean(DefaultMethodSecurityExpressionHandler.class);
		EvaluationContext evaluationContext = expressionHandler.createEvaluationContext(SecurityContextHolder.getContext().getAuthentication(), new SimpleMethodInvocation(securityObject, triggerCheckMethod));
		boolean checkResult = ExpressionUtils.evaluateAsBoolean(parser.parseExpression(securityExpression), evaluationContext);

		if (log.isDebugEnabled()) {
			log.debug("Check result: " + checkResult);
		}

		return checkResult;
	}

}
