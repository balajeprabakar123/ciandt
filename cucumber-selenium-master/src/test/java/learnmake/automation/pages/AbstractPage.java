package learnmake.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait driverWait(long timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds);
    }

    public void navigateToHomePage() {}
    public void verifyHomePage( ) {}
    public void ErrorFillContactUsPage(){}
    public void ClickAddToCartButton(){}
    public void ClickAddToCartButtonPopUpOpens(String out){}
    public void ClickAddToCartButtonAndCheckout(String out2){}
    public void VerifyMoreButton(){}
    public void ClickMoreButton(){}
    public void verifyLinkText(String text){}
    public void verifyLinksInHomePage(){};
    public void VerifySignInPage(){};
    public void verifyContactUsPage(){};
    public void fillContactUsPage(String text,String text1,String text2){};
    public boolean pageTitleContains(String phrase) {return true;}
}
