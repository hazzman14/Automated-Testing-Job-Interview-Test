import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.InfoPage;
import utility.*;


import java.util.ArrayList;

public class WebDriverTesting {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk/");
        Thread.sleep(1000);
        driver.manage().window().maximize();


        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        HomePage homePageObject = new HomePage(driver);
        homePageObject.inputToRegistrationTextBox(extractedRegistrationNumbers.get(0));
        Thread.sleep(1000);
        homePageObject.submitRegistration();
        Thread.sleep(1000);
        InfoPage infoPageObj = new InfoPage(driver);
        System.out.println("using the locator " + infoPageObj.getRegistration());
        System.out.println("using the locator " + infoPageObj.getMake());
        System.out.println("using the locator " + infoPageObj.getModel());
        System.out.println("using the locator " + infoPageObj.getColor());
        System.out.println("using the locator " + infoPageObj.getYear());
        System.out.println(infoPageObj.getTryAgain());
        ArrayList<Car> cars = RegistrationNumberExtractor.extractOutput();
        System.out.println(cars.get(1).getColor());

    }


}
