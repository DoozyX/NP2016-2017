package labs.lab1.p2;


class Account {
    private String name;
    private String id;
    private String balance;
    private static int ID_COUNT = 0;
    //public static final long IDLength = 1_000_000_000_000L; //ID of length 13

    Account(String name, String balance) {
        this.name = name;
        //this.id = (long)((Math.random() * 9 * IDLength) + IDLength);
        this.id = Integer.toString(++ID_COUNT);
        this.balance = balance;
    }

    Account() {
        this("Unknown", "0$");
    }

    Account(Account a) {
        this.name = a.name;
        this.id   = a.id;
        this.balance = a.getBalance();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getDBalance(){
        return Double.parseDouble(this.balance.substring(0,this.balance.length()-1));
    }

    public String getBalance() {
        return String.format("%.2f", getDBalance()) + "$";
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Balance: " + getBalance() + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        return balance != null ? balance.equals(account.balance) : account.balance == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
