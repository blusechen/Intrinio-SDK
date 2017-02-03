package domain;

public class SecurityBuilder {
    private String share_class_figi;
    private String ticker;
    private String stock_exchange;
    private String mic;
    private String figi_exch_cntry;
    private boolean primary_listing;
    private String figi;
    private String figi_uniqueid;
    private boolean delisted_security;
    private String security_name;
    private String last_crsp_adj_date;
    private String composite_figi;
    private boolean etf;
    private String currency;
    private String exch_symbol;
    private String security_type;
    private String figi_ticker;
    private String market_sector;

    public SecurityBuilder Share_class_figi(String share_class_figi) {
        this.share_class_figi = share_class_figi;
        return this;
    }

    public SecurityBuilder Ticker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public SecurityBuilder Stock_exchange(String stock_exchange) {
        this.stock_exchange = stock_exchange;
        return this;
    }

    public SecurityBuilder Mic(String mic) {
        this.mic = mic;
        return this;
    }

    public SecurityBuilder Figi_exch_cntry(String figi_exch_cntry) {
        this.figi_exch_cntry = figi_exch_cntry;
        return this;
    }

    public SecurityBuilder Primary_listing(boolean primary_listing) {
        this.primary_listing = primary_listing;
        return this;
    }

    public SecurityBuilder Figi(String figi) {
        this.figi = figi;
        return this;
    }

    public SecurityBuilder Figi_uniqueid(String figi_uniqueid) {
        this.figi_uniqueid = figi_uniqueid;
        return this;
    }

    public SecurityBuilder Delisted_security(boolean delisted_security) {
        this.delisted_security = delisted_security;
        return this;
    }

    public SecurityBuilder Security_name(String security_name) {
        this.security_name = security_name;
        return this;
    }

    public SecurityBuilder Last_crsp_adj_date(String last_crsp_adj_date) {
        this.last_crsp_adj_date = last_crsp_adj_date;
        return this;
    }

    public SecurityBuilder Composite_figi(String composite_figi) {
        this.composite_figi = composite_figi;
        return this;
    }

    public SecurityBuilder Etf(boolean etf) {
        this.etf = etf;
        return this;
    }

    public SecurityBuilder Currency(String currency) {
        this.currency = currency;
        return this;
    }

    public SecurityBuilder Exch_symbol(String exch_symbol) {
        this.exch_symbol = exch_symbol;
        return this;
    }

    public SecurityBuilder Security_type(String security_type) {
        this.security_type = security_type;
        return this;
    }

    public SecurityBuilder Figi_ticker(String figi_ticker) {
        this.figi_ticker = figi_ticker;
        return this;
    }

    public SecurityBuilder Market_sector(String market_sector) {
        this.market_sector = market_sector;
        return this;
    }

    public Security build(){
        return new Security(
        this.share_class_figi,
        this.ticker,
        this.stock_exchange,
        this.mic,
        this.figi_exch_cntry,
        this.primary_listing,
        this.figi,
        this.figi_uniqueid,
        this.delisted_security,
        this.security_name,
        this.last_crsp_adj_date,
        this.composite_figi,
        this.etf,
        this.currency,
        this.exch_symbol,
        this.security_type,
        this.figi_ticker,
        this.market_sector
        );
    }
}
