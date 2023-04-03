package tqs.hw1.envmonitor.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tqs.hw1.envmonitor.web.pages.IndexPage;
import tqs.hw1.envmonitor.web.pages.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void searchInvalidLocation() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.setQuery("InvalidLocation");
        indexPage.search();

        SearchPage searchPage = new SearchPage(driver);
        assertThat(searchPage.getQuery()).isEqualTo("InvalidLocation");
        assertThat(searchPage.hasCurrentEmpty()).isTrue();
        assertThat(searchPage.hasForecastEmpty()).isTrue();
    }

    @Test
    void searchValidLocation() {
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
