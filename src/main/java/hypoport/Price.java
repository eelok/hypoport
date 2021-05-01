package hypoport;

public class Price {

    private long date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;

    private Double volume;
    private Double adjclose;

    public Price() {
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAdjclose() {
        return adjclose;
    }

    public void setAdjclose(Double adjclose) {
        this.adjclose = adjclose;
    }
}
