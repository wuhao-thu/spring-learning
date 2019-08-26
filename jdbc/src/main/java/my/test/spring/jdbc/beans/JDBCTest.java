package my.test.spring.jdbc.beans;

import my.test.spring.jdbc.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Component("jdbcTest")
public class JDBCTest {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void insert(String name, String gender, Integer age) {
        String sql = "INSERT INTO person_table (name, gender, age) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, name, gender, age);
    }

    public void batchInsert(List<Object[]> batchArgs) {
        String sql = "INSERT INTO person_table (name, gender, age) VALUES(?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    public void updateAgeByName(Integer age, String name) {
        String sql = "UPDATE person_table SET age = ? WHERE name = ?";
        jdbcTemplate.update(sql, age, name);
    }

    public Person queryForObject(String name) {
        //使用自定义的RowMapper
//        String sql = "SELECT * FROM my_table WHERE name = ?";
//        Person person = jdbcTemplate.queryForObject(sql, new Object[]{name}, new PersonMapper());
//        return person;
        //使用BeanPropertyRowMapper
        String sql = "SELECT * FROM person_table WHERE name = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Person.class));
        return person;
    }

    public List<Person> queryByAge(Integer minAge) {
        String sql = "SELECT * FROM person_table WHERE age > ?";
        List<Person> people = jdbcTemplate.query(sql, new Object[]{minAge}, new BeanPropertyRowMapper<>(Person.class));
        return people;
    }

    public long getCount() {
        String sql = "SELECT count(name) FROM person_table";
        long count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public int getAge(String name) {
        String sql = "SELECT age FROM person_table WHERE name = ?";
        Integer age = jdbcTemplate.queryForObject(sql, Integer.class, name);
        return age;
    }

    public String getGender(String name){
        String sql = "SELECT * FROM person_table WHERE name = ?";
        Map personMap = jdbcTemplate.queryForMap(sql, name);
        String gender = (String)personMap.get("gender");
        return gender;
    }
}
