package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.SamsungTVs;
import pages.SecondTV;
import pages.TelevisionsPage;
import utilities.RerunFailedTest;
import utilities.SwitchWindow;

public class SelectSamsungTV extends Base {

	@Test(groups = "main", retryAnalyzer = RerunFailedTest.class)
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
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("About this item", text);
		softAssert.assertAll();
	}

}
