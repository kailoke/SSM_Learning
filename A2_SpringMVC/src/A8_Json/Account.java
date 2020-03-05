package A8_Json;

public class Account {
    private int accountId;
    private double money;

    public Account() {
    }

    public Account(int accountId, double money) {
        this.accountId = accountId;
        this.money = money;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", money=" + money +
                '}';
    }
}
