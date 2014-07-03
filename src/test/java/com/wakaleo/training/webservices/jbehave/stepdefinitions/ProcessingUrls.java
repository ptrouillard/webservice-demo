package com.wakaleo.training.webservices.jbehave.stepdefinitions;

import com.wakaleo.training.webservices.jbehave.steps.UrlShortenerSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class ProcessingUrls extends UrlShortenerSteps {

    String providedUrl;
    String returnedMessage;

    @Given("a url <providedUrl>")
    @Alias("a url $providedUrl")
    public void givenAUrl(String providedUrl) {
        this.providedUrl = providedUrl;
    }

    @When("I request the shortened form of this url")
    public void shortenUrl() {
        returnedMessage = shorten(providedUrl);
    }

    @When("I request the expanded form of this url")
    public void expandUrl() {
        returnedMessage = expand(providedUrl);
    }

    @Then("the shortened form should be <expectedUrl>")
    public void shortenedFormShouldBe(String expectedUrl) throws JSONException {
        response_should_contain_shortened_url(returnedMessage, expectedUrl);
    }

    @Then("the long form should be <expectedUrl>")
    public void longFormShouldBe(String expectedUrl) throws JSONException {
        response_should_contain_long_url(returnedMessage, expectedUrl);
    }

    @Then("I should obtain the following JSON message: $expectedJSONMessage")
    public void shouldObtainJsonMessage(String expectedJSONMessage) throws JSONException {
        JSONAssert.assertEquals(expectedJSONMessage, returnedMessage, JSONCompareMode.LENIENT);
    }
}
