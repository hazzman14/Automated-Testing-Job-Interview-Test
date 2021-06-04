package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.InfoPage;
import utility.*;
import java.util.ArrayList;

//This class was here for some early testing of the methods before i had implemented cucumber fully
public class WebDriverManualTesting {
    private static Logger log = LogManager.getLogger(RegistrationNumberExtractor.class);
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
        Thread.sleep(1000);
        driver.manage().window().maximize();


        //testing the input string and submit
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        HomePage homePageObject = new HomePage(driver);
        homePageObject.inputToRegistrationTextBox(extractedRegistrationNumbers.get(2));
        Thread.sleep(1000);
        homePageObject.submitRegistration();
        Thread.sleep(3000);

        //this was for testing my locators
        InfoPage infoPageObject = new InfoPage(driver);
        log.info(infoPageObject.getRegistration());
        log.info(infoPageObject.getMake());
        log.info(infoPageObject.getModel());
        log.info(infoPageObject.getColor());
        log.info(infoPageObject.getYear());


        Thread.sleep(2000);
        driver.quit();

    }


}
