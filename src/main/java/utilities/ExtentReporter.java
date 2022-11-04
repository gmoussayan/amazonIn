package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	// extent;

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		System.out.println("NONONONONONO*****" + path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Test Results & Summary");
		reporter.config().setDocumentTitle("Test Result Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Georges");
		return extent;

	}

}
