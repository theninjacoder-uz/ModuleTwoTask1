package uz.pdp.task1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.task1.dto.CompanyDto;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.entity.Company;
import uz.pdp.task1.repository.AddressRepository;
import uz.pdp.task1.repository.CompanyRepository;
import uz.pdp.task1.response.ApiResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService implements BaseService<CompanyDto>{

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("All", 1, companyRepository.findAll());
    }

    @Override
    public ApiResponse add(CompanyDto item) {
        Optional<Address> optionalAddress = addressRepository.findById(item.getAddressId());
        if(optionalAddress.isEmpty())
            return new ApiResponse("Address Not Found", 2, null);

        Company company = new Company();
        company.setDirectorName(item.getDirectorName());
        company.setAddress(optionalAddress.get());
        company.setCorpName(item.getCompanyName());

        return new ApiResponse("add", 1, companyRepository.save(company));
    }

    @Override
    public ApiResponse edit(Integer id, CompanyDto itemDto) {
        Optional<Company> byId = companyRepository.findById(id);
        if(byId.isEmpty())
            return new ApiResponse("Company Not Found", 2, null);

        int addressId = itemDto.getAddressId();
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if(optionalAddress.isEmpty())
            return new ApiResponse("Address Not Found", 2, null);

        Company company = new Company();
        company.setAddress(optionalAddress.get());
        company.setCorpName(itemDto.getCompanyName());
        company.setDirectorName(itemDto.getDirectorName());

        companyRepository.save(company);

        return new ApiResponse("Edited", 1, company);
    }

    @Override
    public ApiResponse delete(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isEmpty())
            return new ApiResponse("Not Found", 2, null);

        companyRepository.deleteCompany(id);
        return new ApiResponse("Deleted", 1, null);
    }

    @Override
    public ApiResponse getById(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isEmpty())
            return new ApiResponse("Not Found", 2, null);
        return new ApiResponse("Company", 1, optionalCompany.get());
    }
}
