package my.test.spring.hibernate;

import my.test.spring.hibernate.dao.AccountDao;
import my.test.spring.hibernate.dao.BookDao;
import my.test.spring.hibernate.dao.BookStoreDao;
import my.test.spring.hibernate.entities.Account;
import my.test.spring.hibernate.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringHibernateTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private BookStoreDao bookStoreDao;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void testSaveEntity() {
        Account account = new Account(1, "Tom", 100.0);
        accountDao.insertAccount(account);

        Book book1 = new Book("0001", "Thinking in Java", 45.0, 10);
        Book book2 = new Book("0002", "C++ Primer", 60.0, 15);
        Book book3 = new Book("0003", "Test Book", 30.0, 20);
        bookDao.insertBook(book1);
        bookDao.insertBook(book2);
        bookDao.insertBook(book3);
    }

    @Test
    @Transactional
    public void testUpdateEntity() {
        Book book = bookDao.getBookByISBN("0003");
        book.setStock(10);
        bookDao.updateBook(book);
    }

    @Test
    @Transactional
    public void testDeleteEntity() {
        bookDao.deleteBook("0003");
        accountDao.deleteAccount(1);
    }

    @Test
    @Transactional
    public void testHql() {
        System.out.println(accountDao.getAccountByUsername("Tom"));
    }

    @Test
    @Transactional
    public void testHqlDelete() {
        accountDao.deleteAccount("Tom");
    }
}
