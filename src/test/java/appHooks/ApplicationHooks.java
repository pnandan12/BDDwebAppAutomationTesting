package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;
import com.qa.Util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop=configReader.init_Properties();	
	}
	@Before(order=1)
	public void launhcBrowser() {
		String browserName= prop.getProperty("browser");
		driverFactory= new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order=1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot:
			String screenshotName=scenario.getName().replaceAll("", "_");
			byte [] sourcepath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
			
		}
	}
}
