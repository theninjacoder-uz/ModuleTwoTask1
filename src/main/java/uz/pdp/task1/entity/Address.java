package uz.pdp.task1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Address extends BaseEntity{
    private int homeNumber;
    private String street;

    public Address(int homeNumber, String street) {
        this.homeNumber = homeNumber;
        this.street = street;
    }
}
