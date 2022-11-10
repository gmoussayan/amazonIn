package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// By hamburgerMenuTvItem = By.cssSelector("a[data-menu-id='9']");
	By televisionMenuItem = By.cssSelector("a[href*='television']");
	By signInLink = By.id("nav-link-accountList");

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerMenuIcon;

	@FindBy(css = "a[data-menu-id='9']")
	WebElement hamburgerMenuTvItem;

	public SignInPage clickSignInLink() {

		driver.findElement(signInLink).click();
		return new SignInPage(driver);
	}

	public void clickHamburgerMenu() {

		hamburgerMenuIcon.click();
	}

	public void clickHamburgerMenuTVItem() {

		driver.findElement(hamburgerMenuTvItem).click();
	}

	public TelevisionsPage clickTelevisionMenuItem() {

		driver.findElement(televisionMenuItem).click();
		return new TelevisionsPage(driver);
	}

}
