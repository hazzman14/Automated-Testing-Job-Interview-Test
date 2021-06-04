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



    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getRegistration() {
        String toString = driver.findElement(registration).getText();
        return toString;
    }

    public String getMake() {
        String toString = driver.findElement(make).getText();
        return toString;
    }

    public String getModel() {
        String toString = driver.findElement(model).getText();
        return toString;
    }

    public String getColor() {
        String toString = driver.findElement(color).getText();
        return toString;
    }

    public String getYear() {
        String toString = driver.findElement(year).getText();
        return toString;
    }
}
