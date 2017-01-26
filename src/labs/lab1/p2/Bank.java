package labs.lab1.p2;

import java.util.Arrays;

class Bank {
	private String name;
	private Account accounts[];
	private String totalTransfers;
	private String totalProvision;

	Bank(String name, Account[] accounts) {
		this.name = name;
		this.accounts = new Account[accounts.length];
		this.accounts = Arrays.copyOf(accounts, accounts.length);
		totalProvision = "0$";
		totalTransfers = "0$";

	}

	public Bank() {
		this("Unknown", null);
	}

	public boolean makeTransaction(Transaction t) {
		Account a1 = null;
		Account a2 = null;
		for (int i = 0; i < accounts.length; ++i) {
			if (accounts[i].getId().equals(t.getFromId())) {
				a1 = accounts[i];
			}
			if (accounts[i].getId().equals(t.getToId())) {
				a2 = accounts[i];
			}
		}
		if (a1 == null || a2 == null) return false;
		double a1Balance = a1.getDBalance();
		double a2Balance = a2.getDBalance();
		double tAmount = t.getDAmount();
		if (a1Balance >= tAmount) {
			double tProvison = t.getProvision();
			double totalProvisionT = totalDProvision();
			totalProvisionT += tProvison;
			this.totalProvision = totalProvisionT + "$";
			double totalTransfersT = totalDTransfers();
			totalTransfersT += tAmount;
			this.totalTransfers = totalTransfersT + "$";
			if (a1 == a2 || a1.equals(a2)) {
				a1Balance -= tProvison;
				a1.setBalance(a1Balance + "$");
			} else {
				a1Balance -= (tAmount + tProvison);
				a2Balance += tAmount;
				a1.setBalance(a1Balance + "$");

				a2.setBalance(a2Balance + "$");
			}
			return true;
		}
		return false;
	}

	public double totalDTransfers() {
		return Double.parseDouble(this.totalTransfers.substring(0, this.totalTransfers.length() - 1));
	}

	public String totalTransfers() {
		return String.format("%.2f", totalDTransfers()) + "$";
	}

	public double totalDProvision() {
		return Double.parseDouble(this.totalProvision.substring(0, this.totalProvision.length() - 1));
	}

	public String totalProvision() {
		return String.format("%.2f", totalDProvision()) + "$";
	}


	public Account[] getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		String pBank = "";
		pBank += "Name: " + name + '\n' + '\n';
		for (int i = 0; i < accounts.length; i++) {
			pBank += accounts[i].toString();
		}
		return pBank;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Bank)) return false;

		Bank bank = (Bank) o;

		if (name != null ? !name.equals(bank.name) : bank.name != null) return false;
		if (bank.accounts.length != accounts.length) return false;
		for (int i = 0; i < accounts.length; ++i) {
			if (!accounts[i].equals(bank.accounts[i])) {
				return false;
			}
		}
		if (!Arrays.equals(accounts, bank.accounts)) return false;
		if (totalTransfers != null ? !totalTransfers.equals(bank.totalTransfers) : bank.totalTransfers != null)
			return false;
		return totalProvision != null ? totalProvision.equals(bank.totalProvision) : bank.totalProvision == null;

	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + Arrays.hashCode(accounts);
		result = 31 * result + (totalTransfers != null ? totalTransfers.hashCode() : 0);
		result = 31 * result + (totalProvision != null ? totalProvision.hashCode() : 0);
		return result;
	}
}
