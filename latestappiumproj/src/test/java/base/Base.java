package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

public class Base {
	
	public static ExtentReports extentReports;
	public ExtentTest extentTest;
	public AppiumDriver driver=null;
	public boolean serverRunning;
	
	@BeforeSuite
	public void setUp()
	{
		extentReports=new ExtentReports();
		ExtentSparkReporter reporter=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/extentreprots/"+"extentreports.html"));
		reporter.config().setDocumentTitle("Gesture automation");
		reporter.config().setTheme(Theme.DARK);
		extentReports.attachReporter(reporter);
	}
	
	@AfterSuite
	public void tearDown()
	{
		
		extentReports.flush();
	}
	
	public AppiumDriver getDriver() throws MalformedURLException, InterruptedException
	{
		UiAutomator2Options cap=new UiAutomator2Options();
		
		cap.setApp(System.getProperty("user.dir") +"/ApiDemos.apk");
		cap.setPlatformName("android");
		cap.setAppPackage("io.appium.android.apis");
		cap.setAppActivity("io.appium.android.apis.ApiDemos");
		
		cap.setAvd("Pixel_4_XL_API_30");
		cap.setAvdLaunchTimeout(Duration.ofSeconds(600));
		cap.setAutoGrantPermissions(true);
		cap.setNoReset(true);
		cap.setAllowTestPackages(true);
		cap.setNewCommandTimeout(Duration.ofSeconds(10));
		
		
		driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		return driver;
	}
	
	public void invokeAppiumServer() throws InterruptedException
	{
	  AppiumServiceBuilder builder=new AppiumServiceBuilder();
	  
	         builder.usingPort(4723)
	         .withIPAddress("127.0.0.1")
	         .withAppiumJS(new File("C:\\Users\\PC 1\\AppData\\Roaming\\npm\\node_modules\\appium"))
	           .withArgument(()->"--base-path","/wd/hub")
	            .withTimeout(Duration.ofSeconds(40))
	            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
	            .withArgument(GeneralServerFlag.LOG_LEVEL,"debug")
	            

	         .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
	         
	  
	  
	   
	     
	     AppiumDriverLocalService service= AppiumDriverLocalService.buildService(builder);
		  
		  service.start();
		
	     
	   // AppiumDriverLocalService.buildDefaultService().start();
	  
	     
	    
	     serverRunning=true;
	  
	  
	}

}
