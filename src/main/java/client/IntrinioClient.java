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
    private final String SECURITIES_URL = "https://api.intrinio.com/securities";
    private final String PRICES_URL = "https://api.intrinio.com/prices";


    public IntrinioClient(String username, String password) {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
        this.credentialsProvider.setCredentials(AuthScope.ANY, credentials);
        this.client = HttpClientBuilder.create().setDefaultCredentialsProvider(this.credentialsProvider).build();
    }

    /**
     * This method will hit hit the https://api.intrinio.com/companies endpoint
     * and search for the company with the given query. Results returned from this
     * method are an incomplete dataset. Typically, this method will be used
     * to find a company then use the getCompanyInformation() method will be called for
     * a complete dataset relating to the company.
     *
     * @param query String query with which to search
     * @return Empty optional if no results found, otherwise an array of CompanyCompact results
     */
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
        } catch (IOException | JSONException e) {
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

    /**
     * This method will hit the https://api.intrinio.com/companies endpoint and return all data
     * associated with the company with the given identifier.
     *
     * @param identifier The stock symbol associated with the company
     * @return Empty optional if no company found, or a Company object containing all related information.
     */
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

    /**
     * This method will hit hit the https://api.intrinio.com/securities endpoint
     * and search for the security with the given query. Results returned from this
     * method are an incomplete dataset. Typically, this method will be used
     * to find a Security then use the getSecurityInformation() method will be called for
     * a complete dataset relating to the Security.
     *
     * @param query String query with which to search
     * @return Empty optional if no results found, otherwise an array of SecurityCompact results
     */
    public Optional<SecurityCompact[]> searchSecuritiesByQuery(String query) {
        try {
            String escapedQuery = URLEncoder.encode(query, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.SECURITIES_URL + "?query=" + escapedQuery));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject securityJSON = new JSONObject(responseBody);
            JSONArray results = securityJSON.has("data") && !securityJSON.isNull("data") ? securityJSON.getJSONArray("data") : new JSONArray();
            return buildSecurityCompactFromJSONArray(results);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * This method will hit hit the https://api.intrinio.com/securities endpoint
     * and search for all securities on the given exchange. Results returned from this
     * method are compact.
     *
     * @param exchange String exchange with which to search
     * @return Empty optional if no results found, otherwise an array of SecurityCompact results
     */
    public Optional<SecurityCompact[]> searchSecuritiesByExchange(String exchange) {
        try {
            String escapedQuery = URLEncoder.encode(exchange, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.SECURITIES_URL + "?exch_symbol=" + escapedQuery));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject securityJSON = new JSONObject(responseBody);
            JSONArray results = securityJSON.has("data") && !securityJSON.isNull("data") ? securityJSON.getJSONArray("data") : new JSONArray();
            return buildSecurityCompactFromJSONArray(results);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<SecurityCompact[]> buildSecurityCompactFromJSONArray(JSONArray data) {
        if (data.length() == 0) {
            return Optional.empty();
        } else {
            SecurityCompact[] securityResults = new SecurityCompact[data.length()];
            for (int i = 0; i < data.length(); i++) {
                JSONObject securityJSON = data.getJSONObject(i);
                String ticker = securityJSON.has("ticker") && !securityJSON.isNull("ticker") ? securityJSON.getString("ticker") : "";
                String figi_ticker = securityJSON.has("figi_ticker") && !securityJSON.isNull("figi_ticker") ? securityJSON.getString("figi_ticker") : "";
                String figi = securityJSON.has("figi") && !securityJSON.isNull("figi") ? securityJSON.getString("figi") : "";
                String security_name = securityJSON.has("security_name") && !securityJSON.isNull("security_name") ? securityJSON.getString("security_name") : "";
                String market_sector = securityJSON.has("market_sector") && !securityJSON.isNull("market_sector") ? securityJSON.getString("market_sector") : "";
                String security_type = securityJSON.has("security_type") && !securityJSON.isNull("security_type") ? securityJSON.getString("security_type") : "";
                String stock_exchange = securityJSON.has("stock_exchange") && !securityJSON.isNull("stock_exchange") ? securityJSON.getString("stock_exchange") : "";
                String last_crsp_adj_date = securityJSON.has("last_crsp_adj_date") && !securityJSON.isNull("last_crsp_adj_date") ? securityJSON.getString("last_crsp_adj_date") : "";
                securityResults[i] = new SecurityCompact(ticker, figi_ticker, figi, security_name, market_sector, security_type, stock_exchange, last_crsp_adj_date);
            }
            return Optional.of(securityResults);
        }
    }

    /**
     * This method will hit the https://api.intrinio.com/securities endpoint and return all data
     * associated with the security with the given identifier.
     *
     * @param identifier The stock symbol associated with the security
     * @return Empty optional if no security found, or a Security object containing all related information.
     */
    public Optional<Security> getSecurityInformation(String identifier) {
        try {
            String escapedIdentifier = URLEncoder.encode(identifier, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.SECURITIES_URL + "?identifier=" + escapedIdentifier));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject securityJSON = new JSONObject(responseBody);
            return buildSecurityFromJSON(securityJSON);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Security> buildSecurityFromJSON(JSONObject security) {
        return Optional.of(
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


    public Optional<Price[]> getPricesByIdentifier(String identifier) {
        try {
            String escapedIdentifier = URLEncoder.encode(identifier, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.PRICES_URL + "?identifier=" + escapedIdentifier));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject priceJSON = new JSONObject(responseBody);
            return buildPricesFromJSON(priceJSON);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Price[]> getPricesByIdentifier(String identifier, String start_date) {
        try {
            String escapedIdentifier = URLEncoder.encode(identifier, "UTF-8");
            start_date = URLEncoder.encode(start_date, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.PRICES_URL + "?identifier=" + escapedIdentifier + "&start_date=" + start_date));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject priceJSON = new JSONObject(responseBody);
            return buildPricesFromJSON(priceJSON);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Price[]> getPricesByIdentifier(String identifier, String start_date, String end_date) {
        try {
            String escapedIdentifier = URLEncoder.encode(identifier, "UTF-8");
            start_date = URLEncoder.encode(start_date, "UTF-8");
            end_date = URLEncoder.encode(end_date, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.PRICES_URL + "?identifier=" + escapedIdentifier + "&start_date=" + start_date + "&end_date=" + end_date));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject priceJSON = new JSONObject(responseBody);
            return buildPricesFromJSON(priceJSON);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Price[]> getPricesByIdentifier(String identifier, String start_date, String end_date, String frequency) {
        try {
            String escapedIdentifier = URLEncoder.encode(identifier, "UTF-8");
            start_date = URLEncoder.encode(start_date, "UTF-8");
            end_date = URLEncoder.encode(end_date, "UTF-8");
            frequency = URLEncoder.encode(frequency, "UTF-8");
            HttpResponse response = this.client.execute(new HttpGet(this.PRICES_URL + "?identifier=" + escapedIdentifier + "&start_date=" + start_date + "&end_date=" + end_date + "&frequency=" + frequency));
            String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (responseBody.isEmpty() || response.getStatusLine().getStatusCode() != 200) {
                return Optional.empty();
            }
            JSONObject priceJSON = new JSONObject(responseBody);
            return buildPricesFromJSON(priceJSON);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Price[]> buildPricesFromJSON(JSONObject json) {
        if (json.length() == 0 && (!json.has("data") || json.getJSONArray("data").length() == 0)) {
            return Optional.empty();
        } else {
            JSONArray pricesJSON = json.getJSONArray("data");
            Price[] prices = new Price[pricesJSON.length()];
            for (int i = 0; i < pricesJSON.length(); i++) {
                JSONObject price = pricesJSON.getJSONObject(i);
                String date = price.has("date") && !price.isNull("date") ? price.getString("date") : "";
                double open = price.has("open") && !price.isNull("open") ? price.getDouble("open") : 0;
                double high = price.has("high") && !price.isNull("high") ? price.getDouble("high") : 0;
                double low = price.has("low") && !price.isNull("low") ? price.getDouble("low") : 0;
                double close = price.has("close") && !price.isNull("close") ? price.getDouble("close") : 0;
                double volume = price.has("volume") && !price.isNull("volume") ? price.getDouble("volume") : 0;
                double ex_dividend = price.has("ex_dividend") && !price.isNull("ex_dividend") ? price.getDouble("ex_dividend") : 0;
                double split_ratio = price.has("split_ratio") && !price.isNull("split_ratio") ? price.getDouble("split_ratio") : 0;
                double adj_open = price.has("adj_open") && !price.isNull("adj_open") ? price.getDouble("adj_open") : 0;
                double adj_high = price.has("adj_high") && !price.isNull("adj_high") ? price.getDouble("adj_high") : 0;
                double adj_low = price.has("adj_low") && !price.isNull("adj_low") ? price.getDouble("adj_low") : 0;
                double adj_close = price.has("adj_close") && !price.isNull("adj_close") ? price.getDouble("adj_close") : 0;
                double adj_volume = price.has("adj_volume") && !price.isNull("adj_volume") ? price.getDouble("adj_volume") : 0;
                prices[i] = new Price(date, open, high, low, close, volume, ex_dividend, split_ratio, adj_open, adj_high, adj_low, adj_close, adj_volume);
            }
            return Optional.of(prices);
        }
    }
}
