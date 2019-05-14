package org.thermoweb.sncf.api;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class BaseApi {

    private static Logger logger = Logger.getLogger(BaseApi.class);

    private String login;
    private String password;
    private String baseUrl;

    BaseApi(String url) {
        this.baseUrl = url;
    }

    String doGet(String url) {
        String result;
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(this.baseUrl + url);

        String auth = this.login + ":" + this.password;
        String encoding = Base64.getEncoder().encodeToString(auth.getBytes());
        request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

        try {
            HttpResponse response = httpclient.execute(request);
            result = getResponseAsString(response);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return "";
        }
        return result;
    }

    private String getResponseAsString(HttpResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }

    public String getLogin() {
        return login;
    }

    void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
