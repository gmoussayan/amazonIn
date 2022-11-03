package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SwitchWindow;
import utilities.Waits;

public class SamsungTVs extends Waits{
	
	WebDriver driver;
	
	public SamsungTVs(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By dropdown = By.id("a-autoid-0-announce");
	By highToLowSort = By.id("s-result-sort-select_2");
	
	public void dropdownIsVisible() {

		explicitLocatorWait(dropdown);

	}

	public void clickDropdown() {

		driver.findElement(dropdown).click();

	}

	public void clickHighToLow() {

		driver.findElement(highToLowSort).click();

	}
	
	@FindBy(css = "a[class='a-link-normal s-no-outline']")
	List<WebElement> tvResults;

	public SecondTV secondTVFromList() {

		for (int i = 0; i < tvResults.size(); i++) {

			if (i == 1) {

				tvResults.get(i).click();
				System.out.println("clicked Twoooo!");
				break;

			}

		}

		return new SecondTV(driver);

	}
	
	public SwitchWindow switchWindow() {
	
	return new SwitchWindow(driver);
}

}
