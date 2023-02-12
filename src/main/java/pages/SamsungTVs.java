package pages;

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

	@FindBy(css = "span[id='a-autoid-0'] span[id='a-autoid-0-announce']")
	WebElement dropdown;

	@FindBy(id = "s-result-sort-select_2")
	WebElement highToLowOption;

	@FindBy(xpath = "//div[@cel_widget_id=\"MAIN-SEARCH_RESULTS-2\"] //div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']")
	WebElement tvResult;

	public void dropdownIsVisible() {

		explicitWebElementClickable(dropdown);

	}

	public void clickDropdown() {

		dropdown.click();

	}

	public void clickHighToLow() throws InterruptedException {

		highToLowOption.click();
		Thread.sleep(3000);
		System.out.println("High to Low price sorting is applied.");

	}

	public SecondTV secondTVFromList() throws InterruptedException {

		explicitWebElementWait(tvResult);
		tvResult.click();
		System.out.println("Second highest priced Samsung TV is selected");

		return new SecondTV(driver);

	}

	public SwitchWindow switchWindow() {

		return new SwitchWindow(driver);
	}

}
