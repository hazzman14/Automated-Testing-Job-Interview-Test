package tests.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = "pretty",features = "classpath:tests.cucumber/registration.feature")
@RunWith(Cucumber.class)
public class CucumberRunTest {
}
