package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.Base;

public class ListenerClass extends Base implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest =extentReports.createTest(result.getName());
		
		extentTest.log(Status.PASS, result.getTestName());
		
		
		
		System.out.println(result.getMethod().getMethodName()+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
		
	
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}
	

}
