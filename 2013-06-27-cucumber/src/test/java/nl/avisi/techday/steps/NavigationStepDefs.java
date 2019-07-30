package nl.avisi.techday.steps;

import cucumber.api.java.en.Given;
import nl.avisi.techday.pages.HomePage;

public class NavigationStepDefs {

    private HomePage homePage;

    public NavigationStepDefs(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^I am on the homepage$")
    public void I_am_on_the_homepage() throws Throwable {
        homePage.go();
    }
}
