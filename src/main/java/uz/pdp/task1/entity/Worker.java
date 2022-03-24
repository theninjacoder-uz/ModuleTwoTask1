package uz.pdp.task1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Worker extends BaseEntity{

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne
    private Address address;

    @ManyToOne
    private Department department;
}
