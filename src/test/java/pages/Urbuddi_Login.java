package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;

import java.time.Duration;

public class Urbuddi_Login extends ElementUtils {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)") private WebElement emailTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)") private WebElement passwordTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login\")") private WebElement loginBtn;

    public Urbuddi_Login(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void setEmailTxt(String email){
        sendKeysWhenVisible(emailTxt,email);

    }
    public void setPasswordTxt(String password){
        sendKeysWhenVisible(passwordTxt,password);
    }

    public void clickOnLogin(){
     click(loginBtn);
    }



}
