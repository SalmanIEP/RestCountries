Feature: Getting details of WIPO’s members individual countries

  Scenario : Getting the details of the specific country
    Given The User searches for individual WIPO country by passing country name as parameter
    When User consume the service for getting details of the country
    Then Then Service must return the Response Status code as "200"
    And  The Response includes Details of the Country

  Scenario : Getting the code for the specific country by passing lookup as true
    Given The User searches for individual WIPO country by passing "lookup" as "true"
    When User consume the service for getting details of the country
    Then Then Service must return the Response Status code as "200"
    And  The Response includes Details of the Country

  Scenario : User did not get any detail of the country if provided country paramtere is incorrect
    Given The User searches for individual WIPO country by passing Incorrect country name
    When User consume the service for getting details of the country
    Then Then Service must return the Response Status code as "400"
    And  The Response includes a proper message as "Invalid country Name"




