package StepDefinitions;

import SerenityRestapiHelpers.RestApiHelper;
import SerenityRestapiHelpers.helper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GetCountries_Steps {

    Response response;
    String RequestUrl;

    //First
    @Given("The User searches for all WIPO countries")
    public void theUserSearchesForAllWIPOCountries() throws IOException {

        RequestUrl = helper.Properties("BaseUrl")+"/"+helper.Properties("GetCountryEndPoint");
    }

    @When("User consume the service for getting details of WIPO countries")
    public void userConsumeTheServiceForGettingDetailsOfWIPOCountries() throws IOException {

        response = RestApiHelper.doGetRequest(RequestUrl);
    }
    @Then("Then Service must return the Response Status code as {string}")
    public void thenServiceMustReturnTheResponseStatusCodeAs(String arg0) {

        assertThat(response.statusCode(),is(arg0));
    }

    @And("The Response includes Details of all WIPO Countries")
    public void theResponseIncludesDetailsOfAllWIPOCountries() {

        //We will get the list of countries from the response and count it and assert with expected count
    }

    //2nd

    @And("The Response includes following details of the WIPO Countries where where ValidTo is NULL and IsRegionalOffice and IsInternationalOffice are false")
    public void theResponseIncludesFollowingDetailsOfTheWIPOCountriesWhereWhereValidToIsNULLAndIsRegionalOfficeAndIsInternationalOfficeAreFalse(List<Map<String, String>> details) throws IOException {

        Gson gson = new Gson();
        //Setting up Expected Json
        JsonObject data = new JsonObject();
        JsonArray jsonArray = gson.toJsonTree(details).getAsJsonArray();
        data.add("countries",jsonArray);
        String json = gson.toJson(data);
        String ExpectedJson ="{ \"data\":{ \"countryDetails\" "+":"+json+"} }";
        //--------------------------------------------------------------------------------

        String ActualJson=response.getBody().asString();
        assertThat(ActualJson, jsonEquals(ExpectedJson).when(IGNORING_EXTRA_FIELDS,IGNORING_ARRAY_ORDER));

    }

    //Third

    @Given("The User searches for the WIPO countries with query parameter includeHistoric as {string}")
    public void theUserSearchesForTheWIPOCountriesWithQueryParameterIncludeHistoricAs(String arg0) {

        RequestUrl = "https:getcountries/IncludeHistoric?"+arg0;
    }


    @And("The Response must includes the details of the countries for Date to which country information is valid and not null")
    public void theResponseMustIncludesTheDetailsOfTheCountriesForDateToWhichCountryInformationIsValidAndNotNull() throws IOException {

        response= RestApiHelper.doGetRequest(RequestUrl);
    }


    //4rth
    @Given("The User searches for the WIPO countries with query parameter includeOffices as {string}")
    public void theUserSearchesForTheWIPOCountriesWithQueryParameterIncludeOfficesAs(String arg0) {

        RequestUrl = "https:getcountries/includeOffices?"+arg0;
    }

    @And("The Response must includes the details of the countries where IsRegionalOffice and IsInternationalOffice are true")
    public void theResponseMustIncludesTheDetailsOfTheCountriesWhereIsRegionalOfficeAndIsInternationalOfficeAreTrue() {

        //here we will loop on all the countries return by the api and confirm IncludeOffices key have value as true for each case
    }


    //5th

    @Given("The User searches for the WIPO countries with query parameter lookup as {string}")
    public void theUserSearchesForTheWIPOCountriesWithQueryParameterLookupAs(String arg0) {
    }

    @And("The Response consist of  only the code, countryEndonym and name for each country")
    public void theResponseConsistOfOnlyTheCodeCountryEndonymAndNameForEachCountry() {
    }

    //6th
    @Given("The User searches for the WIPO countries with query parameter {string} as {string} and {string} as {string}")
    public void theUserSearchesForTheWIPOCountriesWithQueryParameterAsAndAs(String arg0, String arg1, String arg2, String arg3) {
    }

    @And("The Response consist of  only the code, countryEndonym and name for each country where Date to which country information is valid")
    public void theResponseConsistOfOnlyTheCodeCountryEndonymAndNameForEachCountryWhereDateToWhichCountryInformationIsValid() {
    }

    @And("The Response consist of  all details for each country where Date to which country information is valid")
    public void theResponseConsistOfAllDetailsForEachCountryWhereDateToWhichCountryInformationIsValid() {

    }
}
