#Author: maiyarasu@gmail.com
Feature: Add Customer flow validation

 Background:
    Given user launches demo telecom application
    And click on add customer button


  Scenario: Add Customer

   When user enters all the fields by
   And user click on submit button
   Then user verify customer id is generated
  Scenario: Add Customer validation by using 1 dim list

   When user enters all the fields by one dim list concept
     | maiyarasu | s | maiyarasu@gmail.com | salem | 8220807375 |
   And user click on submit button
   Then user verify customer id is generated
  Scenario: Add Customer validation by using 1 dim list
    
    When user enters all the fields by one dim map concept
      | fname   | maiyarasu           |
      | lname   | s                   |
      | mail    | maiyarasu@gmail.com |
      | address | salem               |
      | phno    |          8220807375 |
    And user click on submit button
    Then user verify customer id is generated

  Scenario Outline: 
    
    When user enters all the fields by "<fname>","<lname>","<mail>","<address>","<phno>"
    And user click on submit button
    Then user verify customer id is generated

    Examples: 
      | fname     | lname | mail                | address | phno       |
      | maiyarasu | s     | maiyarasu@gmail.com | salem   | 8220807375 |
      | maiyarasu | s     | maiyarasu@gmail.com | salem   | 8220807375 |
      | maiyarasu | s     | maiyarasu@gmail.com | salem   | 8220807375 |
      | maiyarasu | s     | maiyarasu@gmail.com | salem   | 8220807375 |
