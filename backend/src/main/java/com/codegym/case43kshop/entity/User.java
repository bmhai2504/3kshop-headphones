package com.codegym.case43kshop.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "USERS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TOKEN")
    private String token;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private Role role;

    @OneToOne
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID")
    private Cart cart;
}
