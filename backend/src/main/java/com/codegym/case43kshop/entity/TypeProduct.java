package com.codegym.case43kshop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TYPE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "NAME")
    @NotNull(message = "Product Name Not Null!!!")
    @NotBlank(message = "Product Name Not Blank!!!")
    private String name;

    @OneToMany(mappedBy = "typeProduct")
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;
}
