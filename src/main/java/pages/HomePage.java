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

	@FindBy(css = "a[href*='television']")
	WebElement televisionMenuItem;

	@FindBy(id = "nav-link-accountList")
	WebElement signInLink;

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerMenuIcon;

	@FindBy(css = "a[data-menu-id='9']")
	WebElement hamburgerMenuTvItem;

	public SignInPage clickSignInLink() {

		signInLink.click();
		return new SignInPage(driver);
	}

	public void clickHamburgerMenu() throws InterruptedException {

		explicitWebElementWait(hamburgerMenuIcon);
		hamburgerMenuIcon.click();
		System.out.println("Top left hamburger menu is clicked.");
	}

	public void clickHamburgerMenuTVItem() {

		explicitWebElementWait(hamburgerMenuTvItem);
		hamburgerMenuTvItem.click();
		System.out.println("TV, Appliances and Electronics under Shop by Department section is clicked.");
	}

	public TelevisionsPage clickTelevisionMenuItem() {

		televisionMenuItem.click();
		System.out.println("Televisions under Tv, Audio & Cameras sub section is clicked.");
		return new TelevisionsPage(driver);

	}

}
