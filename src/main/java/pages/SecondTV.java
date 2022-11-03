package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class SecondTV extends Waits{
	
	WebDriver driver;
	
	public SecondTV(WebDriver driver) {
		
		super(driver);		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By textLocator = By.cssSelector("h1[class='a-size-base-plus a-text-bold'");
	
	@FindBy(css = "h1[class='a-size-base-plus a-text-bold'")
	WebElement text;
	
	public void waitForTextToBeVisible() {
		
		explicitLocatorWait(textLocator);
	}
	
	public void assertText() {
		
		System.out.println(text.getText());
		//return new AfterTest(driver);
		
	}
	

}
