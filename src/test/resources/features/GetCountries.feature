Feature: Getting details of WIPO’s members countries/States by service using different query parameters

  Scenario: Getting all the details of the WIPO countries
    Given The User searches for all WIPO countries
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response includes Details of all WIPO Countries

  Scenario: Getting all details Wipo countries as default without query parameters
    Given The User searches for all WIPO countries
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response includes following details of the WIPO Countries where where ValidTo is NULL and IsRegionalOffice and IsInternationalOffice are false
      |Code|  text     |ApplicationNumberFormat|IsRegionalOffice|IsInEEA|IsEC |CanClaimPriority|IsTrademarkEntity|IsPatentEntity|ValidFrom|ValidTo|
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |
      | AD |Andorra    |                       |        true    |true   |true |    true        |  true           |       true   |   null  |  null |

  Scenario: Getting details of the wipo countries with specific query parameters include history
    Given The User searches for the WIPO countries with query parameter includeHistoric as "true"
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response must includes the details of the countries for Date to which country information is valid and not null


  Scenario: Getting details of the wipo countries with specific query parameters such as includeOffices
    Given The User searches for the WIPO countries with query parameter includeOffices as "true"
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response must includes the details of the countries where IsRegionalOffice and IsInternationalOffice are true

  Scenario: Getting details of the wipo countries with specific query parameters such as lookup
    Given The User searches for the WIPO countries with query parameter lookup as "true"
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response consist of  only the code, countryEndonym and name for each country

  Scenario: Getting details of the wipo countries with query parameters as lookup and includeHistoric as true
    Given The User searches for the WIPO countries with query parameter "lookup" as "true" and "includeHistoric" as "true"
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response consist of  only the code, countryEndonym and name for each country where Date to which country information is valid

  Scenario: Getting details of the wipo countries with query parameters as lookup as false and includeHistoric as true
    Given The User searches for the WIPO countries with query parameter "lookup" as "false" and "includeHistoric" as "true"
    When User consume the service for getting details of WIPO countries
    Then Then Service must return the Response Status code as "200"
    And  The Response consist of  all details for each country where Date to which country information is valid