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
	List<WebElement> navigationLabels;

	public SamsungTVs loopNavLabelsForSamsung() throws InterruptedException {

		explicitAllWebElementWait(navigationLabels);
		for (int i = 0; i < navigationLabels.size(); i++) {

			if (navigationLabels.get(i).getText().equalsIgnoreCase("Samsung")) {

				navigationLabels.get(i).click();
				System.out.println("Samsung brand checkbox is selected.");
				break;

			}

		}

		return new SamsungTVs(driver);
	}

}
