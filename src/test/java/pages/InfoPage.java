package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage {

    WebDriver driver;
    By registration = By.xpath("//dt[text()='Registration']/following-sibling::dd");
    By make = By.xpath("//dt[text()='Make']/following-sibling::dd");
    By model = By.xpath("//dt[text()='Model']/following-sibling::dd");
    By color = By.xpath("//dt[text()='Colour']/following-sibling::dd");
    By year = By.xpath("//dt[text()='Year']/following-sibling::dd");
    By tryAgainButton = By.linkText("Try Again");



    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegistration() {
        String registrationTxt = driver.findElement(registration).getText();
        return registrationTxt;
    }

    public String getMake() {
        String makeTxt = driver.findElement(make).getText();
        return makeTxt;
    }

    public String getModel() {
        String modelTxt = driver.findElement(model).getText();
        return modelTxt;
    }

    public String getColor() {
        String colorTxt = driver.findElement(color).getText();
        return colorTxt;
    }

    public String getYear() {
        String yearTxt = driver.findElement(year).getText();
        return yearTxt;
    }

    public Boolean getTryAgain() {
        Boolean isPresent = driver.findElements(tryAgainButton).isEmpty();
        return isPresent;
    }

}
