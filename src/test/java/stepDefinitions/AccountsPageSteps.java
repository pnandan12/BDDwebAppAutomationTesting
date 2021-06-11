package stepDefinitions;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
//import org.apache.hc.client5.http.SystemDefaultDnsResolver;
//import org.testng.Assert;

import com.qa.Factory.DriverFactory;
import com.qa.Pages.AccountsPage;
import com.qa.Pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private AccountsPage acPage= new AccountsPage(DriverFactory.getDriver());
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	   List <Map<String, String>>credList=credTable.asMaps();
	   String userName=credList.get(0).get("username");
	   String password=credList.get(0).get("password");
	   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    acPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	 acPage.getAccountsPageTitle();
	}

	

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expectedAccountSectionList=sectionsTable.asList();
		System.out.println("Expected Accountlist"+expectedAccountSectionList);
		List<String> actualAccountSectionList=acPage.getAccountSectionList();
		System.out.println("Actual Accountlist"+actualAccountSectionList);
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	    Assert.assertTrue(acPage.getAccountSectionCount()==expectedSectionCount);
	}
	@When("user gets the title of the account page")
	public void user_gets_the_title_of_the_account_page() {
		//String title=acPage.getAccountsPageTitle();
		//System.out.println("Ttile of the page :"+title);
	}


}
