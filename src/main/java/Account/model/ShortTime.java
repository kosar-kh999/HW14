package Account.model;

public class ShortTime extends Account {
    public void shortTime() {
        if (getBalance() < 20000) {
            throw new RuntimeException("this is not enough for short time account");
        } else System.out.println(AccountType.SHORT_TIME);
    }
}
