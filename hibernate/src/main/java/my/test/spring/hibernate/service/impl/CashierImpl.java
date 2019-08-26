package my.test.spring.hibernate.service.impl;

import my.test.spring.hibernate.service.BookStoreService;
import my.test.spring.hibernate.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookStoreService bookStoreService;

    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn:isbns) {
            bookStoreService.purchase(username, isbn);
        }
    }
}
