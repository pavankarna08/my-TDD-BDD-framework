Feature: Gmail compose

  @smometest
  Scenario: Validate mail compose
    Given launch site using "chrome" in "QA" environment
    When enter userid as "testernew51"
    And click userid next button
    And enter password as "123456@mail"
    And click password next button
    And send mail and test
      | to                             | subject | body     | attachment                                                    |
      | pavankarna08@gmail.com         | wishes  | hi pavan | C:\\Users\\Pavan Kumar\\OneDrive\\Desktop\\imp\\accenture.png |
      | pavankumar.karna1997@gmail.com | wishes  | hi all   | C:\\Users\\Pavan Kumar\\OneDrive\\Desktop\\imp\\accenture.png |
    When do logout
    And quit site
