package com.codegym.case43kshop.entity;

import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "NAME")
    @NotNull(message = "Category Name Not Null!!!")
    @NotBlank(message = "Category Name Not Blank!!!")
    private String name;

    @OneToMany(mappedBy = "category")
    @NotNull
    private List<Product> products  = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<TypeProduct> typeProducts;
}
