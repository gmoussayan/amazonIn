package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.SignInPage;

public class TestingReports extends Base {

	@Test(dataProvider = "testData", groups = "main")
	public void iFailTestCase(HashMap<String, String> data) throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail(data.get("email"));
		signInPage.enteringPassword(data.get("password"));
		String text = "Your password is incorrect";
		System.out.println(data.get("message"));
		softAssert.assertEquals(text, "Your password is IN correct");
		softAssert.assertAll();

	}

	@Test(dataProvider = "testData", groups = "main")
	public void iSucceedTestCase(HashMap<String, String> data) throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail(data.get("email"));
		signInPage.enteringPassword(data.get("password"));
		String text2 = "Your password is incorrect";
		softAssert.assertEquals(text2, "Your password is incorrect");
		System.out.println("A bientot!");
		softAssert.assertAll();

	}

	@DataProvider
	public Object[][] testData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\testData.json");
		return new Object[][] { { data.get(0) } };
	}

}
