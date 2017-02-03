package domain;

public class CompanyBuilder {
    private String buildertemplate;
    private String buildershort_description;
    private String builderindustry_category;
    private String buildercik;
    private String builderstock_exchange;
    private String builderbusiness_address;
    private int buildersic;
    private String builderceo;
    private String builderinc_country;
    private Security[] buildersecurities;
    private String builderlei;
    private String builderhq_country;
    private String buildercompany_url;
    private String builderhq_state;
    private String builderindustry_group;
    private String builderlegal_name;
    private String buildersector;
    private String builderhq_address2;
    private String builderticker;
    private String builderhq_address1;
    private String builderlong_description;
    private String builderhq_address_city;
    private String buildermailing_address;
    private String builderinc_state;
    private boolean builderstandardized_active;
    private String builderentity_legal_form;
    private String buildername;
    private String builderhq_address_postal_code;
    private String builderentity_status;
    private int builderemployees;
    private String builderbusiness_phone_no;

    public CompanyBuilder template(String template) {
        this.buildertemplate = template;
        return this;
    }

    public CompanyBuilder short_description(String short_description) {
        this.buildershort_description = short_description;
        return this;
    }

    public CompanyBuilder industry_category(String industry_category) {
        this.builderindustry_category = industry_category;
        return this;
    }

    public CompanyBuilder cik(String cik) {
        this.buildercik = cik;
        return this;
    }

    public CompanyBuilder stock_exchange(String stock_exchange) {
        this.builderstock_exchange = stock_exchange;
        return this;
    }

    public CompanyBuilder business_address(String business_address) {
        this.builderbusiness_address = business_address;
        return this;
    }

    public CompanyBuilder sic(int sic) {
        this.buildersic = sic;
        return this;
    }

    public CompanyBuilder ceo(String ceo) {
        this.builderceo = ceo;
        return this;
    }

    public CompanyBuilder inc_country(String inc_country) {
        this.builderinc_country = inc_country;
        return this;
    }

    public CompanyBuilder securities(Security[] securities) {
        this.buildersecurities = securities;
        return this;
    }

    public CompanyBuilder lei(String lei) {
        this.builderlei = lei;
        return this;
    }

    public CompanyBuilder hq_country(String hq_country) {
        this.builderhq_country = hq_country;
        return this;
    }

    public CompanyBuilder company_url(String company_url) {
        this.buildercompany_url = company_url;
        return this;
    }

    public CompanyBuilder hq_state(String hq_state) {
        this.builderhq_state = hq_state;
        return this;
    }

    public CompanyBuilder industry_group(String industry_group) {
        this.builderindustry_group = industry_group;
        return this;
    }

    public CompanyBuilder legal_name(String legal_name) {
        this.builderlegal_name = legal_name;
        return this;
    }

    public CompanyBuilder sector(String sector) {
        this.buildersector = sector;
        return this;
    }

    public CompanyBuilder hq_address2(String hq_address2) {
        this.builderhq_address2 = hq_address2;
        return this;
    }

    public CompanyBuilder ticker(String ticker) {
        this.builderticker = ticker;
        return this;
    }

    public CompanyBuilder hq_address1(String hq_address1) {
        this.builderhq_address1 = hq_address1;
        return this;
    }

    public CompanyBuilder long_description(String long_description) {
        this.builderlong_description = long_description;
        return this;
    }

    public CompanyBuilder hq_address_city(String hq_address_city) {
        this.builderhq_address_city = hq_address_city;
        return this;
    }

    public CompanyBuilder mailing_address(String mailing_address) {
        this.buildermailing_address = mailing_address;
        return this;
    }

    public CompanyBuilder inc_state(String inc_state) {
        this.builderinc_state = inc_state;
        return this;
    }

    public CompanyBuilder standardized_active(boolean standardized_active) {
        this.builderstandardized_active = standardized_active;
        return this;
    }

    public CompanyBuilder entity_legal_form(String entity_legal_form) {
        this.builderentity_legal_form = entity_legal_form;
        return this;
    }

    public CompanyBuilder name(String name) {
        this.buildername = name;
        return this;
    }

    public CompanyBuilder hq_address_postal_code(String hq_address_postal_code) {
        this.builderhq_address_postal_code = hq_address_postal_code;
        return this;
    }

    public CompanyBuilder entity_status(String entity_status) {
        this.builderentity_status = entity_status;
        return this;
    }

    public CompanyBuilder employees(int employees) {
        this.builderemployees = employees;
        return this;
    }

    public CompanyBuilder business_phone_no(String business_phone_no) {
        this.builderbusiness_phone_no = business_phone_no;
        return this;
    }

    public Company build(){
        return new Company(
        this.buildertemplate,
        this.buildershort_description,
        this.builderindustry_category,
        this.buildercik,
        this.builderstock_exchange,
        this.builderbusiness_address,
        this.buildersic,
        this.builderceo,
        this.builderinc_country,
        this.buildersecurities,
        this.builderlei,
        this.builderhq_country,
        this.buildercompany_url,
        this.builderhq_state,
        this.builderindustry_group,
        this.builderlegal_name,
        this.buildersector,
        this.builderhq_address2,
        this.builderticker,
        this.builderhq_address1,
        this.builderlong_description,
        this.builderhq_address_city,
        this.buildermailing_address,
        this.builderinc_state,
        this.builderstandardized_active,
        this.builderentity_legal_form,
        this.buildername,
        this.builderhq_address_postal_code,
        this.builderentity_status,
        this.builderemployees,
        this.builderbusiness_phone_no
        );
    }
}
