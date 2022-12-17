package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Scroll;
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
	WebElement highToLowOption;

	@FindBy(css = "a[class='a-link-normal s-no-outline']")
	List<WebElement> tvResults;

	public void dropdownIsVisible() {

		explicitWebElementClickable(dropdown);

	}

	public void clickDropdown() {

		dropdown.click();

	}

	public void clickHighToLow() {

		highToLowOption.click();
		System.out.println("High to Low price sorting is applied.");

	}

	public SecondTV secondTVFromList() throws InterruptedException {

		explicitAllWebElementWait(tvResults);
		for (int i = 0; i < tvResults.size(); i++) {

			if (i == 1) {

				Scroll scroll = new Scroll(driver);
				scroll.scrollIntoView(tvResults.get(i));

				tvResults.get(i).click();
				System.out.println("Second highest priced Samsung TV is selected");
				break;

			}

		}

		return new SecondTV(driver);

	}

	public SwitchWindow switchWindow() {

		return new SwitchWindow(driver);
	}

}
