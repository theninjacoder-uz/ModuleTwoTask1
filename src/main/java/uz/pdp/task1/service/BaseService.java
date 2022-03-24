package uz.pdp.task1.service;

import org.springframework.stereotype.Service;
import uz.pdp.task1.response.ApiResponse;

@Service
public interface BaseService<T> {

    ApiResponse getAll();
    ApiResponse add(T itemEntity);
    ApiResponse edit(Integer id, T itemDto);
    ApiResponse delete(Integer id);
    ApiResponse getById(Integer id);
}
