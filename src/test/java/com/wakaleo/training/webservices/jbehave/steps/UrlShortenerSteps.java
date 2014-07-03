package com.wakaleo.training.webservices.jbehave.steps;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class UrlShortenerSteps {

    RestTemplate restTemplate;

    public UrlShortenerSteps() {
        restTemplate = new RestTemplate();
    }

    public String shorten(String providedUrl) {
        Map<String, String> urlForm = new HashMap<String, String>();
        urlForm.put("longUrl", providedUrl);
        return restTemplate.postForObject("https://www.googleapis.com/urlshortener/v1/url", urlForm, String.class);
    }

    public String expand(String providedUrl) {
        return restTemplate.getForObject("https://www.googleapis.com/urlshortener/v1/url?shortUrl={shortUrl}", String.class, providedUrl);
    }

    public void response_should_contain_shortened_url(String returnedMessage, String expectedUrl) throws JSONException {
        String expectedJSONMessage = "{'id':'" + expectedUrl + "'}";
        JSONAssert.assertEquals(expectedJSONMessage, returnedMessage, JSONCompareMode.LENIENT);
    }

    public void response_should_contain_long_url(String returnedMessage, String expectedUrl) throws JSONException {
        String expectedJSONMessage = "{'longUrl':'" + expectedUrl + "'}";
        JSONAssert.assertEquals(expectedJSONMessage, returnedMessage, JSONCompareMode.LENIENT);
    }
}
