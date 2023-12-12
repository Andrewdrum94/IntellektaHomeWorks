package com.intellekta.jdbc.repository;

import com.intellekta.jdbc.entity.SalesJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jdbc")
@SuppressWarnings("unused")
public class JdbcRepo {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRepo(JdbcTemplate jdbcTemplate) {
        JdbcRepo.jdbcTemplate = jdbcTemplate;
    }

    public static Integer getCountOfSales() {
        return jdbcTemplate.queryForObject("select count(*) from sales;", Integer.class);
    }

    public static SalesJdbc getSalesById(long id) {
        SalesJdbc product;
        try {
            product = jdbcTemplate.queryForObject("select * from sales where id = " + id + ";", new BeanPropertyRowMapper<>(SalesJdbc.class));
        } catch (Exception e) {
            System.out.println("Значения с таким id: " + id + " не существует");
            return null;
        }
        return product;
    }

    public static List<SalesJdbc> getRowsWithPriceMoreThen100() {
        return jdbcTemplate.query("select * from sales", (rs, rowNum) ->
            new SalesJdbc(
                    rs.getLong("id"),
                    rs.getInt("price"),
                    rs.getDate("receipt_of_goods"),
                    rs.getDate("sale_of_goods"),
                    rs.getInt("id_product"))
        ).stream().filter(entity -> entity.getPrice() > 100).toList();
    }

    public static void addDataToDbWithJdbc(SalesJdbc salesJdbc) {
        if (salesJdbc != null) {
            jdbcTemplate.update("insert into sales values(?,?,?,?,?);",
                    salesJdbc.getId(), salesJdbc.getPrice(), salesJdbc.getReceipt_of_goods(),
                    salesJdbc.getSale_of_goods(), salesJdbc.getId_product());
        }
    }
}
