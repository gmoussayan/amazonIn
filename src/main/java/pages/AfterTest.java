package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class AfterTest {

	WebDriver driver;
	
	public AfterTest(WebDriver driver) {
		this.driver = driver;
	}
	
	public void quitDriver() throws IOException {
		
		driver.manage().deleteAllCookies();
		driver.quit();
		
	}

}
