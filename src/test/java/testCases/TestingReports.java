package testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.SignInPage;

public class TestingReports extends Base {

	@Test
	public void selectSamsungTV2() throws IOException, InterruptedException {

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail("test@test.com");
		signInPage.enteringPassword("theP@$$w0rd");
		System.out.println("A bientot!");

	}

	@Test
	public void selectSamsungTV3() throws IOException, InterruptedException {

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail("test@test.com");
		signInPage.enteringPassword("theP@$$w0rd");
		System.out.println("I'm failing!");
		Assert.assertFalse(true);

	}

	@DataProvider
	public Object[][] testData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\testData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
