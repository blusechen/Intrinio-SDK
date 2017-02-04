package client;

import domain.Company;
import domain.CompanyBuilder;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Optional;

/**
 * Created on 2/3/17.
 */
public class IntrinioClient {
    private HttpClient client;
    private CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    private final String COMPANIES_URL = "https://api.intrinio.com/companies";

    public IntrinioClient(String username, String password){
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        this.credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        this.client = HttpClientBuilder.create().setDefaultCredentialsProvider(this.credentialsProvider).build();
    }

    public Optional<Company> getCompanyInformation(String identifier){
        try{
            HttpResponse response = this.client.execute(new HttpGet(this.COMPANIES_URL + "?identifier=" + identifier));
            System.out.println(response.getStatusLine().getStatusCode());
            JSONObject companyJSON = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
            System.out.println(companyJSON.toString());
            return Optional.empty();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


}
