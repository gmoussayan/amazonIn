package testCases;

import org.testng.annotations.Test;

import base.Base;
import pages.SignInPage;

public class FailedLogin extends Base {

	@Test
	public void failedLogin() {

		SignInPage signInPage = homePage.clickSignInLink();
		signInPage.enteringEmail("test@test.com");
		signInPage.enteringPassword("theP@$$w0rd");
		System.out.println("i am the failed one");

	}

	@Test
	public void method1() {

		System.out.println("Method 1");
	}

	@Test
	public void method2() {

		System.out.println("Method 2");
	}

	// @Test(dependsonMethods= {"methodName"})

}
