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
        homePageObject.inputToRegistrationTextBox(extractedRegistrationNumbers.get(2));
        Thread.sleep(1000);
        homePageObject.submitRegistration();
        Thread.sleep(2000);
        InfoPage infoPageObject = new InfoPage(driver);
        System.out.println("using the locator " + infoPageObject.getRegistration());
        System.out.println("using the locator " + infoPageObject.getMake());
        System.out.println("using the locator " + infoPageObject.getModel());
        System.out.println("using the locator " + infoPageObject.getColor());
        System.out.println("using the locator " + infoPageObject.getYear());
        System.out.println(infoPageObject.getTryAgain());
        ArrayList<Car> cars = RegistrationNumberExtractor.extractOutput();
        Thread.sleep(2000);
        driver.quit();

    }


}
