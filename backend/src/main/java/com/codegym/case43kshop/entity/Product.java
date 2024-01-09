package com.codegym.case43kshop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "NAME")
    @NotNull(message = "Product Name Not Null!!!")
    @NotBlank(message = "Product Name Not Blank!!!")
    private String name;

    @Column(name = "PRICE")
    @NotNull(message = "Product Price Not Null!!!")
    @NotBlank(message = "Product Price Not Blank!!!")
    private int price;

    @Column(name = "IMAGE")
    @NotNull(message = "Product Image Not Null!!!")
    @NotBlank(message = "Product Image Not Blank!!!")
    private String image;

//    @Column(name = "DETAIL")
//    @NotNull(message = "Product Detail Not Null!!!")
//    @NotBlank(message = "Product Detail Not Blank!!!")
//    private String detail;

    @Column(name = "STATUS")
    @NotNull(message = "Product Status Not Null!!!")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private TypeProduct typeProduct;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItemList = new ArrayList<>();
}
