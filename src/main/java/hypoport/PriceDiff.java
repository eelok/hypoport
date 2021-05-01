package hypoport;

public class PriceDiff {

    private Double openCloseDiff;
    private long date;

    public PriceDiff(long date, double openCloseDiff) {
        this.date = date;
        this.openCloseDiff = openCloseDiff;
    }

    public Double getOpenCloseDiff() {
        return openCloseDiff;
    }

    public void setOpenCloseDiff(Double openCloseDiff) {
        this.openCloseDiff = openCloseDiff;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

}
