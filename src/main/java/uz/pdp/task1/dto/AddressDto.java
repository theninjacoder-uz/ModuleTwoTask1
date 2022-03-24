package uz.pdp.task1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddressDto {
    @NotBlank
    private int homeNumber;
    @NotBlank
    private String street;
}
