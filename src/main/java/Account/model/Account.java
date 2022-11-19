package Account.model;

import jdk.jfr.Timestamp;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "accountNumber", unique = true)
    String accountNumber;
    @Column(name = "cardNumber", length = 16)
    String cardNumber;
    @Column(name = "openingDate")
    @Timestamp
    LocalDate openingDate;
    @Column(name = "balance")
    double balance;
    @Column(name = "cvv2")
    int cvv2;
    @Column(name = "expirationDate")
    @Timestamp
    LocalDate expirationDate;
    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    AccountType accountType;

    public Account(String accountNumber, String cardNumber, LocalDate openingDate, double balance,
                   LocalDate expirationDate, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.openingDate = openingDate;
        this.balance = balance;
        Random random = new Random();
        this.cvv2 = random.nextInt(100, 9999);
        this.expirationDate = expirationDate;
        this.accountType = accountType;
    }
}
