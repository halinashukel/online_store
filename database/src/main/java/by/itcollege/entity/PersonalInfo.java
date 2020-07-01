package by.itcollege.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor

@Entity(name = "personal_info")
public class PersonalInfo extends BaseEntity {

    @Column(name = "login")
     private String login;

    @Column(name = "password")
    private String password;

}
