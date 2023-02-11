package edu.itstep.albums.sql;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name="user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    public Users(String userName, String password){
        super();
        this.userName = userName;
        this.password = password;
    }

}
