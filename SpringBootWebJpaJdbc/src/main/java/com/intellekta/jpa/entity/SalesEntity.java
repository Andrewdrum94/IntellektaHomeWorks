package com.intellekta.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "receipt_of_goods")
    private Date receipt_of_goods;

    @Column(name = "sale_of_goods")
    private Date sale_of_goods;

    @Column(name = "id_product")
    private Integer id_product;
}
