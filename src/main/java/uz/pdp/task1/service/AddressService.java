package uz.pdp.task1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.task1.dto.AddressDto;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.repository.AddressRepository;
import uz.pdp.task1.response.ApiResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService implements BaseService<AddressDto>{

    private final AddressRepository addressRepository;

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("All addresses", 1, addressRepository.findAll());
    }

    @Override
    public ApiResponse add(AddressDto item) {
        Address address = new Address(item.getHomeNumber(), item.getStreet());
        return new ApiResponse("Added", 1, address);
    }

    @Override
    public ApiResponse edit(Integer id, AddressDto itemDto) {
        Optional<Address> byId = addressRepository.findById(id);
        if(byId.isEmpty())
            return new ApiResponse("Not Found", 2, null);

        Address address = byId.get();
        address.setHomeNumber(itemDto.getHomeNumber());
        address.setStreet(itemDto.getStreet());
        addressRepository.save(address);

        return new ApiResponse("Edited", 1, address);
    }

    @Override
    public ApiResponse delete(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);
        if(byId.isEmpty())
            return new ApiResponse("Not Found", 2, null);

        addressRepository.deleteAddress(id);
        return new ApiResponse("Edited", 1, null);
    }

    @Override
    public ApiResponse getById(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);
        if(byId.isEmpty())
            return new ApiResponse("Not Found", 2, null);
        return new ApiResponse("Address", 1, byId.get());
    }
}
