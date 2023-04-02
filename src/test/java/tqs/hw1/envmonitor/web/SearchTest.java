package tqs.hw1.envmonitor.web;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import tqs.hw1.envmonitor.web.pages.IndexPage;
import tqs.hw1.envmonitor.web.pages.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SeleniumJupiter.class)
public class SearchTest {

    @Test
    @Disabled
    void searchInvalidLocation(ChromeDriver driver) {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.setQuery("InvalidLocation");
        indexPage.search();

        SearchPage searchPage = new SearchPage(driver);
        assertThat(searchPage.getQuery()).isEqualTo("InvalidLocation");
        assertThat(searchPage.hasCurrentEmpty()).isTrue();
        assertThat(searchPage.hasForecastEmpty()).isTrue();
    }

    @Test
    @Disabled
    void searchValidLocation(ChromeDriver driver) {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.setQuery("Aveiro");
        indexPage.search();

        SearchPage searchPage = new SearchPage(driver);
        assertThat(searchPage.getQuery()).isEqualTo("Aveiro");
        assertThat(searchPage.getResults()).isEqualTo("Showing results for Aveiro, PT");
        assertThat(searchPage.hasCurrentTable()).isTrue();
        assertThat(searchPage.hasForecastChart()).isTrue();
        assertThat(searchPage.hasForecastTable()).isTrue();
    }
}
