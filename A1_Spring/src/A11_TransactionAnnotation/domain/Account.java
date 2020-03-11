package A11_TransactionAnnotation.domain;

public class Account {
    private int accountId;
    private String name;
    private double money;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
