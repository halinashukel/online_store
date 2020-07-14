package by.itcollege.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "contacts")

public class Contact extends BaseEntity {

    @Column(name = "telephone")
    private String telephone;

    @Embedded
    private Address address;


}
