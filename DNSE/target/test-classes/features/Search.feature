Feature: Search DNSE

  @Search
  Scenario: Seach Senses
    Given "User" Open the DNSE website
    When Go to the Senses page
    And Search with text "DS"
    Then Get link Share
    When Back to the Senses page
    And Chose stock index "3"
    Then Print stock
