package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By enterRegistrationTextBox = By.id("vrm-input");
    By freeCarCheckButton = By.xpath("//button[text()='Free Car Check']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToRegistrationTextBox(String registrationNumber){
        driver.findElement(enterRegistrationTextBox).sendKeys(registrationNumber);
    }

    public void submitRegistration(){
        driver.findElement(freeCarCheckButton).click();
    }

}
