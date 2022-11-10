package Account.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "accountNumber")
    String accountNumber;
    @Column(name = "cardNumber", length = 16)
    String cardNumber;
    @Column(name = "openingDate")
    @Temporal(TemporalType.DATE)
    Date openingDate;
    @Column(name = "balance")
    double balance;
    @Column(name = "cvv2")
    int cvv2;
    @Column(name = "expirationDate")
    @Temporal(TemporalType.DATE)
    Date expirationDate;
    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    AccountType accountType;

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");

        }

        if (amount > balance) {
            throw new RuntimeException("Your balance is not enough");
        }

        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }


}
