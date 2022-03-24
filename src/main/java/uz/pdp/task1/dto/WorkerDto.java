package uz.pdp.task1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;

    private int departmentId;

    private int addressId;
}
