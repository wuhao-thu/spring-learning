package my.test.spring.hibernate;

import my.test.spring.hibernate.service.BookStoreService;
import my.test.spring.hibernate.service.Cashier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookStoreService bookStoreService = ctx.getBean(BookStoreService.class);
        Cashier cashier = ctx.getBean(Cashier.class);

        //测试一次购买一本书
        bookStoreService.purchase("Tom", "0001");
        //测试一次购买多本书
        cashier.checkout("Tom", Arrays.asList("0001", "0002"));
    }
}
