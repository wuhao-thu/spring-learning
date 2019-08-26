package my.test.spring.beans;

import my.test.spring.beans.bean.Computer;
import my.test.spring.beans.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //1. 创建Spring的IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 从容器中获取Bean
        User xiaoming = (User) applicationContext.getBean("xiaoming");
        Computer pc = (Computer) applicationContext.getBean("pc");
        //3. 打印
        System.out.println(xiaoming);
        System.out.println(pc);
    }
}
