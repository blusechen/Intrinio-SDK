package client;

import domain.*;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created on 2/3/17.
 */
public class IntrinioClient {
    private HttpClient client;
    private CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    private final String COMPANIES_URL = "https://api.intrinio.com/companies";

    public IntrinioClient(String username, String password) {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        this.credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        this.client = HttpClientBuilder.create().setDefaultCredentialsProvider(this.credentialsProvider).build();
    }

    public Optional<CompanyCompact[]> searchCompanies(String query) {
        try {
            String escapedQuery = URLEncoder.encode(query, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.COMPANIES_URL + "?query=" + escapedQuery));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject companyJSON = new JSONObject(responseBody);
            JSONArray results = companyJSON.has("data") && !companyJSON.isNull("data") ? companyJSON.getJSONArray("data") : new JSONArray();
            return buildCompanyCompactFromJSONArray(results);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<CompanyCompact[]> buildCompanyCompactFromJSONArray(JSONArray data) {
        if (data.length() == 0) {
            return Optional.empty();
        } else {
            CompanyCompact[] companyResults = new CompanyCompact[data.length()];
            for (int i = 0; i < data.length(); i++) {
                JSONObject companyJSON = data.getJSONObject(i);
                String ticker = companyJSON.has("ticker") && !companyJSON.isNull("ticker") ? companyJSON.getString("ticker") : "";
                String name = companyJSON.has("name") && !companyJSON.isNull("name") ? companyJSON.getString("name") : "";
                String lei = companyJSON.has("lei") && !companyJSON.isNull("lei") ? companyJSON.getString("lei") : "";
                String cik = companyJSON.has("cik") && !companyJSON.isNull("cik") ? companyJSON.getString("cik") : "";
                companyResults[i] = new CompanyCompact(ticker, name, lei, cik);
            }
            return Optional.of(companyResults);
        }
    }

    public Optional<Company> getCompanyInformation(String identifier) {
        try {
            String escapedIdentifier = URLEncoder.encode(identifier, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.COMPANIES_URL + "?identifier=" + escapedIdentifier));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject companyJSON = new JSONObject(responseBody);
            return buildCompanyFromJSON(companyJSON);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


    private Optional<Company> buildCompanyFromJSON(JSONObject json) {
        return Optional.of(
                new CompanyBuilder()
                        .template(json.has("template") && !json.isNull("template") ? json.getString("template") : "")
                        .short_description(json.has("short_description") && !json.isNull("short_description") ? json.getString("short_description") : "")
                        .industry_category(json.has("industry_category") && !json.isNull("industry_category") ? json.getString("industry_category") : "")
                        .cik(json.has("cik") && !json.isNull("cik") ? json.getString("cik") : "")
                        .stock_exchange(json.has("stock_exchange") && !json.isNull("stock_exchange") ? json.getString("stock_exchange") : "")
                        .business_address(json.has("business_address") && !json.isNull("business_address") ? json.getString("business_address") : "")
                        .sic(json.has("sic") && !json.isNull("sic") ? json.getInt("sic") : 0)
                        .ceo(json.has("ceo") && !json.isNull("ceo") ? json.getString("ceo") : "")
                        .inc_country(json.has("inc_country") && !json.isNull("inc_country") ? json.getString("inc_country") : "")
                        .securities(getSecuritiesFromJSONArray(json.has("securities") && !json.isNull("securities") ? json.getJSONArray("securities") : new JSONArray()).orElse(null))
                        .lei(json.has("lei") && !json.isNull("lei") ? json.getString("lei") : "")
                        .hq_country(json.has("hq_country") && !json.isNull("hq_country") ? json.getString("hq_country") : "")
                        .company_url(json.has("company_url") && !json.isNull("company_url") ? json.getString("company_url") : "")
                        .hq_state(json.has("hq_state") && !json.isNull("hq_state") ? json.getString("hq_state") : "")
                        .industry_group(json.has("industry_group") && !json.isNull("industry_group") ? json.getString("industry_group") : "")
                        .legal_name(json.has("legal_name") && !json.isNull("legal_name") ? json.getString("legal_name") : "")
                        .sector(json.has("sector") && !json.isNull("sector") ? json.getString("sector") : "")
                        .hq_address1(json.has("hq_address1") && !json.isNull("hq_address1") ? json.getString("hq_address1") : "")
                        .hq_address2(json.has("hq_address2") && !json.isNull("hq_address2") ? json.getString("hq_address2") : "")
                        .ticker(json.has("ticker") && !json.isNull("ticker") ? json.getString("ticker") : "")
                        .long_description(json.has("long_description") && !json.isNull("long_description") ? json.getString("long_description") : "")
                        .hq_address_city(json.has("hq_address_city") && !json.isNull("hq_address_city") ? json.getString("hq_address_city") : "")
                        .mailing_address(json.has("mailing_address") && !json.isNull("mailing_address") ? json.getString("mailing_address") : "")
                        .inc_state(json.has("inc_state") && !json.isNull("inc_state") ? json.getString("inc_state") : "")
                        .standardized_active((json.has("standardized_active") && !json.isNull("standardized_active")) && json.getBoolean("standardized_active"))
                        .entity_legal_form(json.has("entity_legal_form") && !json.isNull("entity_legal_form") ? json.getString("entity_legal_form") : "")
                        .name(json.has("name") && !json.isNull("name") ? json.getString("name") : "")
                        .hq_address_postal_code(json.has("hq_address_postal_code") && !json.isNull("hq_address_postal_code") ? json.getString("hq_address_postal_code") : "")
                        .entity_status(json.has("entity_status") && !json.isNull("entity_status") ? json.getString("entity_status") : "")
                        .employees(json.has("employees") && !json.isNull("employees") ? json.getInt("employees") : 0)
                        .business_phone_no(json.has("business_phone_no") && !json.isNull("business_phone_no") ? json.getString("business_phone_no") : "")
                        .build()
        );
    }

    private Optional<Security[]> getSecuritiesFromJSONArray(JSONArray json) {
        ArrayList<Security> securities = new ArrayList<>();
        for (int i = 0; i < json.length(); i++) {
            JSONObject security = json.getJSONObject(i);
            securities.add(
                    new SecurityBuilder()
                            .Share_class_figi(security.has("share_class_figi") && !security.isNull("share_class_figi") ? security.getString("share_class_figi") : "")
                            .Ticker(security.has("ticker") && !security.isNull("ticker") ? security.getString("ticker") : "")
                            .Stock_exchange(security.has("stock_exchange") && !security.isNull("stock_exchange") ? security.getString("stock_exchange") : "")
                            .Mic(security.has("mic") && !security.isNull("mic") ? security.getString("mic") : "")
                            .Figi_exch_cntry(security.has("figi_exch_cntry") && !security.isNull("figi_exch_cntry") ? security.getString("figi_exch_cntry") : "")
                            .Primary_listing((security.has("primary_listing") && !security.isNull("primary_listing")) && security.getBoolean("primary_listing"))
                            .Figi(security.has("figi") && !security.isNull("figi") ? security.getString("figi") : "")
                            .Figi_uniqueid(security.has("figi_uniqueid") && !security.isNull("figi_uniqueid") ? security.getString("figi_uniqueid") : "")
                            .Delisted_security((security.has("delisted_security") && !security.isNull("delisted_security")) && security.getBoolean("delisted_security"))
                            .Security_name(security.has("security_name") && !security.isNull("security_name") ? security.getString("security_name") : "")
                            .Last_crsp_adj_date(security.has("last_crsp_adj_date") && !security.isNull("last_crsp_adj_date") ? security.getString("last_crsp_adj_date") : "")
                            .Composite_figi(security.has("composite_figi") && !security.isNull("composite_figi") ? security.getString("composite_figi") : "")
                            .Etf((security.has("etf") && !security.isNull("replace")) && security.getBoolean("etf"))
                            .Currency(security.has("currency") && !security.isNull("currency") ? security.getString("currency") : "")
                            .Exch_symbol(security.has("exch_symbol") && !security.isNull("exch_symbol") ? security.getString("exch_symbol") : "")
                            .Security_type(security.has("security_type") && !security.isNull("security_type") ? security.getString("security_type") : "")
                            .Figi_ticker(security.has("figi_ticker") && !security.isNull("figi_ticker") ? security.getString("figi_ticker") : "")
                            .Market_sector(security.has("market_sector") && !security.isNull("market_sector") ? security.getString("market_sector") : "")
                            .build()
            );
        }
        Security[] securitiesArray = new Security[securities.size()];
        securitiesArray = securities.toArray(securitiesArray);
        return Optional.of(securitiesArray);
    }


}
