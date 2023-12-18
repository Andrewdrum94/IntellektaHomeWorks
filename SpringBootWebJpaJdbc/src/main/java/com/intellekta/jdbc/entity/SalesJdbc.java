package com.intellekta.jdbc.entity;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalesJdbc {

    private long id;
    private int price;
    private Date receipt_of_goods;
    private Date sale_of_goods;
    private int id_product;

}
