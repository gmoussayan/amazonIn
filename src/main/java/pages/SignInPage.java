package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waits;

public class SignInPage extends Waits {

	WebDriver driver;

	public SignInPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ap_email")
	WebElement email;

	@FindBy(css = "span[id='continue']")
	WebElement continueButton;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "signInSubmit")
	WebElement signInButton;

	@FindBy(css = "div[id='auth-error-message-box'] span[class='a-list-item']")
	WebElement errorMessage;

	public void enteringEmail(String username) {

		explicitWebElementWait(email);
		email.sendKeys(username);
		continueButton.click();

	}

	public void enteringPassword(String passcode) {

		explicitWebElementWait(password);
		password.sendKeys(passcode);
		signInButton.click();

	}

	public String grabingErrorMessage() {

		explicitWebElementWait(errorMessage);
		return errorMessage.getText();

	}

}
