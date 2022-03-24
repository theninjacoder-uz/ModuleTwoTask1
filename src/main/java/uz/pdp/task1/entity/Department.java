package uz.pdp.task1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Department extends BaseEntity{

    private String name;

    @ManyToOne
    private Company company;
}
