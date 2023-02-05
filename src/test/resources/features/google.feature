Feature: Google Search Functionality


  Scenario: Validate Google Search
    Given user navigates to "https://www.google.com/"
    When user search for "Tesla"
    Then user should see "Tesla" in the url
    And user should see "Tesla" in the title

    @Smoke
  Scenario: Validate Google Search results
    Given user navigates to "https://www.google.com/"
    When user search for "Apple"
    Then user should see results are more than 0


