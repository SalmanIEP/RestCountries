package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GetCountryCode_Steps {
    @And("The Response includes a proper message as {string}")
    public void theResponseIncludesAProperMessageAs(String arg0) {

    }

    @Given("The User searches for individual WIPO country by passing country name as parameter")
    public void theUserSearchesForIndividualWIPOCountryByPassingCountryNameAsParameter() {
    }

    @When("User consume the service for getting details of the country")
    public void userConsumeTheServiceForGettingDetailsOfTheCountry() {
    }

    @And("The Response includes Details of the Country")
    public void theResponseIncludesDetailsOfTheCountry() {
    }

    @Given("The User searches for individual WIPO country by passing {string} as {string}")
    public void theUserSearchesForIndividualWIPOCountryByPassingAs(String arg0, String arg1) {
    }

    @Given("The User searches for individual WIPO country by passing Incorrect country name")
    public void theUserSearchesForIndividualWIPOCountryByPassingIncorrectCountryName() {
    }
}
