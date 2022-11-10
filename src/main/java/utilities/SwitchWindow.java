package utilities;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {

	WebDriver driver;

	public SwitchWindow(WebDriver driver) {

		this.driver = driver;
	}

	public void switchToChild() {

		System.out.println("Switching to child window");
		String originalWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

}
