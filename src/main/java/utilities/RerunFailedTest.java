package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTest implements IRetryAnalyzer {

	int count = 0;
	int maxRerun = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (count < maxRerun) {

			count++;
			return true;
		}

		return false;
	}

}
