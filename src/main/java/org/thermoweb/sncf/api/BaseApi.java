/*******************************************************************************
 * Copyright French Prime minister Office/SGMAP/DINSIC/Vitam Program (2015-2019)
 *
 * contact.vitam@culture.gouv.fr
 *
 * This software is a computer program whose purpose is to implement a digital archiving back-office system managing
 * high volumetry securely and efficiently.
 *
 * This software is governed by the CeCILL 2.1 license under French law and abiding by the rules of distribution of free
 * software. You can use, modify and/ or redistribute the software under the terms of the CeCILL 2.1 license as
 * circulated by CEA, CNRS and INRIA at the following URL "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and rights to copy, modify and redistribute granted by the license,
 * users are provided only with a limited warranty and the software's author, the holder of the economic rights, and the
 * successive licensors have only limited liability.
 *
 * In this respect, the user's attention is drawn to the risks associated with loading, using, modifying and/or
 * developing or reproducing the software by the user in light of its specific status of free software, that may mean
 * that it is complicated to manipulate, and that also therefore means that it is reserved for developers and
 * experienced professionals having in-depth computer knowledge. Users are therefore encouraged to load and test the
 * software's suitability as regards their requirements in conditions enabling the security of their systems and/or data
 * to be ensured and, more generally, to use and operate it in the same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had knowledge of the CeCILL 2.1 license and that you
 * accept its terms.
 *******************************************************************************/

package org.thermoweb.sncf.api;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.thermoweb.sncf.model.Passages;
import org.thermoweb.sncf.utils.SncfProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Base64;

public class BaseApi {

    private String login;
    private String password;
    private String baseUrl;
    private SncfProperties properties= SncfProperties.getInstance();

    public BaseApi(String url) {
        this.login = properties.getProperty("sncf.login");
        this.password = properties.getProperty("sncf.password");
        this.baseUrl = url;
    }

    protected Passages doGet(String url, Class type) {
        String result = executeGet(this.getBaseUrl() + url);
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return (Passages) unmarshaller.unmarshal(new StringReader(result));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String executeGet(String url) {
        String result = null;
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        String auth = this.login + ":" + this.password;
        String encoding = Base64.getEncoder().encodeToString(auth.getBytes());
        request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

        try {
            HttpResponse response = httpclient.execute(request);
            result = getResponseAsString(response);
        } catch (IOException e) {
            e.printStackTrace();
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

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
