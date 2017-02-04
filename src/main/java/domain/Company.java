package domain;

import java.util.Arrays;

/**
 * Created on 2/3/17.
 */
public class Company {
    public String template;
    public String short_description;
    public String industry_category;
    public String cik;
    public String stock_exchange;
    public String business_address;
    public int sic;
    public String ceo;
    public String inc_country;
    public Security[] securities;
    public String lei;
    public String hq_country;
    public String company_url;
    public String hq_state;
    public String industry_group;
    public String legal_name;
    public String sector;
    public String hq_address2;
    public String ticker;
    public String hq_address1;
    public String long_description;
    public String hq_address_city;
    public String mailing_address;
    public String inc_state;
    public boolean standardized_active;
    public String entity_legal_form;
    public String name;
    public String hq_address_postal_code;
    public String entity_status;
    public int employees;
    public String business_phone_no;

    public Company(){

    }

    public Company(String template, String short_description, String industry_category, String cik, String stock_exchange, String business_address, int sic, String ceo, String inc_country, Security[] securities, String lei, String hq_country, String company_url, String hq_state, String industry_group, String legal_name, String sector, String hq_address2, String ticker, String hq_address1, String long_description, String hq_address_city, String mailing_address, String inc_state, boolean standardized_active, String entity_legal_form, String name, String hq_address_postal_code, String entity_status, int employees, String business_phone_no) {
        this.template = template;
        this.short_description = short_description;
        this.industry_category = industry_category;
        this.cik = cik;
        this.stock_exchange = stock_exchange;
        this.business_address = business_address;
        this.sic = sic;
        this.ceo = ceo;
        this.inc_country = inc_country;
        this.securities = securities;
        this.lei = lei;
        this.hq_country = hq_country;
        this.company_url = company_url;
        this.hq_state = hq_state;
        this.industry_group = industry_group;
        this.legal_name = legal_name;
        this.sector = sector;
        this.hq_address2 = hq_address2;
        this.ticker = ticker;
        this.hq_address1 = hq_address1;
        this.long_description = long_description;
        this.hq_address_city = hq_address_city;
        this.mailing_address = mailing_address;
        this.inc_state = inc_state;
        this.standardized_active = standardized_active;
        this.entity_legal_form = entity_legal_form;
        this.name = name;
        this.hq_address_postal_code = hq_address_postal_code;
        this.entity_status = entity_status;
        this.employees = employees;
        this.business_phone_no = business_phone_no;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getIndustry_category() {
        return industry_category;
    }

    public void setIndustry_category(String industry_category) {
        this.industry_category = industry_category;
    }

    public String getCik() {
        return cik;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    public String getStock_exchange() {
        return stock_exchange;
    }

    public void setStock_exchange(String stock_exchange) {
        this.stock_exchange = stock_exchange;
    }

    public String getBusiness_address() {
        return business_address;
    }

    public void setBusiness_address(String business_address) {
        this.business_address = business_address;
    }

    public int getSic() {
        return sic;
    }

    public void setSic(int sic) {
        this.sic = sic;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getInc_country() {
        return inc_country;
    }

    public void setInc_country(String inc_country) {
        this.inc_country = inc_country;
    }

    public Security[] getSecurities() {
        return securities;
    }

    public void setSecurities(Security[] securities) {
        this.securities = securities;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getHq_country() {
        return hq_country;
    }

    public void setHq_country(String hq_country) {
        this.hq_country = hq_country;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public String getHq_state() {
        return hq_state;
    }

    public void setHq_state(String hq_state) {
        this.hq_state = hq_state;
    }

    public String getIndustry_group() {
        return industry_group;
    }

    public void setIndustry_group(String industry_group) {
        this.industry_group = industry_group;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getHq_address2() {
        return hq_address2;
    }

    public void setHq_address2(String hq_address2) {
        this.hq_address2 = hq_address2;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getHq_address1() {
        return hq_address1;
    }

    public void setHq_address1(String hq_address1) {
        this.hq_address1 = hq_address1;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getHq_address_city() {
        return hq_address_city;
    }

    public void setHq_address_city(String hq_address_city) {
        this.hq_address_city = hq_address_city;
    }

    public String getMailing_address() {
        return mailing_address;
    }

    public void setMailing_address(String mailing_address) {
        this.mailing_address = mailing_address;
    }

    public String getInc_state() {
        return inc_state;
    }

    public void setInc_state(String inc_state) {
        this.inc_state = inc_state;
    }

    public boolean isStandardized_active() {
        return standardized_active;
    }

    public void setStandardized_active(boolean standardized_active) {
        this.standardized_active = standardized_active;
    }

    public String getEntity_legal_form() {
        return entity_legal_form;
    }

    public void setEntity_legal_form(String entity_legal_form) {
        this.entity_legal_form = entity_legal_form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHq_address_postal_code() {
        return hq_address_postal_code;
    }

    public void setHq_address_postal_code(String hq_address_postal_code) {
        this.hq_address_postal_code = hq_address_postal_code;
    }

    public String getEntity_status() {
        return entity_status;
    }

    public void setEntity_status(String entity_status) {
        this.entity_status = entity_status;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public String getBusiness_phone_no() {
        return business_phone_no;
    }

    public void setBusiness_phone_no(String business_phone_no) {
        this.business_phone_no = business_phone_no;
    }

    @Override
    public String toString() {
        return "Company{" +
                "template='" + template + '\'' +
                ", short_description='" + short_description + '\'' +
                ", industry_category='" + industry_category + '\'' +
                ", cik='" + cik + '\'' +
                ", stock_exchange='" + stock_exchange + '\'' +
                ", business_address='" + business_address + '\'' +
                ", sic=" + sic +
                ", ceo='" + ceo + '\'' +
                ", inc_country='" + inc_country + '\'' +
                ", securities=" + Arrays.toString(securities) +
                ", lei='" + lei + '\'' +
                ", hq_country='" + hq_country + '\'' +
                ", company_url='" + company_url + '\'' +
                ", hq_state='" + hq_state + '\'' +
                ", industry_group='" + industry_group + '\'' +
                ", legal_name='" + legal_name + '\'' +
                ", sector='" + sector + '\'' +
                ", hq_address2='" + hq_address2 + '\'' +
                ", ticker='" + ticker + '\'' +
                ", hq_address1='" + hq_address1 + '\'' +
                ", long_description='" + long_description + '\'' +
                ", hq_address_city='" + hq_address_city + '\'' +
                ", mailing_address='" + mailing_address + '\'' +
                ", inc_state='" + inc_state + '\'' +
                ", standardized_active=" + standardized_active +
                ", entity_legal_form='" + entity_legal_form + '\'' +
                ", name='" + name + '\'' +
                ", hq_address_postal_code='" + hq_address_postal_code + '\'' +
                ", entity_status='" + entity_status + '\'' +
                ", employees=" + employees +
                ", business_phone_no='" + business_phone_no + '\'' +
                '}';
    }
}


