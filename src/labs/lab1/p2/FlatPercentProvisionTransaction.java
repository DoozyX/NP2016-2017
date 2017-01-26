package labs.lab1.p2;

class FlatPercentProvisionTransaction extends Transaction {
	private int percent;

	FlatPercentProvisionTransaction(String fromId, String toId, String amount, int centsPerDolar) {
		super(fromId, toId, "FlatPercent", amount);
		this.percent = centsPerDolar;
	}

	FlatPercentProvisionTransaction() {
		super("0", "0", "FlatPercent", "0$");
		this.percent = 0;
	}

	public int getPercent() {
		return percent;
	}

	@Override
	public double getProvision() {
		return ((int) this.getDAmount()) * getPercent() / 100.0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FlatPercentProvisionTransaction)) return false;
		if (!super.equals(o)) return false;

		FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;

		return percent == that.percent;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + percent;
		return result;
	}
}
