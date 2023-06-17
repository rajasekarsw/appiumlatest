package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewsPage {
	
	private AppiumDriver appiumDriver;
	
	@FindBy(xpath ="//android.widget.TextView[@content-desc='Views']")
	private WebElement views;
	
	public ViewsPage(AppiumDriver driver) {
		appiumDriver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
		
	}
	
	public void clickViews()
	{
		views.click();
	}

}
