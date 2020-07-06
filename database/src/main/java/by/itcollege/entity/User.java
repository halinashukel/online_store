package by.itcollege.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "personal_info_id")
     private PersonalInfo personalInfo;

    @OneToOne
    @JoinColumn(name = "contact_id")
     private Contact contact;

    @Enumerated(EnumType.STRING)
    private Role role;
}
