package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;

import java.time.Duration;

public class Urbuddi_HomePage extends ElementUtils {
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)") private WebElement empPhoto;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Leaves\")")  private WebElement leavesMenu;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Work\").instance(1)") private WebElement workMenu;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Apply Work\")") private WebElement applyWorkBtn;

    public Urbuddi_HomePage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public boolean profileIsDisplayed(){
        try{
            //visibilityOfElement(empPhoto, 5L);
            empPhoto.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clikOnLeave(){
        click(leavesMenu);
    }
    public void clikOnWork(){
        click(workMenu);
    }
    public void clickApplyWork(){click(applyWorkBtn);}


}
