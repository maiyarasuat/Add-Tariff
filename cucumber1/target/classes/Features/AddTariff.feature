#Author: maiyarasu@gmail.com


Feature: Add Tariff Plan Validation
  
  Scenario: Add Tariff Plans
    Given user launches demo telecom applications	
    And click on add tariff plans
    When user enters all the field
    And user click on submit buttons
    Then user verify tariff plan is generated
  
Scenario: Add Tariff Plan
    Given launch demo telecom webpage
    And click on add tariff plans
    When user click the all fileds by using one dim list
    |400|500|450|300|1|2|1|
    And user click on submit buttons
    Then user verify Congratulations is generted
    
  Scenario: Add Tariff Plan
    Given user launch demo telecom webpage
    And user click on addtarficplan button
    When user click the all fileds by using one dim map 
   		
      | rental          | 1 |
      | local_minutes   | 2 |
      | inter_minutes   | 3 |
      | sms_pac         | 4 |
      | minutes_charges | 5 |
      | inter_charges   | 6 |
      | sms_charges     | 3|
    And user click the submit button
    Then user verify Congratulation is genereted
      
