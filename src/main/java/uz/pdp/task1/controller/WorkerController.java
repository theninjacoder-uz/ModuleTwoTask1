package uz.pdp.task1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.task1.dto.WorkerDto;
import uz.pdp.task1.response.ApiResponse;
import uz.pdp.task1.service.WorkerService;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class WorkerController implements BaseController<WorkerDto> {

    private final WorkerService workerService;

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(workerService.getAll());
    }

    @Override
    public ResponseEntity<?> add(WorkerDto itemDto) {
        return ResponseEntity.ok().body(workerService.add(itemDto));
    }

    @Override
    public ResponseEntity<?> edit(Integer id, WorkerDto itemDto) {
        ApiResponse edit = workerService.edit(id, itemDto);
        if(edit.getStatusCode() == 2)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        ApiResponse edit = workerService.delete(id);
        if(edit.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(edit);

        return ResponseEntity.ok().body(edit);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        ApiResponse get = workerService.getById(id);
        if(get.getStatusCode() == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(get);

        return ResponseEntity.ok().body(get);
    }
}
