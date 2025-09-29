package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import resources.ElementUtils;

import static appium.AppiumTest.driver;

public class Clock_Home extends ElementUtils {

    WebElement alarmIcon = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Alarm\")"));

    public Clock_Home(AndroidDriver driver) {
        super(driver);
    }

    public  void clickOnAlarm(){
      click(alarmIcon);

    }
}
