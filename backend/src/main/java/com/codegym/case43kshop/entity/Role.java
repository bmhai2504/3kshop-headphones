package com.codegym.case43kshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROLES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> userList = new ArrayList<>();

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
