package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utilities.GoToURL;

public class Base {

	public WebDriver driver;
	public HomePage homePage;

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fileInput = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\config.properties");

		Properties props = new Properties();
		props.load(fileInput);

		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: props.getProperty("browser");

		if (browser.contains("chrome")) {

			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().clearDriverCache().setup();

			if (browser.contains("headless")) {

				chromeOptions.addArguments("--headless=new");

			}

			chromeOptions.addArguments("--window-size=1920,1080");
			chromeOptions.addArguments("--window-position=0,0");
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeOptions);

		}

		else if (browser.contains("firefox")) {

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().clearDriverCache().setup();

			if (browser.contains("headless")) {

				firefoxOptions.addArguments("--headless");

			}

			firefoxOptions.addArguments("--window-size=1920,1080");
			firefoxOptions.addArguments("--window-position=0,0");
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new FirefoxDriver(firefoxOptions);

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().deleteAllCookies();
		return driver;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}

	@BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException {

		driver = initializeDriver();
		homePage = new HomePage(driver);
		GoToURL goToURL = new GoToURL(driver);
		goToURL.goTo();
		return homePage;

	}

	@AfterMethod(alwaysRun = true)
	public void afterFinishingTest() {

		driver.manage().deleteAllCookies();
		driver.quit();

	}

}
