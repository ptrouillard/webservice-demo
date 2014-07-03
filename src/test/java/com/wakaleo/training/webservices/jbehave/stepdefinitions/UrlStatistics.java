package com.wakaleo.training.webservices.jbehave.stepdefinitions;

import com.wakaleo.training.webservices.jbehave.steps.UrlShortenerSteps;
import com.wakaleo.training.webservices.jbehave.steps.WebUser;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * A description goes here.
 * User: john
 * Date: 16/04/2014
 * Time: 11:36 AM
 */
public class UrlStatistics extends UrlShortenerSteps {

    @Steps
    WebUser webUser;

    String shortUrl;
    @Given("I have registered a shortened URL for $longUrl")
    public void givenIHaveRegisteredAShortenedURLFor(String longUrl) {
        shortUrl = shorten(longUrl);
    }

    @Given("it has been clicked $n times")
    public void givenItHasBeenClickedNTimes(int n) {
        webUser.clicksOnLinkNTime(shortUrl, n);
    }

    @When("I query usage statistics for http://www.google.com")
    public void whenIQueryUsageStatisticsForHttpwwwgooglecom() {
        // PENDING
    }

    @Then("I should get 10 clicks")
    public void thenIShouldGet10Clicks() {
        // PENDING
    }

    @Then("the URL status should be ACTIVE")
    public void thenTheURLStatusShouldBeACTIVE() {
        // PENDING
    }
}
