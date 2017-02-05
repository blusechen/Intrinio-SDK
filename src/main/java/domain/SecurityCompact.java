package domain;

/**
 * Created by Bruce on 2/4/2017.
 */
public class SecurityCompact {
    private String ticker;
    private String figi_ticker;
    private String figi;
    private String security_name;
    private String market_sector;
    private String security_type;
    private String stock_exchange;
    private String last_crsp_adj_date;

    public SecurityCompact(String ticker, String figi_ticker, String figi, String security_name, String market_sector, String security_type, String stock_exchange, String last_crsp_adj_date) {
        this.ticker = ticker;
        this.figi_ticker = figi_ticker;
        this.figi = figi;
        this.security_name = security_name;
        this.market_sector = market_sector;
        this.security_type = security_type;
        this.stock_exchange = stock_exchange;
        this.last_crsp_adj_date = last_crsp_adj_date;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getFigi_ticker() {
        return figi_ticker;
    }

    public void setFigi_ticker(String figi_ticker) {
        this.figi_ticker = figi_ticker;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getSecurity_name() {
        return security_name;
    }

    public void setSecurity_name(String security_name) {
        this.security_name = security_name;
    }

    public String getMarket_sector() {
        return market_sector;
    }

    public void setMarket_sector(String market_sector) {
        this.market_sector = market_sector;
    }

    public String getSecurity_type() {
        return security_type;
    }

    public void setSecurity_type(String security_type) {
        this.security_type = security_type;
    }

    public String getStock_exchange() {
        return stock_exchange;
    }

    public void setStock_exchange(String stock_exchange) {
        this.stock_exchange = stock_exchange;
    }

    public String getLast_crsp_adj_date() {
        return last_crsp_adj_date;
    }

    public void setLast_crsp_adj_date(String last_crsp_adj_date) {
        this.last_crsp_adj_date = last_crsp_adj_date;
    }

    @Override
    public String toString() {
        return "SecurityCompact{" +
                "ticker='" + ticker + '\'' +
                ", figi_ticker='" + figi_ticker + '\'' +
                ", figi='" + figi + '\'' +
                ", security_name='" + security_name + '\'' +
                ", market_sector='" + market_sector + '\'' +
                ", security_type='" + security_type + '\'' +
                ", stock_exchange='" + stock_exchange + '\'' +
                ", last_crsp_adj_date='" + last_crsp_adj_date + '\'' +
                '}';
    }
}
