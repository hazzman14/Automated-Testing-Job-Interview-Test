package tests.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utility.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MyStepdefs {

    private static WebDriver driver;

    @Given("user opens chrome and goes to cartextcheck.co.uk")
    public void userOpensChromeAndGoesToCartextcheckCoUk() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
    }

    @When("user enters their car registration number {int}")
    public void user_enters_their_car_registration_number(Integer number) {
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        HomePage homePageObject = new HomePage(driver);
        homePageObject.inputToRegistrationTextBox(extractedRegistrationNumbers.get(number));
        homePageObject.submitRegistration();
    }

    @Then("the info for car {int} appears")
    public void the_info_for_car_appear(int number) {
        InfoPage infoPageObj = new InfoPage(driver);
        assertTrue(infoPageObj.getTryAgain());
    }

    @Then("the info for car {int} does not appear")
    public void the_info_for_car_does_not_appear(Integer number) {
        InfoPage infoPageObj = new InfoPage(driver);
        assertFalse(infoPageObj.getTryAgain());

    }

}
