package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class GoToURL {

	WebDriver driver;

	public GoToURL(WebDriver driver) {

		this.driver = driver;
	}

	public void goTo() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\utilities\\config.properties");
		
		prop.load(fileInput);
		
		String url = prop.getProperty("url");

		driver.get(url);
	}

}
