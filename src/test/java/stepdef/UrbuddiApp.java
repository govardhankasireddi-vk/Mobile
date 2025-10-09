package stepdef;

import appium.AppiumTest;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Urbuddi_HomePage;
import pages.Urbuddi_LeavePage;
import pages.Urbuddi_Login;

import java.net.MalformedURLException;

public class UrbuddiApp {

    AndroidDriver driver;
    Urbuddi_Login urbuddiLogin;
    Urbuddi_HomePage urbuddiHomePage;
    Urbuddi_LeavePage urbuddiLeavePage;



    @Given("the urbuddi app name {string}")
    public void the_urbuddi_app_name(String string) throws MalformedURLException {

        driver =  AppiumTest.setdriver(string);
        urbuddiLogin = new Urbuddi_Login(driver);
        urbuddiHomePage = new Urbuddi_HomePage(driver);
        urbuddiLeavePage = new Urbuddi_LeavePage(driver);


    }

    @Given("enter the username {string} and pasword {string}")
    public void enter_the_username_and_pasword(String email, String password) {


        urbuddiLogin.setEmailTxt(email);
        urbuddiLogin.setPasswordTxt(password);

    }
    @And("click on the login")
    public void click_On_The_Login(){
        urbuddiLogin.clickOnLogin();

    }
    @Then("user logged in sucessfully")
    public void user_logged_in_sucessfully(){

       if( urbuddiHomePage.profileIsDisplayed()){
           System.out.println("Logged in success");
       }
       else{
           System.out.println("Login failed");
       }
    }

    @When("user click on the Leave")
     public void user_click_on_the_Leave(){
        urbuddiHomePage.clikOnLeave();


    }
    @And("enter leave details {string} {string} to {string} {string}")
    public void enter_leave_details( String startMonth , String startdate , String endMonth , String endDate)  {
        urbuddiLeavePage.clickOnApplyLeave();
        urbuddiLeavePage.clickOnleadDropdown();
        urbuddiLeavePage.setSelectLead();
        urbuddiLeavePage.setStartDate(startdate, startMonth);
        urbuddiLeavePage.setEndDateDate(endDate, endMonth);
        urbuddiLeavePage.setSubjectTxt();
        urbuddiLeavePage.setReasonTxt();
        urbuddiLeavePage.clickonLeaveBtn();
        urbuddiLeavePage.clickonConfirmBtn();

    }
    @Then("leave should be submit sucessfully")
    public void leave_should_be_submit_sucessfully(){
        if(urbuddiLeavePage.LeaveConfirmationIsDisplayed()) {
            System.out.println("leave submitted");
        }
        else{
            System.out.println("leave cant be submit for the selected dates");
        }

    }

    @When("user click on the Leave Requests")
    public void userClickOnTheLeaveRequests() {
        urbuddiLeavePage.viewRequests();

    }

    @And("Approve the Leave")
    public void approveTheLeave() {
        urbuddiLeavePage.approveLeaveRequest();

    }

    @Then("leave should be approve")
    public void leaveShouldBeApprove() {
        System.out.println("Leave Approved ");
    }

    @And("reject the Leave")
    public void rejectTheLeave() {
        urbuddiLeavePage.rejectLeaveRequest();
    }

    @Then("leave should be rejected")
    public void leaveShouldBeRejected() {
        System.out.println("Leave Rejected ");
    }

    @When("user click on the work")
    public void userClickOnTheWork() {
        urbuddiHomePage.clikOnWork();

    }

    @And("user click on the apply work")
    public void userClickOnTheApplyWork() {
        urbuddiHomePage.clickApplyWork();

    }

    @And("enter the work details")
    public void enterTheWorkDetails() {

    }

    @Then("work should be added")
    public void workShouldBeAdded() {
    }
}
