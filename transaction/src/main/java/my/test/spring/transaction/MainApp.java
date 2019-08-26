package my.test.spring.transaction;

import my.test.spring.transaction.service.BookStoreService;
import my.test.spring.transaction.service.Cashier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String username = "Tom";
        BookStoreService bookStoreService = (BookStoreService) context.getBean("bookStoreService");
        Cashier cashier = (Cashier) context.getBean("cashier");
        //测试一次购买一本书
        bookStoreService.purchase("Tom", "0002");
        //测试一次购买多本书
        //cashier.checkout("Tom", Arrays.asList("0001", "0002"));
    }
}
