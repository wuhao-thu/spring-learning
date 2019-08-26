package my.test.spring;

import my.test.spring.aop.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArithmeticCalculator cal = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        cal.add(3, 4);
        cal.mul(4, 7);
    }
}
