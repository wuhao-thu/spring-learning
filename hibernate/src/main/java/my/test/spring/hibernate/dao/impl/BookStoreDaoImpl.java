package my.test.spring.hibernate.dao.impl;

import my.test.spring.hibernate.dao.AccountDao;
import my.test.spring.hibernate.dao.BookDao;
import my.test.spring.hibernate.dao.BookStoreDao;
import my.test.spring.hibernate.entities.Account;
import my.test.spring.hibernate.entities.Book;
import my.test.spring.hibernate.exception.BookStockException;
import my.test.spring.hibernate.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookStoreDao")
public class BookStoreDaoImpl implements BookStoreDao {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public Double getBookPriceByISBN(String isbn) {
        return bookDao.getBookByISBN(isbn).getPrice();
    }

    @Override
    public String getBookNameByISBN(String isbn) {
        return bookDao.getBookByISBN(isbn).getBookName();
    }

    @Override
    public void updateBookStock(String isbn) {
        Book book = bookDao.getBookByISBN(isbn);
        if(book.getStock() == 0) {
            throw new BookStockException("库存不足！");
        }
        book.setStock(book.getStock() - 1);
        bookDao.updateBook(book);
    }

    @Override
    public Integer getBookStock(String isbn) {
        return bookDao.getBookByISBN(isbn).getStock();
    }

    @Override
    public void updateUserAccount(String username, Double price) {
        Account account = accountDao.getAccountByUsername(username);
        if(account.getBalance() < price) {
            throw new UserAccountException("账户余额不足！");
        }
        account.setBalance(account.getBalance() - price);
        accountDao.updateAccount(account);
    }

    @Override
    public Double getUserBalance(String username) {
        return accountDao.getAccountByUsername(username).getBalance();
    }
}
