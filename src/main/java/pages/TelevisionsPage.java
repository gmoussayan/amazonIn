package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class TelevisionsPage extends Waits {

	WebDriver driver;

	public TelevisionsPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[class='a-link-normal']")
	List<WebElement> leftNavLabels;

	public SamsungTVs loopNavLabelsForSamsung() throws InterruptedException {

		Thread.sleep(3000);
		for (int i = 0; i < leftNavLabels.size(); i++) {

			if (leftNavLabels.get(i).getText().equalsIgnoreCase("Samsung")) {

				leftNavLabels.get(i).click();
				System.out.println("Samsung checkbox is clicked");
				break;

			}

		}
		return new SamsungTVs(driver);
	}

}
