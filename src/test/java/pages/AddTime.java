package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.ElementUtils;

import java.time.Duration;

public class AddTime extends ElementUtils {

    WebElement addTime = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.deskclock:id/material_timepicker_mode_button\")"));

    public AddTime(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickAddTime(){
        click(addTime);
    }

}
