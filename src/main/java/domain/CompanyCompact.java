package domain;

/**
 * Created by Bruce on 2/4/2017.
 */
public class CompanyCompact {
    		private String ticker;
            private String name;
            private String lei;
            private String cik;

    public CompanyCompact(String ticker, String name, String lei, String cik) {
        this.ticker = ticker;
        this.name = name;
        this.lei = lei;
        this.cik = cik;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getCik() {
        return cik;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    @Override
    public String toString() {
        return "CompanyCompact{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", lei='" + lei + '\'' +
                ", cik='" + cik + '\'' +
                '}';
    }
}
