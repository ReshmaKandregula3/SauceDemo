#@Shopping
#  @Severity=critical
#  @Owner=Reshma
#  @Epic:Shopping-website
#
#Feature: Swaglabs shopping site
##  @Regression @Smoke
#
#  Scenario Outline: login page
#    Given i am an existing user
#    When i open browser to "<url>": www.saucedemo.com
#    And fill correct username as "<Username>" and password as "<password>"
#    And press login button
#    Then i see my application dashboard
#    Examples:
#      |             url               | Username | password |
#      |   https://www.saucedemo.com/  |standard_user |   secret_sauce  |
#
#
#Scenario: Verify Shopping cart
#  Given Check all the products
#  And Select the product that you want to order
#  When Click on Add to cart
#  And it will add all your products in shopping cart
#  Then Click on shopping cart icon
#
#
#Scenario: Continue Shopping
#  Given if i want to add new items
#  Then Click on Continue shopping
#  And it will redirect to homepage
#
#
##  Scenario Outline: Verify login page
##    Given Open website
##    Then user enters "<UserName>" and password "<Password>"
##    When login to the website
##    Examples:
##      | UserName | Password |
##      | standard_user |   secret_sauce  |
#
#
##  @Smoke
##  Scenario: Verify shopping cart
##    Given Add product to the cart
##    Then Click on continue
#
#      @Regression
#  Scenario: Continue Shopping
#    Given Add another item
#    Then Checkout the product
#    And remove Item from cart
#
#        @Smoke
#  Scenario: Finishing order process
#    Given Enter address information
#    Then Click Finish
#
#          @Regression
#  Scenario: Logout from page
#    Given goto react button
#    Then click logout
#    And Close Browser
#
#
#
