package learnmake.automation.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import learnmake.automation.SharedContext;
import learnmake.automation.pages.*;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MakeSearch implements En {
    private WebDriver driver;
    private AbstractPage searchPage;

    private SharedContext sharedContext;

    // Warning: Make sure the timeouts for hooks using a web driver are zero

    // NOTE: picocontainer injects SharedContext
    public MakeSearch(SharedContext sharedContext) {
        this.sharedContext = sharedContext;

        Before(new String[]{"@web"}, 0, 1, (Scenario scenario) -> {
            this.sharedContext.setUp();
        });
        Before(new String[]{"@web", "@chrome"}, 0, 1, (Scenario scenario) -> {
            driver = this.sharedContext.getDriver("chrome");
        });
        Before(new String[]{"@web", "@firefox"}, 0, 1, (Scenario scenario) -> {
            driver = this.sharedContext.getDriver("firefox");
        });
        Before(new String[]{"@AutomationPracticePage"}, 0, 10, (Scenario scenario) -> {
            searchPage = new AutomationPracticePage(driver);
        });
        Given("^a web browser is on the search engine page$", () -> {
            searchPage.navigateToHomePage();
        });
        Given("^a web browser is opened with home page$", () -> {
            searchPage.navigateToHomePage();
        });
        And("^I verify links in Home Page$", () -> {
            searchPage.verifyLinksInHomePage();
        });
        And("^I Navigate And Verify To Contact us page$", () -> {
            searchPage.verifyContactUsPage();
        });
        When("^the Home Page is shown$", () -> {
            searchPage.verifyHomePage();
        });
        Then("^the Home Page linkText \"([^\"]*)\" is shown$", (String Text) -> {
            searchPage.verifyLinkText(Text);
        });
        Then("^I Validate Error Message$", () -> {
            searchPage.ErrorFillContactUsPage();
        });
        Then("^I Fill Contact us page \"([^\"]*) \"([^\"]*) \"([^\"]*)\"$", (String Text,String Text1, String Text2) -> {
            searchPage.fillContactUsPage(Text,Text1,Text2);
        });
        Then("^results for \"([^\"]*)\" are shown$", (String phrase) -> {
            assertThat(searchPage.pageTitleContains(phrase)).isTrue();
        });

        After(new String[]{"@web"}, (Scenario scenario) -> {
            this.sharedContext.tearDown();
        });
        Then("^I click Add to cart button$", () -> {
        searchPage.ClickAddToCartButton();});

        Then("^I click Add to cart button Number \"([^\"]*)\" with popup$", (String Text) -> {
            searchPage.ClickAddToCartButtonPopUpOpens(Text);
        });
        Then("^I click Add to cart button Number \"([^\"]*)\" with popup and Checkout$", (String Text) -> {
            searchPage.ClickAddToCartButtonAndCheckout(Text);
        });
        Then("^I Verify More button$", () -> {
        searchPage.VerifyMoreButton();});
        Then("^I Navigate to SigninButton$", () -> {
            searchPage.VerifySignInPage();
        });
        And("^I Verify More Button After Clicking in Home Page$", () -> {
            searchPage.ClickMoreButton();
        });

    }
}
