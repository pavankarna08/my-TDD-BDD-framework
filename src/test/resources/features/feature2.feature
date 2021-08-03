@smoketest
Feature: Gmail Login

  Scenario Outline: validate password in login page with cross browser
    Given launch site using "<bn>" in "<evn>" environment
    When enter userid as "testernew51"
    And click userid next button
    And enter password as "<pwd>"
    And click password next button
    Then validate outcome related to given password criteria like "<pwdcriteria>"
    When close site

    Examples: 
      | pwd         | pwdcriteria | bn      | evn |
      | 123456@mail | valid       | chrome  | QA  |
      | 123456@mail | valid       | firefox | QA  |
      | 123456@mail | valid       | opera   | QA  |
      | 123456@mail | valid       | edge    | QA  |
      | 123456mail  | invalid     | chrome  | QA  |
      | 123456mail  | invalid     | firefox | QA  |
      | 123456mail  | invalid     | opera   | QA  |
      | 123456mail  | invalid     | edge    | QA  |
      |             | blank       | chrome  | QA  |
      |             | blank       | firefox | QA  |
      |             | blank       | opera   | QA  |
      |             | blank       | edge    | QA  |

      