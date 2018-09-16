package kr.scripton.biz.core.filter

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

//cucumber
@RunWith(Cucumber::class)
@CucumberOptions(
		features = ["src/test/resources/cucumber/features"],
		tags = ["not @ignored"])

class RunKukesTest