package com.intellekta.jdbc.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalesJdbc {

    private long id;
    private int price;
    private Date receipt_of_goods;
    private Date sale_of_goods;
    private int id_of_product;

}
