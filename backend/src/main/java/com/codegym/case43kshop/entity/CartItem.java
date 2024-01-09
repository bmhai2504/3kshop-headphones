package com.codegym.case43kshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "CART_ITEM")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "SUB_PRICE")
    private int subPrice;

//    @Column(name = "STATUS")
//    private boolean status;

    @ManyToOne
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private Product product;
}
