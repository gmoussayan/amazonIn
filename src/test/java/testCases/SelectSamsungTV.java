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
import utilities.RerunFailedTest;
import utilities.SwitchWindow;

public class SelectSamsungTV extends Base {

	@Test(groups = { "main" }, retryAnalyzer = RerunFailedTest.class)
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
		Assert.assertEquals("About this item", text);

	}

	@DataProvider
	public Object[][] testData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\testData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
