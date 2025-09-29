package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import resources.ElementUtils;

import java.util.List;

import static appium.AppiumTest.driver;

public class AddAlarm extends ElementUtils {
    WebElement addAlarmbtn = driver.findElement(AppiumBy.accessibilityId("Add alarm"));
    List<WebElement> addedAlarms = driver.findElements(AppiumBy.xpath("//android.widget.TextView"));
    List<WebElement> enabledAlarm = driver.findElements(AppiumBy.xpath(" //android.widget.Switch[@resource-id=\"com.google.android.deskclock:id/onoff\"]"));

    public AddAlarm(AndroidDriver driver) {
        super(driver);
    }

    public  void clickOnAddAlarm(){
        click(addAlarmbtn);

    }
    public  boolean verifyAlarm(String expectedAlarm) throws InterruptedException {


            for (int i = 0; i < addedAlarms.size(); i++) {
                Thread.sleep(2000);
                System.out.println(addedAlarms.size());
               String item = addedAlarms.get(i).getText();
            System.out.println(item);
            if(item.equalsIgnoreCase(expectedAlarm)){
                System.out.println("alarm added");
                for(WebElement enabled : enabledAlarm){
                    String enable  = enabled.getText();
                    if(enable.equalsIgnoreCase("ON")){
                        System.out.println("alarm enabled");
                        return true;
                    }
                }
                System.out.println("Alarm found but not enabled.");
                return false;

            }

        }
        return false;
    }
}
