package domain;

/**
 * Created on 2/7/17.
 */
public class Price {
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double ex_dividend;
    private double split_ratio;
    private double adj_open;
    private double adj_high;
    private double adj_low;
    private double adj_close;
    private double adj_volume;

    public Price(String date, double open, double high, double low, double close, double volume, double ex_dividend, double split_ratio, double adj_open, double adj_high, double adj_low, double adj_close, double adj_volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.ex_dividend = ex_dividend;
        this.split_ratio = split_ratio;
        this.adj_open = adj_open;
        this.adj_high = adj_high;
        this.adj_low = adj_low;
        this.adj_close = adj_close;
        this.adj_volume = adj_volume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getEx_dividend() {
        return ex_dividend;
    }

    public void setEx_dividend(double ex_dividend) {
        this.ex_dividend = ex_dividend;
    }

    public double getSplit_ratio() {
        return split_ratio;
    }

    public void setSplit_ratio(double split_ratio) {
        this.split_ratio = split_ratio;
    }

    public double getAdj_open() {
        return adj_open;
    }

    public void setAdj_open(double adj_open) {
        this.adj_open = adj_open;
    }

    public double getAdj_high() {
        return adj_high;
    }

    public void setAdj_high(double adj_high) {
        this.adj_high = adj_high;
    }

    public double getAdj_low() {
        return adj_low;
    }

    public void setAdj_low(double adj_low) {
        this.adj_low = adj_low;
    }

    public double getAdj_close() {
        return adj_close;
    }

    public void setAdj_close(double adj_close) {
        this.adj_close = adj_close;
    }

    public double getAdj_volume() {
        return adj_volume;
    }

    public void setAdj_volume(double adj_volume) {
        this.adj_volume = adj_volume;
    }

    @Override
    public String toString() {
        return "Price{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", ex_dividend=" + ex_dividend +
                ", split_ratio=" + split_ratio +
                ", adj_open=" + adj_open +
                ", adj_high=" + adj_high +
                ", adj_low=" + adj_low +
                ", adj_close=" + adj_close +
                ", adj_volume=" + adj_volume +
                '}';
    }
}
