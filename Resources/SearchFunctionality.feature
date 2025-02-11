Feature: Verify search functionality

  @UI_Sanity
  Scenario: Verify search results on home page
    Given User is on home page
    And Click on search icon of landing page
    And Search for keyword "IFRS 17"
    And Click on search icon of landing page
    Then Verify result contains text
      | Financials                                            |
      | Interim results for the six months ended 30 June 2022 |
      | Results for the year ended 31 December 2023           |
      | Interim Report 2023                                   |
      | Kirstin Simon                                         |
      | Gavin Wilkinson                                       |
      | Simon Lee                                             |
      | John King                                             |
    Then Close browser

  @UI_Sanity
  Scenario: Verify search suggestions
    Given User is on home page
    And Click on search icon of landing page
    And Search for keyword "IFRS 17"
    And Verify search suggestions
      | Financials                                            |
      | Interim results for the six months ended 30 June 2022 |
      | Results for the year ended 31 December 2023           |
      | Interim Report 2023                                   |
      | Kirstin Simon                                         |
    Then Close browser
