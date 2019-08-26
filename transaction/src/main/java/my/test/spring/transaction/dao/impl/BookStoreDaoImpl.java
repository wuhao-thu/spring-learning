package my.test.spring.transaction.dao.impl;

import my.test.spring.transaction.dao.BookStoreDao;
import my.test.spring.transaction.exception.BookStockException;
import my.test.spring.transaction.exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookStoreDao")
public class BookStoreDaoImpl implements BookStoreDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Double getBookPriceByISBN(String isbn) throws EmptyResultDataAccessException {
        String sql = "SELECT price FROM book WHERE isbn = ? ";
        return jdbcTemplate.queryForObject(sql, Double.class, isbn);
    }

    @Override
    public String getBookNameByISBN(String isbn) throws EmptyResultDataAccessException {
        String sql = "SELECT book_name FROM book WHERE isbn = ? ";
        return jdbcTemplate.queryForObject(sql, String.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) throws EmptyResultDataAccessException {
        //若书的库存不足则抛出异常
        if(getBookStock(isbn) == 0) {
            throw new BookStockException("库存不足！");
        }
        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public Integer getBookStock(String isbn) throws EmptyResultDataAccessException {
        String sql = "SELECT stock FROM book_stock WHERE isbn = ? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateUserAccount(String username, Double price) throws EmptyResultDataAccessException {
        if(getUserBalance(username) < price) {
            throw new UserAccountException("账户余额不足！");
        }
        String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql, price, username);
    }

    @Override
    public Double getUserBalance(String username) throws EmptyResultDataAccessException {
        String sql = "SELECT balance FROM account WHERE username = ? ";
        return jdbcTemplate.queryForObject(sql, Double.class, username);
    }
}
