package labs.lab1.p2;

abstract class Transaction {
    //private long fromId;
    //private long toId;
    private String fromId;
    private String toId;
    private String description;
    private String amount;

    Transaction(String fromId, String toId, String description, String amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.description = description;
        this.amount = amount;
    }

    Transaction() {
        this("0", "0", "Unknown", "0$");
    }

    public String getFromId() {
        return fromId;
    }

    public String getToId() {
        return toId;
    }

    public double getDAmount() {
        return Double.parseDouble(this.amount.substring(0,this.amount.length()-1));
    }

    public String getAmount() {
        return String.format("%.02f", getDAmount()) + "$";
    }


    public String getDescription() {
        return description;
    }

    public abstract double getProvision();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (fromId != null ? !fromId.equals(that.fromId) : that.fromId != null) return false;
        if (toId != null ? !toId.equals(that.toId) : that.toId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;

    }

    @Override
    public int hashCode() {
        int result = fromId != null ? fromId.hashCode() : 0;
        result = 31 * result + (toId != null ? toId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
