package guru.qa.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GooglePage {

    public static final String URL = "https://www.google.com/";

    public void openPage() {
        Selenide.open(URL);
    }

    public void searchInput(String input) {
        $(By.name("q")).setValue(input).pressEnter();
    }

    public void selectChapter(int chapter) {
        $("#top_nav").$$(".hdtb-mitem").get(chapter).click();//find(String.valueOf(Condition.text(chapter))).click();
    }

    public void verifySearchResult(String result) {
        $(".g").shouldHave(Condition.text(result));
    }
}
