package uz.pdp.task1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task1.dto.DepartmentDto;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.response.ApiResponse;
import uz.pdp.task1.service.DepartmentService;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class DepartmentController implements BaseController<DepartmentDto> {

    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(departmentService.getAll());
    }

    @Override
    public ResponseEntity<?> add(DepartmentDto item) {
        return ResponseEntity.ok().body(departmentService.add(item));
    }

    @Override
    public ResponseEntity<?> edit(Integer id, DepartmentDto itemDto) {
        ApiResponse edit = departmentService.edit(id, itemDto);
        if(edit.getStatusCode() == 2)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        ApiResponse edit = departmentService.delete(id);
        if(edit.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        ApiResponse get = departmentService.getById(id);
        if(get.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(get);

        return ResponseEntity.ok().body(get);
    }
}
