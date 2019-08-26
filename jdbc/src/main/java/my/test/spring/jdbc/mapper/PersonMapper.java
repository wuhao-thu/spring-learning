package my.test.spring.jdbc.mapper;

import my.test.spring.jdbc.beans.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setName(rs.getString("name"));
        person.setGender(rs.getString("gender"));
        person.setAge(rs.getInt("age"));
        return person;
    }
}
