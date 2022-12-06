package api.tests;
import Models.Countries;
import Models.NationalizeModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.assertThat;
import static response.actions.ResponseActions.*;

public class ResponseActionsTests extends BaseTest{
    SoftAssert soft = new SoftAssert();
    @Test
    public void validateThatCountriesListObjectReturnedInBEResponse() {
        sendNationalizeGetRequest("Elaf");
        Assert.assertEquals(responseStatusCode(),200);
        Assert.assertTrue(responseBody().contains("\"country\""));
    }
    @Test
    public void validateThatEachCountryConsistsOfCountryIdAndProbability () {
        sendNationalizeGetRequest("Test");
        Assert.assertEquals(responseStatusCode(),200);
        soft.assertTrue(responseBody().contains("country_id"));
        soft.assertTrue(responseBody().contains("probability"));
        soft.assertAll();

    }
    @Test
    public void validateThatNameReturnedInBEReponseMatchesTheNameEnteredInTheRequestParameters() {
        String name = "Elaf";
        sendNationalizeGetRequest(name);
        Assert.assertEquals(responseStatusCode(),200);
        Assert.assertEquals(responseJsonBody().getName(),name);
    }
    @Test
    public void validateThatEveryProbabilityKeyInBEResponseDoesNotExceed1(){
        sendNationalizeGetRequest("Elaf");
        Assert.assertEquals(responseStatusCode(),200);
        for (Countries country : responseJsonBody().getCountries()){
            Assert.assertTrue(country.getProbability()<=1);
        }
    }
    @Test
    public void validateThatNameParameterValueIsNotCaseSensitive() {
        sendNationalizeGetRequest("elaf");
        Assert.assertEquals(responseStatusCode(),200);
        NationalizeModel lowerCaseBEResponse = responseJsonBody();
        sendNationalizeGetRequest("ELAF");
        Assert.assertEquals(responseStatusCode(),200);
        NationalizeModel upperCaseBEResponse = responseJsonBody();
        assertThat(lowerCaseBEResponse.getCountries())
                .usingRecursiveComparison()
                .isEqualTo(upperCaseBEResponse.getCountries());
    }
    @Test
    public void validateThatBEReturnsEmptyResponseWhenUserSendsInvalidData() {
        sendNationalizeGetRequest("Elaf3124");
        Assert.assertEquals(responseStatusCode(),200);
        Assert.assertTrue(responseJsonBody().getCountries().isEmpty());
    }
    @Test
    public void validateThatBEReturnsEmptyResponseWhenUserSendsEmptyNameParameter() {
        sendNationalizeGetRequest("");
        Assert.assertEquals(responseStatusCode(),200);
        Assert.assertTrue(responseJsonBody().getCountries().isEmpty());
    }
}
