package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;

import java.time.Duration;

public class Urbuddi_Work extends ElementUtils {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"calendarIcon\")") private WebElement calenderIcon;


    public Urbuddi_Work(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void clickCalender(){
        click(calenderIcon);
    }




}
