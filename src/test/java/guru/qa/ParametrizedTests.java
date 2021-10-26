package guru.qa;

import guru.qa.page.GooglePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParametrizedTests {
    GooglePage googlePage = new GooglePage();

    @CsvSource({
            "0, QA.GURU",
            "1, Qa Guru"
    })
    @ParameterizedTest
    void csvSourceTest(int chapter, String result) {
        googlePage.openPage();
        googlePage.searchInput("qa guru");
        googlePage.selectChapter(chapter);
        googlePage.verifySearchResult(result);
    }

    @EnumSource(GoogleSearchResults.class)
    @ParameterizedTest
    void enumSourceTest(GoogleSearchResults item) {
        googlePage.openPage();
        googlePage.searchInput("qa guru");
        googlePage.selectChapter(item.chapter);
        googlePage.verifySearchResult(item.result);
    }

     static Stream<Arguments> googleSearch() {
        return Stream.of(
                Arguments.of(
                        0, "QA.GURU"
                ),
                Arguments.of(
                        1, "Qa Guru"
                )
        );
    }

    @MethodSource("googleSearch")
    @ParameterizedTest
    void methodSourceTest(int chapter, String result) {
        googlePage.openPage();
        googlePage.searchInput("qa guru");
        googlePage.selectChapter(chapter);
        googlePage.verifySearchResult(result);
    }
}
