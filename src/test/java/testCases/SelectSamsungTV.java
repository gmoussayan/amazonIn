package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.SamsungTVs;
import pages.SecondTV;
import pages.TelevisionsPage;
import utilities.SwitchWindow;

public class SelectSamsungTV extends Base {

	@Test(groups = { "main" })
	public void selectSamsungTV() throws IOException, InterruptedException {

		homePage.clickHamburgerMenu();
		homePage.clickHamburgerMenuTVItem();
		TelevisionsPage televisionsPage = homePage.clickTelevisionMenuItem();
		SamsungTVs samsungTVs = televisionsPage.loopNavLabelsForSamsung();
		samsungTVs.dropdownIsVisible();
		samsungTVs.clickDropdown();
		samsungTVs.clickHighToLow();
		SecondTV secondTV = samsungTVs.secondTVFromList();

		SwitchWindow switchWindow = samsungTVs.switchWindow();
		switchWindow.switchToChild();

		secondTV.waitForTextToBeVisible();
		String text = secondTV.getText();
		Assert.assertEquals("maybe", text);

	}

	@Test(groups = { "main" }, dataProvider = "testData", dependsOnMethods = { "selectSamsungTV" })
	public void afterSelectSamsungTVMethod(HashMap<String, String> theMap) {

		System.out.println("I run after selectSamsugTV Method");
		System.out.println(theMap.get("email"));
		System.out.println(theMap.get("password"));
		System.out.println(theMap.get("color"));
		Assert.assertEquals("green", theMap.get("color"));

	}

	@DataProvider
	public Object[][] testData() throws IOException {

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "test@test.com");
//		map.put("password", "thePassword");
//		map.put("color", "green");
//
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map.put("email", "test2@test.com");
//		map.put("password", "thePassword2");
//		map.put("color", "green2");

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\testData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
