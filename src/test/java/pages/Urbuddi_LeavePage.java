package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.ElementUtils;

import java.time.Duration;

public class Urbuddi_LeavePage extends ElementUtils {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Apply Leave\")") private WebElement applyLeavebtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"---Select Your Lead---\")") private WebElement leadDropdown;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"charanabhinay@gmail.com\")") private WebElement selectLead;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"YYYY-MM-DD\").instance(0)") private WebElement startDate;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uDB80\uDCED\").instance(1)") private WebElement endDate;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"subject\")") private WebElement subjectTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"reason\")") private WebElement reasonTxt;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"APPLY FOR LEAVE\")") private WebElement Leavebtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Okay\")") private WebElement confirmBtn;
    @AndroidFindBy(xpath = "//android.widget.ScrollView//android.view.ViewGroup[@index='8']//android.widget.TextView[@index='0']") private WebElement currentmonth;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\")") private WebElement nextBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Leave request submitted\")") private WebElement confirmationMsg;


    public Urbuddi_LeavePage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void clickOnApplyLeave(){
        click(applyLeavebtn);
    }
    public void clickOnleadDropdown(){
        click(leadDropdown);
    }
    public void setSelectLead(){
        click(selectLead);
    }

    public void setStartDate(String day , String month){

        click(startDate);
        System.out.println(getText(currentmonth));
        int count = 0;
        while ( count == 0) {
            if (month.equalsIgnoreCase(getText(currentmonth))) {
                String daySelector = String.format("//android.view.ViewGroup[@content-desc='%s']", day);
                WebElement dayElement = driver.findElement(By.xpath(daySelector));
                click(dayElement);
                count++;
            } else {
                click(nextBtn);
            }
        }

    }
    public void setEndDateDate(String day , String month) {
        endDate.click();
        //click(endDate);
        int count = 0;
        while (count == 0) {
            if (month.equalsIgnoreCase(getText(currentmonth))) {
                String daySelector = String.format("//android.view.ViewGroup[@content-desc='%s']", day);
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(daySelector))));
                WebElement dayElement = driver.findElement(By.xpath(daySelector));
                click(dayElement);
                count++;
            } else {
                click(nextBtn);
            }
        }
    }
    public void setSubjectTxt(){
        sendKeysWhenVisible(subjectTxt,"subjectTxt");
    }
    public void setReasonTxt(){
        sendKeysWhenVisible(reasonTxt,"setReasonTxt");
    }
    public void clickonConfirmBtn(){
        click(confirmBtn);
    }
    public void clickonLeaveBtn(){
        click(Leavebtn);
    }
    public boolean LeaveConfirmationIsDisplayed(){
        try{
            //visibilityOfElement(empPhoto, 5L);
            confirmationMsg.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
