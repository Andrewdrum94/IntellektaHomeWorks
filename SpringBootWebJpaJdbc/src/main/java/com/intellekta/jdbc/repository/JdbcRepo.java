package com.intellekta.jdbc.repository;

import com.intellekta.jdbc.entity.SalesJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("jdbc")
public class JdbcRepo {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepo(JdbcTemplate jdbcTemplate) {
        JdbcRepo.jdbcTemplate = jdbcTemplate;
    }

    public static Integer getCountOfProducts() {
        return jdbcTemplate.queryForObject("select count(*) from sales;", Integer.class);
    }

    public static SalesJdbc getProductById(long id) {
        SalesJdbc product;
        try {
            product = jdbcTemplate.queryForObject("select * from sales where id_of_product = " + id + ";", new BeanPropertyRowMapper<>(SalesJdbc.class));
        } catch (Exception e) {
            System.out.println("Значения с таким id: " + id + " не существует");
            return null;
        }
        return product;
    }

}
