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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
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

				chromeOptions.addArguments("headless");

			}

			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeOptions);

		}

		else if (browser.contains("firefox")) {

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().clearDriverCache().setup();

			if (browser.contains("headless")) {

				firefoxOptions.addArguments("--headless");

			}

			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new FirefoxDriver(firefoxOptions);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.manage().window().setPosition(new Point(0, 0));
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
