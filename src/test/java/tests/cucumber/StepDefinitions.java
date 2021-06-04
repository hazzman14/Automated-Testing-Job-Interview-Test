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
        //define the Array Lists that are used
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
    public void user_enters_their_car_registration_number(int number) throws InterruptedException {
        HomePage homePageObject = new HomePage(driver);
        String reg = inputFile.get(number).getRegistration();
        homePageObject.inputToRegistrationTextBox(reg);
        Thread.sleep(2000);
        homePageObject.submitRegistration();
        Thread.sleep(3000);


        //update the car object with new info
        inputFile.get(number).setMake(homePageObject.getMake());
        inputFile.get(number).setModel(homePageObject.getModel());
        inputFile.get(number).setColor(homePageObject.getColor());
        int year = Integer.parseInt(homePageObject.getYear());
        inputFile.get(number).setYear(year);

    }


    @Then("the info for car {int} appears")
    public void the_info_for_car_appear(int number) {

        assertNotNull(inputFile.get(number));
    }

    @Then("the info for car {int} registration number is correct")
    public void theInfoForCarNumberRegistrationNumberIsCorrect(int number) {
        for (Car c : outputFile){
            if (c.getRegistration().equals(inputFile.get(number).getRegistration())){
                assertEquals(c.getRegistration(),inputFile.get(number).getRegistration());
            }
        }
    }

    @Then("the info for car {int} make is correct")
    public void theInfoForCarNumberMakeIsCorrect(int number) {
        for (Car c : outputFile){
            if (c.getRegistration().equals(inputFile.get(number).getRegistration())){
                assertEquals(c.getMake(),inputFile.get(number).getMake());
            }
        }
    }

    @Then("the info for car {int} model is correct")
    public void theInfoForCarNumberModelIsCorrect(int number) {
        for (Car c : outputFile){
            if (c.getRegistration().equals(inputFile.get(number).getRegistration())){
                assertEquals(c.getModel(),inputFile.get(number).getModel());
            }
        }
    }

    @Then("the info for car {int} color is correct")
    public void theInfoForCarNumberColorIsCorrect(int number) {
        for (Car c : outputFile){
            if (c.getRegistration().equals(inputFile.get(number).getRegistration())){
                assertEquals(c.getColor(),inputFile.get(number).getColor());
            }
        }
    }

    @Then("the info for car {int} year is correct")
    public void theInfoForCarNumberYearIsCorrect(int number) {
        for (Car c : outputFile){
            if (c.getRegistration().equals(inputFile.get(number).getRegistration())){
                assertEquals(c.getYear(),inputFile.get(number).getYear());
            }
        }
    }

    @After
    public void after(){
        driver.quit();
    }


}
