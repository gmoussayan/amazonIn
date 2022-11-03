package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	WebDriver driver;

	public Waits(WebDriver driver) {

		this.driver = driver;

	}

	public void explicitLocatorWait(By findBy) {
		
		WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void explicitWebElementWait(WebElement webElement) {
		
		WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driverWait.until(ExpectedConditions.visibilityOf(webElement));

	}

}
