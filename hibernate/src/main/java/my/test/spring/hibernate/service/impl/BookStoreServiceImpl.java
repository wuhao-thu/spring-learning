package my.test.spring.hibernate.service.impl;

import my.test.spring.hibernate.dao.BookStoreDao;
import my.test.spring.hibernate.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    private BookStoreDao bookStoreDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void purchase(String username, String isbn) {
        Double price = bookStoreDao.getBookPriceByISBN(isbn);
        bookStoreDao.updateBookStock(isbn);
        bookStoreDao.updateUserAccount(username, price);
    }
}
