package utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {

	WebDriver driver;

	public SwitchWindow(WebDriver driver) {

		this.driver = driver;
	}

	public void switchToChild() {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> handle = windows.iterator();
		String parentID = handle.next();
		String childID = handle.next();
		driver.switchTo().window(childID);

	}

}
