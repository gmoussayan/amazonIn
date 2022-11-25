package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SwitchWindow;
import utilities.Waits;

public class SamsungTVs extends Waits {

	WebDriver driver;

	public SamsungTVs(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "a-autoid-0-announce")
	WebElement dropdown;

	@FindBy(id = "s-result-sort-select_2")
	WebElement highToLowSort;

	@FindBy(css = "a[class='a-link-normal s-no-outline']")
	List<WebElement> tvResults;

	public void dropdownIsVisible() {

		explicitWebElementWait(dropdown);

	}

	public void clickDropdown() {

		dropdown.click();

	}

	public void clickHighToLow() {

		highToLowSort.click();

	}

	public SecondTV secondTVFromList() {

		explicitAllWebElementWait(tvResults);
		for (int i = 0; i < tvResults.size(); i++) {

			if (i == 1) {

				tvResults.get(i).click();
				System.out.println("Second TV from list is now clicked");
				break;

			}

		}

		return new SecondTV(driver);

	}

	public SwitchWindow switchWindow() {

		return new SwitchWindow(driver);
	}

}
