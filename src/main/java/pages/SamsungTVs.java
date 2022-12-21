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
	WebElement highToLowOption;

	@FindBy(css = "a[class='a-link-normal s-no-outline']")
	List<WebElement> tvResults;

	@FindBy(xpath = "(//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small'])[2]")
	WebElement tvResult;

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

		explicitWebElementWait(tvResult);
		tvResult.click();
		System.out.println("Second highest priced Samsung TV is selected");

		return new SecondTV(driver);

	}

	public SwitchWindow switchWindow() {

		return new SwitchWindow(driver);
	}

}
