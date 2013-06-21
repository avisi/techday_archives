Feature: Search for the cheapest IPhone
  In order to find the cheapest IPhone
  As a user without a money for a IPhone
  I want tweakers to advise me

  Scenario: search for IPhone prices
    Given I am on the homepage
    When I search for the word "iphone" in pricewatch
    And I sort ascending by "Prijs"
    And I filter on "Mobiele telefoons"
    Then the cheapest IPhone is shown at the top of the list
    And the price is 279,85
