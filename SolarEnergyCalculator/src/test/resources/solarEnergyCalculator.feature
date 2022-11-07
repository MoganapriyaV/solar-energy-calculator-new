Feature: Solar Energy Calculator for UK resident

  Scenario Outline: Non UK(<<country>) resident trying to access the solar calculator
    Given Launching solar energy calculator site "https://www.pvfitcalculator.energysavingtrust.org.uk/"
    When Entering postcode "<postcode>"
    Then Trying to enter the calculator page by clicking next button and verify the invalid postcode is detected
    Examples:
      | country | postcode |
      | Ireland | D15X435  |
      | Germany | 14199    |
      | US      | 90210    |


  Scenario Outline: UK region <country> resident calculating potential annual benefit that they can get by installing solar system
    Given Launching solar energy calculator site "https://www.pvfitcalculator.energysavingtrust.org.uk/"
    When Entering postcode "<postcode>"
    Then Entering into the calculator page by clicking next button
    And Selecting roof slope <roof slope> degree
    And Selecting shading <shading value> percentage
    And Selecting installation size "<installation size>"
    And Reaching result page by clicking the next button
    Then Checking for "Potential annual benefit" page and taking screenshot
    Examples:
      | country          | postcode | roof slope | shading value | installation size |
      | London           | N1 0JB   | 25         | 20            | 4 kWp             |
      | Scotland         | EH12 7TB | 20         | 20            | 2 kWp             |
      | Northern Ireland | BT10 0QX | 25         | 20            | 4 kWp             |