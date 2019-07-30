package nl.avisi.techday.pages.elements;

import org.openqa.selenium.WebElement;

public class ArticleItem {

    private final WebElement webElement;

    public ArticleItem(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getTitle() {
        return webElement.getText();
    }

    public void go() {
        webElement.click();
    }

}
