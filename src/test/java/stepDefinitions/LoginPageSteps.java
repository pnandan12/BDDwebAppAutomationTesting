package stepDefinitions;



import org.junit.Assert;

import com.qa.Factory.DriverFactory;
import com.qa.Pages.LoginPage;

//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private  String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	  
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
		title=loginPage.getLoginPageTitle();
		System.out.println("Ttile of the page :"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		System.out.println("Ttile of the page ***"+expectedTitle);
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	  Assert.assertTrue(loginPage.isForgetPwdLink());
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username) {
	   loginPage.enterUserName(username);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String password) {
	   loginPage.enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    loginPage.clickOnSignInButton();
	}
	
	/*@Given("^user is on login page")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user gets title of the page")
	public void user_gets_title_of_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^forgot password link should be displayed$")
	public void forgot_password_link_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user enters the username \"([^\"]*)\"$")
	public void user_enters_the_username(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user enters the password \"([^\"]*)\"$")
	public void user_enters_the_password(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user click on login button")
	public void user_click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user gets the titile of the home page")
	public void user_gets_the_titile_of_the_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
*/

	

}
