package uz.pdp.task1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task1.dto.AddressDto;
import uz.pdp.task1.response.ApiResponse;
import uz.pdp.task1.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController implements BaseController<AddressDto> {

    private final AddressService addressService;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(addressService.getAll());
    }

    @Override
    public ResponseEntity<?> add(AddressDto itemDto) {
        return ResponseEntity.ok().body(addressService.add(itemDto));
    }

    @Override
    public ResponseEntity<?> edit(Integer id, AddressDto itemDto) {
        ApiResponse edit = addressService.edit(id, itemDto);
        if(edit.getStatusCode() == 2)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        ApiResponse edit = addressService.delete(id);
        if(edit.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        ApiResponse get = addressService.getById(id);
        if(get.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(get);

        return ResponseEntity.ok().body(get);
    }
}
