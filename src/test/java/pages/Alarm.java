package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;

import java.util.List;

import static appium.AppiumTest.driver;

public class Alarm extends ElementUtils {



    WebElement hourInput = driver.findElement(AppiumBy.androidUIAutomator(" new UiSelector().resourceId(\"android:id/input_hour\")"));
    WebElement minuteInput = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/input_minute\")"));
    WebElement selector = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/am_pm_spinner\")"));
    //WebElement amSelector = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"AM\")"));
    List<WebElement> ampm = driver.findElements(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]"));

    WebElement okBtn = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")"));


    public Alarm(AndroidDriver driver) {
        super(driver);
    }



    public  void AddAlarm(String hr,String min){


        sendKeysWhenVisible(hourInput,hr);
        sendKeysWhenVisible(minuteInput,min);
        //click(selector);
//        for(WebElement apm : ampm){
//            String fin = apm.getText();
//            if(fin.equalsIgnoreCase("am")){
//                click(apm);
//                break;
//            }
//        }

        click(okBtn);

    }


}