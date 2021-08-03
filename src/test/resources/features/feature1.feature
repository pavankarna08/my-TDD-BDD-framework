Feature: Gmail Login

  Background: 
    Given launch site using "chrome" in "DEV" environment

  @smoketest
  Scenario: Validate Gmail home page title
    Then title should be "Gmail"
    When close site

  Scenario Outline: Validate Userid in home page
    When enter userid as "<uid>"
    And click userid next button
    Then validate outcome related to given userid criteria like "<uidcriteria>"
    When close site

    @smoketest
    Examples: 
      | uid         | uidcriteria |
      | testernew51 | valid       |

    Examples: 
      | uid      | uidcriteria |
      | tester51 | invalid     |
      |          | blank       |
