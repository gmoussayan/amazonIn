package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class SecondTV extends Waits {

	WebDriver driver;

	public SecondTV(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h1[class='a-size-base-plus a-text-bold'")
	WebElement textLocator;

	@FindBy(css = "h1[class='a-size-base-plus a-text-bold'")
	WebElement text;

	public void waitForTextToBeVisible() {

		explicitWebElementWait(textLocator);
	}

	public String getText() {

		System.out.println(text.getText());
		return text.getText();

	}

}
