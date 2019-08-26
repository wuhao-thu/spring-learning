package my.test.spring.jdbc;

import my.test.spring.jdbc.beans.JDBCTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JDBCTest jdbcTest = (JDBCTest) context.getBean("jdbcTest");
        //插入一条数据
        //jdbcTest.testInsert("Tom", "male", 23);

        //更新一条数据
        jdbcTest.updateAgeByName(25, "Tom");

        //批量插入数据
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"Jerry", "male", 21});
        batchArgs.add(new Object[]{"Alex", "female", 24});
        batchArgs.add(new Object[]{"Selena", "female", 22});
        //jdbcTest.batchInsert(batchArgs);

        //查询一条数据，返回对象
        System.out.println(jdbcTest.queryForObject("Tom"));

        //查询满足条件的数据集合
        System.out.println(jdbcTest.queryByAge(21));

        //统计查询
        System.out.println(jdbcTest.getCount());

        //查询单个列的值
        System.out.println(jdbcTest.getAge("Tom"));
        System.out.println(jdbcTest.getGender("Tom"));
    }
}
