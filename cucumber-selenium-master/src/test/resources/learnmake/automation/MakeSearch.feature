Feature: Verifying features available in the demo page

  @web @chrome @AutomationPracticePage
  Scenario: Verify Home Page
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page

  @web @chrome @AutomationPracticePage
  Scenario: Verify Add to cart Page
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page
    Then I click Add to cart button

  @web @chrome @AutomationPracticePage
  Scenario: Verify Add to cart Page pop up opens
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page
    Then I click Add to cart button
    And I click Add to cart button Number "1" with popup

  @web @chrome @AutomationPracticePage
  Scenario: Verify Add to cart Page pop up opens and checkout page is verified
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page
    Then I click Add to cart button
    And I click Add to cart button Number "1" with popup and Checkout

  @web @chrome @AutomationPracticePage
  Scenario: Verify Add to cart Page pop up opens and sign in page is verified
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page
    Then I click Add to cart button
    And I click Add to cart button Number "1" with popup and Checkout
    Then I Navigate to SigninButton

  @web @chrome @AutomationPracticePage
  Scenario: Verify More Button in homePage
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page
    Then I Verify More button

  @web @chrome @AutomationPracticePage
  Scenario: Verify More Button in MorePage
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    Then the Home Page linkText "Sign in" is shown
    And I verify links in Home Page
    Then I Verify More button
    And I Verify More Button After Clicking in Home Page

  @web @chrome @AutomationPracticePage
  Scenario: Verify Contact Us Page
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    And I Navigate And Verify To Contact us page

  @web @chrome @AutomationPracticePage
  Scenario: Fill Contact Us Page
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    And I Navigate And Verify To Contact us page
    Then I Fill Contact us page "balaje.prabakar@gmail.com "11221212 "Item not shipped"

  @web @chrome @AutomationPracticePage
  Scenario: Verify Contact Us Page Error Message
    Given a web browser is opened with home page
    When the Home Page is shown
    Then the Home Page linkText "Contact us" is shown
    And I Navigate And Verify To Contact us page
    Then I Validate Error Message
