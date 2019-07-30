package nl.avisi.techday.steps;

import cucumber.api.java.en.Then;
import nl.avisi.techday.ScenarioCache;
import nl.avisi.techday.pages.ArticlePage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArticleStepDefs {

    private final ScenarioCache cache;
    private final ArticlePage articlePage;

    public ArticleStepDefs(ScenarioCache cache, ArticlePage articlePage) {
        this.cache = cache;
        this.articlePage = articlePage;
    }

    @Then("^I should see the first article$")
    public void I_should_see_the_first_article() throws Throwable {
        assertThat(articlePage.getTitle(), is(cache.get("title")));
    }
}
