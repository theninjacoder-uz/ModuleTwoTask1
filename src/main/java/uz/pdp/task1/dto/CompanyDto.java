package uz.pdp.task1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    @NotBlank
    private String companyName;
    private String directorName;
    private int addressId;
}
