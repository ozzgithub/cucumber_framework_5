

Feature: Wikipedia Search Functionality


Scenario Outline: Validate wiki search



Given user navigates to "https://www.wikipedia.org/"
When user searches for "<key>" on Wikipedia
Then user should see "<title>" in the title
And user should see "<url>" in the url
And user should see "<heading>" in the first heading


  Examples:

  |    key       |    title   |     url      |   heading   |

  |  Elon Musk   | Elon Musk  |  Elon Musk   |  Elon Musk  |
  |  Bill Gates  | Bill Gates |  Bill Gates  |  Bill Gates |
  |  Ataturk     | Ataturk    |  Ataturk     |  Ataturk    |


