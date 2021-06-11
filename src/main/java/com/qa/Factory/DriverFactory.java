package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal <WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	/**
	 * this method is used to initiate the thread local driver on the base of given browser
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("Browser is :"+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\chromedriver_win32\\chromedriver.exe");	
			//driver = new ChromeDriver(); 
			tlDriver.set(new ChromeDriver());	
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\geckodriver.exe");
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver", "C:\\Users\\shyam\\java-selenium\\drivers\\Edgedriver.exe");	
			//driver = new EdgeDriver(); 
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("Please pass the browser value :" +browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	
		
	}
	/**
	 * this method is used to get the driver with thread local
	 * @return
	 */
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}
}
