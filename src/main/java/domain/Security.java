package domain;

/**
 * Created on 2/3/17.
 */
public class Security {
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

    public Security(String share_class_figi, String ticker, String stock_exchange, String mic, String figi_exch_cntry, boolean primary_listing, String figi, String figi_uniqueid, boolean delisted_security, String security_name, String last_crsp_adj_date, String composite_figi, boolean etf, String currency, String exch_symbol, String security_type, String figi_ticker, String market_sector) {
        this.share_class_figi = share_class_figi;
        this.ticker = ticker;
        this.stock_exchange = stock_exchange;
        this.mic = mic;
        this.figi_exch_cntry = figi_exch_cntry;
        this.primary_listing = primary_listing;
        this.figi = figi;
        this.figi_uniqueid = figi_uniqueid;
        this.delisted_security = delisted_security;
        this.security_name = security_name;
        this.last_crsp_adj_date = last_crsp_adj_date;
        this.composite_figi = composite_figi;
        this.etf = etf;
        this.currency = currency;
        this.exch_symbol = exch_symbol;
        this.security_type = security_type;
        this.figi_ticker = figi_ticker;
        this.market_sector = market_sector;
    }

    public String getShare_class_figi() {
        return share_class_figi;
    }

    public void setShare_class_figi(String share_class_figi) {
        this.share_class_figi = share_class_figi;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getStock_exchange() {
        return stock_exchange;
    }

    public void setStock_exchange(String stock_exchange) {
        this.stock_exchange = stock_exchange;
    }

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public String getFigi_exch_cntry() {
        return figi_exch_cntry;
    }

    public void setFigi_exch_cntry(String figi_exch_cntry) {
        this.figi_exch_cntry = figi_exch_cntry;
    }

    public boolean isPrimary_listing() {
        return primary_listing;
    }

    public void setPrimary_listing(boolean primary_listing) {
        this.primary_listing = primary_listing;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getFigi_uniqueid() {
        return figi_uniqueid;
    }

    public void setFigi_uniqueid(String figi_uniqueid) {
        this.figi_uniqueid = figi_uniqueid;
    }

    public boolean isDelisted_security() {
        return delisted_security;
    }

    public void setDelisted_security(boolean delisted_security) {
        this.delisted_security = delisted_security;
    }

    public String getSecurity_name() {
        return security_name;
    }

    public void setSecurity_name(String security_name) {
        this.security_name = security_name;
    }

    public String getLast_crsp_adj_date() {
        return last_crsp_adj_date;
    }

    public void setLast_crsp_adj_date(String last_crsp_adj_date) {
        this.last_crsp_adj_date = last_crsp_adj_date;
    }

    public String getComposite_figi() {
        return composite_figi;
    }

    public void setComposite_figi(String composite_figi) {
        this.composite_figi = composite_figi;
    }

    public boolean isEtf() {
        return etf;
    }

    public void setEtf(boolean etf) {
        this.etf = etf;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getExch_symbol() {
        return exch_symbol;
    }

    public void setExch_symbol(String exch_symbol) {
        this.exch_symbol = exch_symbol;
    }

    public String getSecurity_type() {
        return security_type;
    }

    public void setSecurity_type(String security_type) {
        this.security_type = security_type;
    }

    public String getFigi_ticker() {
        return figi_ticker;
    }

    public void setFigi_ticker(String figi_ticker) {
        this.figi_ticker = figi_ticker;
    }

    public String getMarket_sector() {
        return market_sector;
    }

    public void setMarket_sector(String market_sector) {
        this.market_sector = market_sector;
    }
}

