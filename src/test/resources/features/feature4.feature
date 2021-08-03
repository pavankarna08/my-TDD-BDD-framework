Feature: Gmail compose

  @realtest
  Scenario: VAlidate mail compose
    Given launch site using "chrome" in "QA" environment
    When enter userid as "testernew51"
    And click userid next button
    And enter password as "123456@mail"
    And click password next button
    And send mail and test by taking data from text file "\src\test\resources\testdata\mailtestdata.txt"
    When do logout
    And quit site