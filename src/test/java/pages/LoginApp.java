package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;

import java.time.Duration;

public class LoginApp extends ElementUtils {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-standard_user\"]") private WebElement standardUser;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGIN\")") private WebElement loginBtn ;

    public LoginApp(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void selectStandardUser(){
       click(standardUser);
    }
    public void clickOnLogin(){
        click(loginBtn);
    }


}
