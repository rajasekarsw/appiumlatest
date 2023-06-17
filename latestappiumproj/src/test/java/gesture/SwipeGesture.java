package gesture;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import io.appium.java_client.AppiumDriver;
import pages.ViewsPage;

public class SwipeGesture extends Base{
	
	AppiumDriver driver;
	@BeforeMethod
	public void init() throws MalformedURLException, InterruptedException
	{
		invokeAppiumServer();
		driver=getDriver();
	}
	
	@Test
	public void swipe()
	{
		ViewsPage viewsPage=new ViewsPage(driver);
		viewsPage.clickViews();
	}

}
