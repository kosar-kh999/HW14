package Account.model;

public class Current extends Account {
    public void current() {
        if (getBalance() < 50000) {
            throw new RuntimeException("This is not enough for current account");
        } else System.out.println(AccountType.CURRENT);
    }
}
