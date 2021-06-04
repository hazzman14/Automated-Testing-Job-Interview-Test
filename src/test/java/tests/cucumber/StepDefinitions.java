package tests.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.*;
import pages.HomePage;
import pages.InfoPage;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class StepDefinitions {

    private static WebDriver driver;
    ArrayList<Car> inputFile = new ArrayList<>();
    ArrayList<Car> outputFile = new ArrayList<>();


    @Before
    public void setUp(){
        ArrayList<String> extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();

        outputFile = RegistrationNumberExtractor.extractOutput();
        System.out.println("it is: " + extractedRegistrationNumbers);
        //make car objects for the inputed regs and put into arraylist
        for(String s : extractedRegistrationNumbers){
            Car car = new Car(s);
            inputFile.add(car);
        }
//        for(int counter = 0; counter < extractedRegistrationNumbers.size(); counter++){
//            Car car = new Car(extractedRegistrationNumbers.get(counter));
//            inputFile.add(car);
//        }
    }



    @Given("user opens chrome and goes to cartextcheck.co.uk")
    public void userOpensChromeAndGoesToCartextcheckCoUk() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
    }

    @When("user enters their car registration number {int}")
    public void user_enters_their_car_registration_number(int number) {
        HomePage homePageObject = new HomePage(driver);
        String reg = inputFile.get(number).getRegistration();
        homePageObject.inputToRegistrationTextBox(reg);
        homePageObject.submitRegistration();

        //update the car object with new info
        InfoPage infoPageObject = new InfoPage(driver);
        inputFile.get(number).setMake(infoPageObject.getMake());
        inputFile.get(number).setModel(infoPageObject.getModel());
        inputFile.get(number).setColor(infoPageObject.getColor());
        int year = Integer.parseInt(infoPageObject.getYear());
        inputFile.get(number).setYear(year);
    }

    @Then("the info for car {int} appears")
    public void the_info_for_car_appear(int number) {
        assertNotNull(inputFile.get(number));
    }

    @Then("the info for car {int} does not appear")
    public void the_info_for_car_does_not_appear(int number) {
        assertNull(inputFile.get(number));
    }

    @Then("the info for car {int} registration number is correct")
    public void theInfoForCarNumberRegistrationNumberIsCorrect(int number) {
        String actualReg = inputFile.get(number).getRegistration();
        String expectedReg = outputFile.get(number).getRegistration();
        assertEquals(actualReg,expectedReg);
    }

    @After
    public void after(){
        driver.quit();
    }
}
