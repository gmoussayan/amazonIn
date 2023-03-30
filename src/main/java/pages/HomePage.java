package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class HomePage extends Waits {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='hmenu-content'] //a[contains(text(), 'Televisions')]")
	WebElement televisionMenuItem;

	@FindBy(id = "nav-link-accountList")
	WebElement signInLink;

	@FindBy(css = "a[id ='nav-hamburger-menu'] i[class='hm-icon nav-sprite']")
	WebElement hamburgerMenuIcon;

	@FindBy(xpath = "//div[@id='hmenu-container' and @class='celwidget nav-sprite-v1 hmenu-visible']")
	WebElement hmenuVisible;

	@FindBy(css = "div[id='hmenu-content'] a[data-menu-id='9']")
	WebElement hamburgerMenuTvItem;

	public SignInPage clickSignInLink() {

		signInLink.click();
		return new SignInPage(driver);
	}

	public void clickHamburgerMenu() throws InterruptedException {

		Thread.sleep(2000);
		explicitWebElementClickable(hamburgerMenuIcon);
		hamburgerMenuIcon.click();
		System.out.println("Top left hamburger menu is clicked.");
		Thread.sleep(3000);
	}

	public void clickHamburgerMenuTVItem() throws InterruptedException {

		explicitWebElementWait(hmenuVisible);
		explicitWebElementClickable(hamburgerMenuTvItem);
		hamburgerMenuTvItem.click();
		System.out.println("TV, Appliances and Electronics under Shop by Department section is clicked.");
		Thread.sleep(2000);

	}

	public TelevisionsPage clickTelevisionMenuItem() {

		explicitWebElementWait(televisionMenuItem);
		televisionMenuItem.click();
		System.out.println("Televisions under Tv, Audio & Cameras sub section is clicked.");
		return new TelevisionsPage(driver);

	}

}
