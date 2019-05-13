package org.thermoweb.sncf.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SncfApi {

    private String login;
    private String baseUrl;
    private String url;

    public SncfApi(String login) {
        this.login = login;
        this.baseUrl = "https://api.sncf.com/v1/coverage/sncf/";
        this.url = this.baseUrl + "stop_areas/stop_area:OCE:SA:87381137/departures";
    }

    public SncfApi(String url, String login) {
        this(login);
        this.url = this.baseUrl + url;
    }

    public SncfApiResponse doGet() {
        ObjectMapper mapper = new ObjectMapper();
        SncfApiResponse sncfResponse = null;
        try {
            sncfResponse = mapper.readValue(executeGet(), SncfApiResponse.class);
            System.out.println(sncfResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sncfResponse;
    }

    public String executeGet() {
        String result = null;
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(this.url);

        request.addHeader("Authorization", this.login);
        try {
            HttpResponse response = httpclient.execute(request);
            result = getResponseAsString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getResponseAsString(HttpResponse response) throws IOException {
        StringBuffer result = new StringBuffer();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}