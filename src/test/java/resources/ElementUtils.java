package resources;


import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ElementUtils {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public ElementUtils(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void visibilityOfElement(WebElement element, Long sec) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void textNotToBePresentwait(By element, String text) {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(element, text)));
    }

    public void invisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void elementClickable(WebElement element, Long sec) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void sendKeysWhenVisible(WebElement element, String value) {
        visibilityOfElement(element, 10L);
        element.clear();
        element.sendKeys(value);
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        visibilityOfElement(element, 5L);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText.trim());
    }

    public void selectByValue(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        wait.until(driver -> {
            return select.getOptions().size() > 1;
        });
        select.selectByValue(value);
    }

    public void click(WebElement element) {
        try {
            if (element.isDisplayed()) {
                elementClickable(element, 5L);
                element.click();
            }

        } catch (Exception e) {
            //scrollDown();
            visibilityOfElement(element,10L);
            elementClickable(element, 10L);
            element.click();
            scrollUp();
        }

    }

    public String getText(WebElement element) {
        visibilityOfElement(element, 15L);
        return element.getText();
    }

    public void scrollUp() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(5)"
        ));
    }

    public Map<String,String> getAllProductinfo (List<WebElement> Element , List<WebElement> Element2 ) {
        Map<String,String> productNames = new HashMap<>();

        boolean reachedEnd = false;
        String lastItemText = "";

        while (!reachedEnd) {

            if (Element.isEmpty()) break;

            for(int i=0;i<Element.size();i++){
                String s1 = Element.get(i).getText();
                for(int j=i;j<Element2.size();j++){
                    String s2 = Element2.get(j).getText();
                    productNames.put(s1,s2);
                    break;
                }
            }

            String currentLastItem = Element.getLast().getText();
            if (currentLastItem.equals(lastItemText)) {
                reachedEnd = true;
            } else {
                scrollDown();
                lastItemText = currentLastItem;
            }
        }

        return productNames;
    }

    public void scrollDown( ) {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int startX = size.width / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

}

