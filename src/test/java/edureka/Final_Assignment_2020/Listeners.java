package edureka.Final_Assignment_2020;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {
	public void onTestFailure(ITestResult result) {
		String resulttext="fail";
		String testMethodName = result.getMethod().getMethodName();
		captureScreenshot(Base.driver,resulttext,testMethodName);
		System.out.println(result.getName()+ "testfailed");
		

	}

	public void onTestSuccess(ITestResult result) {
		String resulttext="pass";
		String testMethodName = result.getMethod().getMethodName();
		captureScreenshot(Base.driver,resulttext,testMethodName);
		System.out.println(result.getName()+ "testpassed");
	}

}
