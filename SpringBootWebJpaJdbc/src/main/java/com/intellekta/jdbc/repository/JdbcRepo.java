package com.intellekta.jdbc.repository;

import com.intellekta.jdbc.entity.SalesJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("jdbc")
//@SuppressWarnings("unused")
public class JdbcRepo {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate npjt;

    @Autowired
    public JdbcRepo(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate npjt) {
        this.jdbcTemplate = jdbcTemplate;
        this.npjt = npjt;
    }

    public Integer getCountOfSales() {
        return jdbcTemplate.queryForObject("select count(*) from sales;", Integer.class);
    }

    public SalesJdbc getSalesById(long id) {
        SalesJdbc product;
        try {
            product = jdbcTemplate.queryForObject("select * from sales where id = ?;", new BeanPropertyRowMapper<>(SalesJdbc.class), id);
        } catch (Exception e) {
            System.out.println("Значения с таким id: " + id + " не существует");
            return null;
        }
        return product;
    }

    public List<SalesJdbc> getRowsWithPriceMoreThen100() {
        return jdbcTemplate.query("select * from sales", (rs, rowNum) ->
            new SalesJdbc(
                    rs.getLong("id"),
                    rs.getInt("price"),
                    rs.getDate("receipt_of_goods"),
                    rs.getDate("sale_of_goods"),
                    rs.getInt("id_product"))
        ).stream().filter(entity -> entity.getPrice() > 100).toList();
    }

    public void addData(SalesJdbc salesJdbc) {
        if (salesJdbc != null && getSalesById(salesJdbc.getId()) == null) {
            Map<String, Object> params = Map.of("id", salesJdbc.getId(),
                    "price", salesJdbc.getPrice(),
                    "receipt_of_goods", salesJdbc.getReceipt_of_goods(),
                    "sale_of_goods", salesJdbc.getSale_of_goods(),
                    "id_product", salesJdbc.getId_product());
            npjt.update("insert into sales values(:id, :price, :receipt_of_goods, :sale_of_goods, :id_product);", params);
        }
    }

//    public void addDataToDbWithJdbc(SalesJdbc salesJdbc) {
//        if (salesJdbc != null) {
//            jdbcTemplate.update("insert into sales values(?,?,?,?,?);",
//                    salesJdbc.getId(), salesJdbc.getPrice(), salesJdbc.getReceipt_of_goods(),
//                    salesJdbc.getSale_of_goods(), salesJdbc.getId_product());
//        }
//    }
}
