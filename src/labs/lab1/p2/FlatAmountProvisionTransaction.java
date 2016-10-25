package labs.lab1.p2;

class FlatAmountProvisionTransaction extends Transaction {
    private String flatProvision;

    FlatAmountProvisionTransaction(String fromId, String toId, String amount, String flatProvision) {
        super(fromId, toId, "FlatAmount", amount);
        this.flatProvision = flatProvision;
    }
    FlatAmountProvisionTransaction() {
        super("0", "0", "FlatAmount", "0$");
        this.flatProvision = "0";
    }

    public double getDFlatProvision() {
        return Double.parseDouble(this.flatProvision.substring(0,this.flatProvision.length()-1));
    }

    public String getFlatProvision() {
        return String.format("%.2f",getDFlatProvision()) + "$";
    }

    @Override
    public double getProvision() {
        return getDFlatProvision();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlatAmountProvisionTransaction)) return false;
        if (!super.equals(o)) return false;

        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;

        return flatProvision != null ? flatProvision.equals(that.flatProvision) : that.flatProvision == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (flatProvision != null ? flatProvision.hashCode() : 0);
        return result;
    }
}
