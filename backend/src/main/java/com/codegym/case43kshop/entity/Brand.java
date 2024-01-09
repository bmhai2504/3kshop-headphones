package com.codegym.case43kshop.entity;

import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BRAND")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "NAME")
    @NotNull(message = "Brand Name Not Null!!!")
    @NotBlank(message = "Brand Name Not Blank!!!")
    private String name;

    @Column(name = "IMAGE")
    @NotNull(message = "Brand Image Not Null!!!")
    @NotBlank(message = "Brand Image Not Blank!!!")
    private String image;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
