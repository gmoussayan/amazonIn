package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {

	WebDriver driver;

	public Scroll(WebDriver driver) {

		this.driver = driver;
	}

	public void scrollIntoView(WebElement element) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);

	}

}
