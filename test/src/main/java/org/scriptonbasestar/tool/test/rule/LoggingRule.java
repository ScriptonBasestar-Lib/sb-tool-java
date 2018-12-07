package org.scriptonbasestar.tool.test.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-11 19
 */
public class LoggingRule
	implements TestRule {

	public class LoggingStatement
		extends Statement {

		private final Statement statement;

		public LoggingStatement(Statement aStatement) {
			statement = aStatement;
		}

		@Override
		public void evaluate() throws Throwable {
			System.out.println("before: " + statement);
			statement.evaluate();
			System.out.println("after: " + statement);
		}

	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new LoggingStatement(base);
	}
}
