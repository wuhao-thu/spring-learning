package my.test.spring.hibernate.dao;

import my.test.spring.hibernate.entities.Account;

public interface AccountDao {

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    void deleteAccount(String username);

    Account getAccountById(Integer id);

    Account getAccountByUsername(String username);
}
