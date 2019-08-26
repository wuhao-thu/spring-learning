package my.test.spring.hibernate.dao.impl;

import my.test.spring.hibernate.dao.BookDao;
import my.test.spring.hibernate.entities.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertBook(Book book) {
        hibernateTemplate.saveOrUpdate(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBook(Book book) {
        hibernateTemplate.saveOrUpdate(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteBook(String isbn) {
        Book book = hibernateTemplate.get(Book.class, isbn);
        hibernateTemplate.delete(book);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Book getBookByISBN(String isbn) {
        return hibernateTemplate.get(Book.class, isbn);
    }
}
