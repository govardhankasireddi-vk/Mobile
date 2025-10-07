package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Clock_Home;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static appium.AppiumTest.caps;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AppiumTest {
    public static AndroidDriver driver;
    public static DesiredCapabilities caps = new DesiredCapabilities();


    public static AndroidDriver setdriver(String app) throws MalformedURLException {


        // Set capabilities
        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(PLATFORM_VERSION, "16.0");
        caps.setCapability(DEVICE_NAME, "emulator-5554");
        caps.setCapability(AUTOMATION_NAME, "UiAutomator2");

        Map<String, String[]> appMap = getAppCapabilities(app);
        caps.setCapability("appPackage", appMap.get("app")[0]);
        caps.setCapability("appActivity", appMap.get("app")[1]);
        caps.setCapability("newCommandTimeout", 300);
        caps.setCapability("autoGrantPermissions", true);

//            caps.setCapability("appPackage", "com.google.android.deskclock");
//            caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
//            caps.setCapability("noReset", true);
//            caps.setCapability("fullReset", false);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        System.out.println("App launched on emulator!");

        //driver.quit();

        return driver;
    }

    public static Map<String, String[]> getAppCapabilities(String app) {
        Map<String, String[]> appMap = new HashMap<>();

        switch (app.toLowerCase()) {

            case "clock":
                appMap.put("app", new String[]{"com.google.android.deskclock", "com.android.deskclock.DeskClock"});
                break;
            case "calculator":
                appMap.put("app", new String[]{"com.android.calculator2", "com.android.calculator2.Calculator"});
                break;
            case "swag":
                appMap.put("app", new String[]{"com.swaglabsmobileapp", "com.swaglabsmobileapp.MainActivity"});

            case "urbuddi":
                appMap.put("app", new String[]{"com.urbuddiapp", "com.urbuddiapp.MainActivity"});
                break;

            default:
                throw new IllegalArgumentException("Unknown feature: " + app);
        }

        return appMap;

    }

}




