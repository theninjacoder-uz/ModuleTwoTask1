package uz.pdp.task1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task1.dto.CompanyDto;
import uz.pdp.task1.response.ApiResponse;
import uz.pdp.task1.service.CompanyService;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class CompanyController implements BaseController<CompanyDto> {

    private final CompanyService companyService;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(companyService.getAll());
    }


    @Override
    public ResponseEntity<?> add(CompanyDto itemDto) {
        ApiResponse add = companyService.add(itemDto);
        if(add.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(add);

        return ResponseEntity.ok().body(add);
    }

    @Override
    public ResponseEntity<?> edit(Integer id, CompanyDto itemDto) {
        ApiResponse edit = companyService.edit(id, itemDto);
        if(edit.getStatusCode() == 2)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        ApiResponse edit = companyService.delete(id);
        if(edit.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        ApiResponse get = companyService.getById(id);
        if(get.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(get);

        return ResponseEntity.ok().body(get);
    }
}
