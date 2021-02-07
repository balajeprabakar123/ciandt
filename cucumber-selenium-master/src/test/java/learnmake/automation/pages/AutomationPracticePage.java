package learnmake.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;


public class AutomationPracticePage extends AbstractPage {

    private static final String PAGE_HOME_URL = "http://automationpractice.com/index.php";
    private static final By BY_SEARCH_FIELD = By.xpath("//header[@id='header']/div/div/div/a/img");
    private static final String ContactUS = "Contact us";
    private static final String OrderReferenceLocator = "//label[contains(.,'Order reference')]";
    private static final String OrderReferenceTxtLocator = "id_order";
    private static final String SendButtonLocator = "//button[@id='submitMessage']/span";
    private static final String ErrorMessageLocator = "//li[contains(.,'Invalid email address.')]";
    private static final String MessageLocator = "//label[contains(.,'Message')]";
    private static final String MessageLocatorTxt = "message";
    private static final String AttachFieldLocator = "//label[contains(.,'Attach File')]";
    private static final String EmailLocator = "//label[contains(.,'Email address')]";
    private static final String EmailTxtLocator = "email";
    private static final String SubjectHeadingLocator = "//label[contains(.,'Subject Heading')]";
    private static final String SubjectHeadingSelectLocator ="//*[@id='id_contact']";
    private static final String SendMessageLocator = "//div[@id='center_column']/form/fieldset/h3";
    private static final String HeaderLocator = "//div[@id='center_column']/h1";
    private static final String checkoutButtonLoc="//span[contains(.,'Proceed to checkout')]";
    private static final String continueShoppingLoc="//div[@id='layer_cart']/div/div[2]/div[4]/span/span";
    private static final String closeButtonLoc="//div[@id='layer_cart']/div/div/span";
    private static final String SummaryPageLoc="//*[@id=\"order_step\"]/li[1]";
    private static final String SignInPageLoc="//*[@id=\"order_step\"]/li[2]";
    private static final String AddressPageLoc="//*[@id=\"order_step\"]/li[3]";
    private static final String ShippingPageLoc="//*[@id=\"order_step\"]/li[4]";
    private static final String PaymentPageLoc="//*[@id=\"order_step\"]/li[5]";
    private static final String NextPageLocatorLoc="//*[@id=\"center_column\"]/p[2]//span";

