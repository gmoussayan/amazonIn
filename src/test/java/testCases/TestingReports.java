package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.SignInPage;

public class TestingReports extends Base {

	@Test(groups = { "main" })
	public void iFailTestCase() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail("test@test.com");
		signInPage.enteringPassword("theP@$$w0rd");
		System.out
				.println("I'm the failed test! You can check the screenshot in the HTML report under reports folder.");
		Assert.assertFalse(true);
		softAssert.assertFalse(true);
		softAssert.assertAll();

	}

	@Test(groups = { "main" })
	public void iSucceedTestCase() throws IOException, InterruptedException {

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail("test@test.com");
		signInPage.enteringPassword("theP@$$w0rd");
		System.out.println("A bientot!");

	}

	@DataProvider
	public Object[][] testData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\testData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
