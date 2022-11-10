package Account.model;

public class Loans extends Account {
    public void loans() {
        if (getBalance() < 100000) {
            throw new RuntimeException("This is not enough for loans account");
        } else {
            System.out.println(AccountType.LOANS);
        }
    }
}
