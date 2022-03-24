package uz.pdp.task1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.task1.dto.DepartmentDto;
import uz.pdp.task1.entity.Company;
import uz.pdp.task1.entity.Department;
import uz.pdp.task1.repository.CompanyRepository;
import uz.pdp.task1.repository.DepartmentRepository;
import uz.pdp.task1.response.ApiResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService implements BaseService<DepartmentDto> {

    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("All", 1, departmentRepository.findAll());

    }

    @Override
    public ApiResponse add(DepartmentDto departmentDto) {
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if(optionalCompany.isEmpty())
            return new ApiResponse("Company Not Found", 2, null);

        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setCompany(optionalCompany.get());
        return new ApiResponse("add", 1, department);
    }

    @Override
    public ApiResponse edit(Integer id, DepartmentDto itemDto) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("Company Not Found", 2, null);

        int companyId = itemDto.getCompanyId();
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if (optionalCompany.isEmpty())
            return new ApiResponse("Company Not Found", 2, null);

        Department department = new Department();
        department.setCompany(optionalCompany.get());
        department.setName(itemDto.getName());

        departmentRepository.save(department);

        return new ApiResponse("Edited", 1, department);
    }

    @Override
    public ApiResponse delete(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isEmpty())
            return new ApiResponse("Not Found", 2, null);

        departmentRepository.deleteDepartment(id);
        return new ApiResponse("Deleted", 1, null);
    }

    @Override
    public ApiResponse getById(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if(optionalDepartment.isEmpty())
            return new ApiResponse("Not Found", 2, null);
        return new ApiResponse("Department", 1, optionalDepartment.get());
    }
}
