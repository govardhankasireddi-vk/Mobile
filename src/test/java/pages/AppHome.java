package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;
import java.time.Duration;
import java.util.List;


public class AppHome extends ElementUtils {


    @AndroidFindBy(uiAutomator = " new UiSelector().className(\"android.widget.ImageView\").instance(5)")
    private WebElement filter ;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Price (low to high)\")")
    private WebElement lowToHigh ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
    private List<WebElement> itemsName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private List<WebElement> itemsPrice;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Cart\")")
    private WebElement viewCart ;


    public AppHome(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public boolean cartIsDisplayed(){
        try {
            visibilityOfElement(viewCart, 10L);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickonFilter(){
        click(filter);
        click(lowToHigh);
    }

    public void getTitles(){
        System.out.println(getAllProductinfo(itemsName,itemsPrice));
        scrollUp();
    }

    public void selectProduct(){
        for(WebElement product : itemsName ){
            if( product.getText().equalsIgnoreCase("Sauce Labs Onesie")){
                product.click();
            }
        }
    }
    public void clickViewCart(){
        click(viewCart);
    }
}