    private static final String SignIn = "Sign in";
    public AutomationPracticePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        getDriver().navigate().to(PAGE_HOME_URL);
    }
    public void  verifyHomePage(){
        WebElement verifyImage = driverWait(10).until(ExpectedConditions.presenceOfElementLocated(BY_SEARCH_FIELD));
    }

    public  void verifyLinkText(String text){
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.linkText(text)));
        String searchFieldTxt =   searchField.getText();
        Assert.assertEquals(searchFieldTxt, text);
        System.out.println(" text is " +searchFieldTxt);
    }
    public void verifyContactUsPage(){
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.linkText(ContactUS)));
        String searchFieldTxt =   searchField.getText();
        Assert.assertEquals(searchFieldTxt, ContactUS);
        System.out.println(" text is " +searchFieldTxt);
        searchField.click();
        verifyContactUsPageContent();
    }

    private void verifyContactUsPageContent() {
        WebElement searchField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(HeaderLocator)));
        String searchFieldTxt =   searchField.getText();
        Assert.assertEquals(searchFieldTxt, "CUSTOMER SERVICE - CONTACT US");

        WebElement SendMessage = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SendMessageLocator)));
        String SendMessageTxt =   SendMessage.getText();
        Assert.assertEquals(SendMessageTxt, "SEND A MESSAGE");

        WebElement SubjectHeading = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SubjectHeadingLocator)));
        String SubjectHeadingTxt =   SubjectHeading.getText();
        Assert.assertEquals(SubjectHeadingTxt, "Subject Heading");

        WebElement emailField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(EmailLocator)));
        String emailTxt =   emailField.getText();
        Assert.assertEquals(emailTxt, "Email address");

        WebElement OrderReferenceField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(OrderReferenceLocator)));
        String OrderReferenceTxt =   OrderReferenceField.getText();
        Assert.assertEquals(OrderReferenceTxt, "Order reference");

        WebElement attachField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(AttachFieldLocator)));
        String attachFieldText =   attachField.getText();
        Assert.assertEquals(attachFieldText, "Attach File");

        WebElement SendButton = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SendButtonLocator)));
        String SendButtonText =   SendButton.getText();
        Assert.assertEquals(SendButtonText, "Send");

        WebElement MessageField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(MessageLocator)));
        String MessageFieldTxt =   MessageField.getText();
        Assert.assertEquals(MessageFieldTxt, "Message");
    }

    public  void fillContactUsPage(String emailText,String orderRefTxt,String Message){
        WebElement SubjectHeading = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SubjectHeadingLocator)));
        String SubjectHeadingTxt =   SubjectHeading.getText();
        Assert.assertEquals(SubjectHeadingTxt, "Subject Heading");
        Select SubjectHeadingDropDown =  new Select(getDriver().findElement(By.xpath(SubjectHeadingSelectLocator))) ;
        SubjectHeadingDropDown.selectByIndex(1);

        WebElement emailField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(EmailLocator)));
        String emailTxt =   emailField.getText();
        Assert.assertEquals(emailTxt, "Email address");
        WebElement emailFieldtxt = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.id(EmailTxtLocator)));
        emailFieldtxt.sendKeys(emailText);

        WebElement OrderReferenceField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(OrderReferenceLocator)));
        String OrderReferenceTxt =   OrderReferenceField.getText();
        Assert.assertEquals(OrderReferenceTxt, "Order reference");
        WebElement OrderReferenceFieldTxt = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.id(OrderReferenceTxtLocator)));
        OrderReferenceFieldTxt.sendKeys(orderRefTxt);

        WebElement attachField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(AttachFieldLocator)));
        String attachFieldText =   attachField.getText();
        Assert.assertEquals(attachFieldText, "Attach File");

        WebElement SendButton = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SendButtonLocator)));
        String SendButtonText =   SendButton.getText();
        Assert.assertEquals(SendButtonText, "Send");
        SendButton.click();

        WebElement MessageField = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(MessageLocator)));
        String MessageFieldTxt =   MessageField.getText();
        Assert.assertEquals(MessageFieldTxt, "Message");
        WebElement MessageFieldLoc = driverWait(50).until(ExpectedConditions.elementToBeClickable(By.id(MessageLocatorTxt)));
        MessageFieldLoc.sendKeys(Message);

    }

    public  void ErrorFillContactUsPage(){
        WebElement SubjectHeading = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SubjectHeadingLocator)));
        String SubjectHeadingTxt =   SubjectHeading.getText();
        Assert.assertEquals(SubjectHeadingTxt, "Subject Heading");
        Select SubjectHeadingDropDown =  new Select(getDriver().findElement(By.xpath(SubjectHeadingSelectLocator))) ;
        SubjectHeadingDropDown.selectByIndex(1);

        WebElement SendButton = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(SendButtonLocator)));
        String SendButtonText =   SendButton.getText();
        Assert.assertEquals(SendButtonText, "Send");
        SendButton.click();

        WebElement ErrorMessage = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath(ErrorMessageLocator)));
        String ErrorMsgTxt =   ErrorMessage.getText();
        Assert.assertEquals(ErrorMsgTxt, "Invalid email address.");



    }
    public void ClickAddToCartButtonAndCheckout(String out2){

        String Loc = "//*[@id=\"homefeatured\"]/li["+out2+"]//a[1]/span";
        String Loc2 = "//*[@id=\"homefeatured\"]/li["+out2+"]/div/div[2]";
        WebElement AddToCartButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc2)));
        AddToCartButton.click();
        WebElement AddToCartButton2 = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc)));
        AddToCartButton2.click();
        String checkoutButtonLoc="//span[contains(.,'Proceed to checkout')]";
        WebElement checkoutButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(checkoutButtonLoc)));
        Assert.assertEquals(checkoutButton.getText(), "Proceed to checkout");
        checkoutButton.click();
        String SummaryPageLoc="//*[@id=\"order_step\"]/li[1]";
        String SignInPageLoc="//*[@id=\"order_step\"]/li[2]";
        String AddressPageLoc="//*[@id=\"order_step\"]/li[3]";
        String ShippingPageLoc="//*[@id=\"order_step\"]/li[4]";
        String PaymentPageLoc="//*[@id=\"order_step\"]/li[5]";
        String NextPageLocatorLoc="//*[@id=\"center_column\"]/p[2]//span";
        WebElement SummaryPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(SummaryPageLoc)));
        Assert.assertEquals(SummaryPage.getText(), "01. Summary");
        WebElement SignInPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(SignInPageLoc)));
        Assert.assertEquals(SignInPage.getText(), "02. Sign in");
        WebElement AddressPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(AddressPageLoc)));
        Assert.assertEquals(AddressPage.getText(), "03. Address");
        WebElement ShippingPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(ShippingPageLoc)));
        Assert.assertEquals(ShippingPage.getText(), "04. Shipping");
        WebElement PaymentPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(PaymentPageLoc)));
        Assert.assertEquals(PaymentPage.getText(), "05. Payment");
        WebElement NextPageLocator = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(NextPageLocatorLoc)));
        Assert.assertEquals(NextPageLocator.getText(), "Proceed to checkout");


    }
    public void VerifySignInPage(){

        WebElement SummaryPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(SummaryPageLoc)));
        Assert.assertEquals(SummaryPage.getText(), "01. Summary");
        WebElement SignInPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(SignInPageLoc)));
        Assert.assertEquals(SignInPage.getText(), "02. Sign in");
        WebElement AddressPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(AddressPageLoc)));
        Assert.assertEquals(AddressPage.getText(), "03. Address");
        WebElement ShippingPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(ShippingPageLoc)));
        Assert.assertEquals(ShippingPage.getText(), "04. Shipping");
        WebElement PaymentPage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(PaymentPageLoc)));
        Assert.assertEquals(PaymentPage.getText(), "05. Payment");
        WebElement NextPageLocator = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(NextPageLocatorLoc)));
        Assert.assertEquals(NextPageLocator.getText(), "Proceed to checkout");
        NextPageLocator.click();

        WebElement CreateAccLoc = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='create-account_form']/h3")));
        Assert.assertEquals(CreateAccLoc.getText(), "CREATE AN ACCOUNT");

        WebElement emailLoc = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(.,'Please enter your email address to create an account.')]")));
        Assert.assertEquals(emailLoc.getText(), "Please enter your email address to create an account.");

        WebElement PasswordLoc = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Password')]")));
        Assert.assertEquals(PasswordLoc.getText(), "Password");

        WebElement ForgotPasswordLoc = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Forgot your password?')]")));
        Assert.assertEquals(ForgotPasswordLoc.getText(), "Forgot your password?");

        WebElement LoginFormLoc = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='login_form']/div/div/label")));
        Assert.assertEquals(LoginFormLoc.getText(), "Email address");

        WebElement RegisteredLoc = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='login_form']/h3")));
        Assert.assertEquals(RegisteredLoc.getText(), "ALREADY REGISTERED?");

        WebElement emailaddress = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Email address')]")));
        Assert.assertEquals(emailaddress.getText(), "Email address");
    }

    public void ClickAddToCartButtonPopUpOpens(String out){

        String Loc = "//*[@id=\"homefeatured\"]/li["+out+"]//a[1]/span";
        String Loc2 = "//*[@id=\"homefeatured\"]/li["+out+"]/div/div[2]";
        WebElement AddToCartButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc2)));
        AddToCartButton.click();
        WebElement AddToCartButton2 = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc)));
        AddToCartButton2.click();
        WebElement checkoutButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(checkoutButtonLoc)));
        Assert.assertEquals(checkoutButton.getText(), "Proceed to checkout");
        WebElement continueShoppingButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(continueShoppingLoc)));
        Assert.assertEquals(continueShoppingButton.getText(), "Continue shopping");
        WebElement closeButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(closeButtonLoc)));
        closeButton.click();

    }
    public void ClickMoreButton(String out){
        String Loc3 = "//span[contains(.,'Add to cart')]";
        String Loc = "//*[@id=\"homefeatured\"]/li["+out+"]/div/div[2]/h5";
        String Loc2 = "//*[@id=\"homefeatured\"]/li["+out+"]/div/div[2]/div[2]/a[2]/span";
        WebElement AddToCartButton = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc2)));
        AddToCartButton.click();
        WebElement AddToCartButton2 = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc)));
        AddToCartButton2.click();
        WebElement AddToCartButtonInMorePage = driverWait(30).until(ExpectedConditions.elementToBeClickable(By.xpath(Loc3)));
        Assert.assertEquals(AddToCartButtonInMorePage, "Add to cart");

    }
    public void ClickAddToCartButton(){
        By AddtoCart = By.xpath("//*[@id=\"homefeatured\"]/li//a[1]/span");
        List<WebElement> myElements = getDriver().findElements(AddtoCart);
        Iterator<WebElement> iter = myElements.iterator();
        while (iter.hasNext()) {

            // Iterate one by one
            WebElement item = iter.next();
            // get the text
            String label = item.getAttribute("innerText");

            // print the text
            System.out.println("Row label is " + label);

        }
    }

    public void VerifyMoreButton(){
        By More = By.xpath("//*[@id=\"homefeatured\"]/li//div[2]/a[2]/span");
        List<WebElement> Morelink = getDriver().findElements(More);

        Iterator<WebElement> iter = Morelink.iterator();
        while (iter.hasNext()) {

            // Iterate one by one
            WebElement item = iter.next();

            // get the text
            String label = item.getAttribute("innerText");

            // print the text
            System.out.println("Row of sign in button label is " + label);
        }
    }

    public void verifyLinksInHomePage(){
        WebElement CartLink = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/div[3]/div/div/div[3]/div/a")));
        String CartLinkTxt =   CartLink.getText();
        Assert.assertEquals(CartLinkTxt, "Cart (empty)");
        WebElement Womendropdown = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Women')]")));
        String WomendropdownTxt =   Womendropdown.getText();
        Assert.assertEquals(WomendropdownTxt, "WOMEN");
        WebElement dressdropdown = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Dresses')])[5]")));
        String dressdropdowntxt =   dressdropdown.getText();
        Assert.assertEquals(dressdropdowntxt, "DRESSES");
        WebElement tshirtdropdown = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'T-shirts')])[2]")));
        String tshirtdropdowntxt =   tshirtdropdown.getText();
        Assert.assertEquals(tshirtdropdowntxt, "T-SHIRTS");
        WebElement popularLink = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Popular')]")));
        String popularLinkTxt =   popularLink.getText();
        Assert.assertEquals(popularLinkTxt, "POPULAR");
        WebElement BestSellerLink = driverWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Best Sellers')]")));
        String BestSellerLinkTxt =   BestSellerLink.getText();
        Assert.assertEquals(BestSellerLinkTxt, "BEST SELLERS");
        By AddtoCart = By.xpath("//*[@id=\"homefeatured\"]/li//a[1]/span");
        List<WebElement> myElements = getDriver().findElements(AddtoCart);
        for (int i=0; i<myElements.size();i++){
            String elementText = myElements.get(i).getAttribute("innerText");
            System.out.println("Link button text:" + elementText);
        }
        By More = By.xpath("//*[@id=\"homefeatured\"]/li//div[2]/a[2]/span");
        List<WebElement> Morelink = getDriver().findElements(More);
        for (int i=0; i<Morelink.size();i++){
            String elementText = Morelink.get(i).getAttribute("innerText");
            System.out.println("Link button text:" + elementText);
        }
    }
}
