package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import resources.ElementUtils;

import java.time.Duration;

public class ProductPage extends ElementUtils {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ADD TO CART\")")
    private WebElement addToCart;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"BACK TO PRODUCTS\")")
    private WebElement backToProducts;


    public ProductPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void clickAddToCart(){
        click(addToCart);
    }

    public void clickBackToProducts(){
        click(backToProducts);
    }

}
