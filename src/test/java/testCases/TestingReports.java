package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

public class TestingReports extends Base {

	@Test(groups = { "main" })
	public void selectSamsungTV2() throws IOException, InterruptedException {

		homePage.clickHamburgerMenu();

	}

	@Test
	public void selectSamsungTV3() throws IOException, InterruptedException {

		homePage.clickHamburgerMenuTVItem();

	}

	@DataProvider
	public Object[][] testData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\testData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
