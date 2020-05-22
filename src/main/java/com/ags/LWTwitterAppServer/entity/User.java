package com.ags.LWTwitterAppServer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", length = 100, unique = true)
    private String username;

    @Column(name = "pwd", length = 200)
    private String password;

    @Column(name = "user_first_name", length = 200)
    private String firstName;

    @Column(name = "user_surname", length = 200)
    private String surname;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "profil_picture", length = 100, unique = true)
    private String profilPictureId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Shared> sharedItems;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Rate> rates;
}
