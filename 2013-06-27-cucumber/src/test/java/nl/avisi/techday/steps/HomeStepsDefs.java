package nl.avisi.techday.steps;

import cucumber.api.java.en.When;
import nl.avisi.techday.ScenarioCache;
import nl.avisi.techday.pages.HomePage;
import nl.avisi.techday.pages.elements.ArticleItem;

public class HomeStepsDefs {

    private final HomePage homePage;
    private final ScenarioCache cache;

    public HomeStepsDefs(HomePage homePage, ScenarioCache cache) {
        this.homePage = homePage;
        this.cache = cache;
    }

    @When("^I select the first article$")
    public void I_select_the_first_article() throws Throwable {
        ArticleItem article = homePage.getArticle(0);
        cache.add("title", article.getTitle());
        article.go();
    }

}
