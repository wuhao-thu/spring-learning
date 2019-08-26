package my.test.spring.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name="HB_ACCOUNT")
public class Account {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="username")
    private String username;
    @Column(name="balance")
    private Double balance;

    public Account() {
    }

    public Account(Integer id, String username, Double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
