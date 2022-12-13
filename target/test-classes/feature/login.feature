@Shopping
  @Severity=critical
  @Owner=Reshma
  @Epic:Shopping-website

Feature: Swaglabs shopping site
  @Regression @Smoke
  Scenario Outline: Verify login page
    Given Open website
    Then user enters "<UserName>" and password "<Password>"
    When login to the website
    Examples:
      | UserName | Password |
      | standard_user |   secret_sauce  |
#      | locked_out_user |   secret_sauce  |


#    Scenario Outline: Verify login page with invalid credentials
#      Given user enters invalid "<UserName>" and password "<Password>"
#      Then Error message displayed with wrong password
#      Examples:
#        | UserName | Password |

  @Smoke
  Scenario: Verify shopping cart
    Given Add product to the cart
    Then Click on continue

      @Regression
  Scenario: Continue Shopping
    Given Add another item
    Then Checkout the product
    And remove Item from cart

        @Smoke
  Scenario: Finishing order process
    Given Enter address information
    Then Click Finish

          @Regression
  Scenario: Logout from page
    Given goto react button
    Then click logout
    And Close Browser

