package my.test.spring.transaction.service.impl;

import my.test.spring.transaction.dao.BookStoreDao;
import my.test.spring.transaction.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookStoreService")
public class BookStoreServiceImp implements BookStoreService {
    @Autowired
    private BookStoreDao bookStoreDao;

    //添加事务注解
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, String isbn) {
        try {
            System.out.println("Purchasing...");
            //获取单价
            Double price = bookStoreDao.getBookPriceByISBN(isbn);
            System.out.println("The price of " + bookStoreDao.getBookNameByISBN(isbn) + " is : " + price);
            //更新库存
            bookStoreDao.updateBookStock(isbn);
            System.out.println("Current stock: " + bookStoreDao.getBookStock(isbn));
            //更新账户余额
            bookStoreDao.updateUserAccount(username, price);
            System.out.println("Balance of current user: " + bookStoreDao.getUserBalance(username));
        } catch (EmptyResultDataAccessException e) {
            System.out.println("记录不存在！");
        }
    }
}
