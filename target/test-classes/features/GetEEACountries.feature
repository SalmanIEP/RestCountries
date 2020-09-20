Feature: The purpose of this is to return all the Wipo countries that are in the EEA based

  Scenario: Getting all the details of the EEA based WIPO countries
    Given The User searches for all EEA based WIPO countries
    When User consume the service for getting details of EEA based WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response includes all EEA based WIPO Countries

  Scenario: Getting details of all EEA based WIPO countries as default without query parameters
    Given The User searches for all EEA based WIPO countries
    When User consume the service for getting details of EEA based WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response includes following details of the WIPO Countries where ValidTo is NULL and IsInEEA is true
      |Code|  text     |ApplicationNumberFormat|IsRegionalOffice|IsInEEA|IsEC |CanClaimPriority|IsTrademarkEntity|IsPatentEntity|ValidFrom|ValidTo|
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |

  Scenario: Getting all the details of the EEA based WIPO countries with optional parameter as lookup
    Given The User searches for all EEA based WIPO countries with "lookup" parameter as "true"
    When User consume the service for getting details of EEA based WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response consist of  only the code, countryEndonym and name for each EEA based country