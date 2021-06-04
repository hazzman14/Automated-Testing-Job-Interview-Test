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
    //defining my array lists for the cars from the input and cars from the output
    ArrayList<Car> inputFile = new ArrayList<>();
    ArrayList<Car> outputFile = new ArrayList<>();

    //before all the other tests i want to fill the input array lists with their car objects
    @Before
    public void setUp(){
        ArrayList<String> extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        //fills output car list with cars
        outputFile = RegistrationNumberExtractor.extractOutput();

        //loops through the arraylist containing the extracted reg numbers and makes a new car for each, assigning it
        //to the array list
        for(String s : extractedRegistrationNumbers){
            Car car = new Car(s);
            inputFile.add(car);
        }
    }

    //done at the start of each scenario, opens the browser to the cartax site
    @Given("user opens chrome and goes to cartextcheck.co.uk")
    public void userOpensChromeAndGoesToCartextcheckCoUk() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
    }


    @When("user enters their car registration number {int}")
    public void UserEntersTheirCarRegistrationNumber(int number) throws InterruptedException {
        HomePage homePageObject = new HomePage(driver);
        //we get the reg from the inputfile arraylist and put it into the textbox, and click the submit button
        String reg = inputFile.get(number).getRegistration();
        homePageObject.inputToRegistrationTextBox(reg);
        Thread.sleep(2000);
        homePageObject.submitRegistration();
        Thread.sleep(3000);

    }

    @Then("the info for car {int} appears")
    public void TheInfoForCarAppears(int number) throws InterruptedException {
        //once the page loads we take the info and add it to our car object that currently only has reg number
        InfoPage infoPageObject = new InfoPage(driver);
        inputFile.get(number).setMake(infoPageObject.getMake());
        inputFile.get(number).setModel(infoPageObject.getModel());
        inputFile.get(number).setColor(infoPageObject.getColor());
        int year = Integer.parseInt(infoPageObject.getYear());
        inputFile.get(number).setYear(year);
        Thread.sleep(2000);

        assertNotNull(inputFile.get(number));
    }

    @Then("the info for car {int} registration number is correct")
    public void theInfoForCarNumberRegistrationNumberIsCorrect(int number) {
        //we do this loop because the order between the 2 text files are different, then check reg number is equal
        //between the input and out cars
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

    //close the driver afterwards
    @After
    public void after(){
        driver.quit();
    }

}
