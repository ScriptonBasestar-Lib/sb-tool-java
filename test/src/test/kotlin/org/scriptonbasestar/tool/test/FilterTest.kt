package kr.scripton.biz.core.filter

import cucumber.api.CucumberOptions
import cucumber.api.PendingException
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java8.En
import cucumber.api.junit.Cucumber
import kr.scripton.biz.core.exception.NoParameterException
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.mock.web.MockFilterChain
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import java.security.MessageDigest
import java.util.*

//@RunWith(Cucumber::class)
//@CucumberOptions()
class FilterTest : En{

	fun test(){
//	init{
		Given("I have {int} cukes in my belly"){ int1: Int ->
			// Write code here that turns the phrase above into concrete actions
//			throw PendingException()
//			int1 = 42
			println("====================================")
			println(int1)
		}

		When("I wait {int} hour"){ int1: Int ->
			// Write code here that turns the phrase above into concrete actions
//			throw PendingException()
			1
		}

		Then("my belly should growl"){
			// Write code here that turns the phrase above into concrete actions
//			throw PendingException()
			2
			when(true).thenReturn()
		}
	}

//	private lateinit var filter: GlobalNonceCheckFilter
//	val md = MessageDigest.getInstance("MD5")
//
////	@Before
//	@Given("^비포여 비포 $")
//	fun before() {
//		//given all
//		filter = GlobalNonceCheckFilter()
//		filter.setBeanName("testNonceFilter")
//	}
//
//	@When("웬이야")
////	@Test(expected = NoParameterException::class)
//	fun `nonceFilterTest - empty header`() {
//		//given
//		val mockChain = MockFilterChain()
//		val req = MockHttpServletRequest("POST", "/resource/dev/file")
//		val rsp = MockHttpServletResponse()
//
//		//when
//		filter.doFilter(req, rsp, mockChain)
//
//		//then
////		assertEquals("/maintenance.jsp", rsp.getLastRedirect())
//	}
//
//	@When("이것도웬이야")
////	@Test(expected = NoParameterException::class)
//	fun `nonceFilterTest - nonce duplicate`() {
//		//given
//		val mockChain = MockFilterChain()
//		val req = MockHttpServletRequest("POST", "/resource/dev/file")
//		val rsp = MockHttpServletResponse()
//
//		val randomNonce = md.digest(Random().nextInt().toString().toByteArray())
//		req.addHeader(GlobalNonceCheckFilter.DEFAULT_NONCE_NAME, randomNonce)
//
//		//when
//		filter.doFilter(req, rsp, mockChain)
//
//		//then
////		assertEquals("/maintenance.jsp", rsp.getLastRedirect())
//	}
}