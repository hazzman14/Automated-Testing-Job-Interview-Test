import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utility.*;

import java.util.ArrayList;

public class MyStepdefs {

    private static WebDriver driver;

    @Given("user opens chrome and goes to cartextcheck.co.uk")
    public void userOpensChromeAndGoesToCartextcheckCoUk() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
    }

    @When("user goes to cartextcheck.co.uk and enters their car registration {int} <number>")
    public static void userGoesToCartextcheckCoUkAndEntersTheirCarRegistrationNumber(int number) {
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        HomePage homePageObject = new HomePage(driver);
        homePageObject.inputToRegistrationTextBox(extractedRegistrationNumbers.get(number));
        homePageObject.submitRegistration();
    }

    @Then("the info for car <number> appears")
    public void theInfoForCarNumberAppears() {
    }


}
