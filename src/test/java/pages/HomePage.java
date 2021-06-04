package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By enterRegistrationTextBox = By.id("vrm-input");
    By freeCarCheckButton = By.xpath("//button[text()='Free Car Check']");

    //I found that a pay element popped up about 1 in 6 times and ruined my By's so i made 2 By's and then check if the element exists and decide which to use
    By annoyingElement = By.id("checkout-form");

    By registration = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(1) > dd");
    By registrationWithElement = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(1) > dd");

    By make = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(2) > dd");
    By makeWithElement = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(2) > dd");

    By model = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(3) > dd");
    By modelWithElement = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(3) > dd");

    By color = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(4) > dd");
    By colorWithElement = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(4) > dd");

    By year = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(5) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(5) > dd");
    By yearWithElement = By.cssSelector("#m > div.jsx-79705764 > div:nth-child(6) > div.jsx-1843467667 > div > span > div.jsx-3499070155 > dl:nth-child(5) > dd");



    By tryAgainButton = By.linkText("Try Again");



    public String getRegistration() {
        Boolean isPresent = driver.findElements(annoyingElement).size() > 0;
        if(isPresent){
            return driver.findElement(registrationWithElement).getText();
        }else{
            return driver.findElement(registration).getText();
        }
    }

    public String getMake() {
        Boolean isPresent = driver.findElements(annoyingElement).size() > 0;
        if(isPresent){
            return driver.findElement(makeWithElement).getText();
        }else{
            return driver.findElement(make).getText();
        }
    }

    public String getModel() {
        Boolean isPresent = driver.findElements(annoyingElement).size() > 0;
        if(isPresent){
            return driver.findElement(modelWithElement).getText();
        }else{
            return driver.findElement(model).getText();
        }
    }

    public String getColor() {
        Boolean isPresent = driver.findElements(annoyingElement).size() > 0;
        if(isPresent){
            return driver.findElement(colorWithElement).getText();
        }else{
            return driver.findElement(color).getText();
        }
    }

    public String getYear() {
        Boolean isPresent = driver.findElements(annoyingElement).size() > 0;
        if(isPresent){
            return driver.findElement(yearWithElement).getText();
        }else{
            return driver.findElement(year).getText();
        }
    }

    public Boolean getTryAgain() {
        Boolean isPresent = driver.findElements(tryAgainButton).isEmpty();
        return isPresent;
    }

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
