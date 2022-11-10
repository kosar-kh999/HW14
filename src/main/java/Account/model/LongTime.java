package Account.model;

public class LongTime extends Account {
    public void longTime() {
        if (getBalance() < 1000000) {
            throw new RuntimeException("this is not enough for long time account");
        } else System.out.println(AccountType.LONG_TIME);
    }
}
