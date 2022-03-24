package uz.pdp.task1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Company extends BaseEntity{

    private String corpName;
    private String directorName;

    @OneToOne
    private Address address;
}
