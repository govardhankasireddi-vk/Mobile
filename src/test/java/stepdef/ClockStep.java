package stepdef;

import appium.AppiumTest;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddAlarm;
import pages.AddTime;
import pages.Alarm;
import pages.Clock_Home;

import java.net.MalformedURLException;

import static appium.AppiumTest.caps;


public class ClockStep  {

        Alarm alarm;
        Clock_Home clockHome;
        AddAlarm addAlarm;
        AddTime addTime;
        AndroidDriver driver =  AppiumTest.setdriver("clock");

        public ClockStep() throws MalformedURLException {


                clockHome = new Clock_Home(driver);
        }


        @Given("the clock is on")
        public void the_clock_is_on() throws InterruptedException {

                clockHome.clickOnAlarm();
                Thread.sleep(5000);
                System.out.println("clicked on alarm");

        }

        @When("I set an alarm for {string}hr {string}min")
        public void iSetAnAlarmForHrMin(String hr, String min) throws InterruptedException {
                addAlarm = new AddAlarm(driver);
                addAlarm.clickOnAddAlarm();
                Thread.sleep(10000);
                addTime = new AddTime(driver);
                addTime.clickAddTime();
                alarm = new Alarm(driver);
                alarm.AddAlarm(hr,min);
                System.out.println("set alarm");
        }

        @Then("the alarm should be set for {string}")
        public void the_alarm_should_be_set_for(String string) throws InterruptedException {
                Thread.sleep(5000);
                if(addAlarm.verifyAlarm(string)){
                        System.out.println("alarm got set");
                }
                else {
                        System.out.println("alarm not set");
                }


        }


}

