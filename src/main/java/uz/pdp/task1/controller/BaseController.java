package uz.pdp.task1.controller;

import org.springframework.http.ResponseEntity;

public interface BaseController<T> {

    ResponseEntity<?> getAll();
    ResponseEntity<?> add(T itemDto);
    ResponseEntity<?> edit(Integer id, T itemDto);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> getById(Integer id);
}
