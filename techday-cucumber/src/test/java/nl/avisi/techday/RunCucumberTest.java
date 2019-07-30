package nl.avisi.techday;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "json:target/cucumber.json", "junit:target/cucumber.xml", "html:target/cucumber"})
public class RunCucumberTest {
}
