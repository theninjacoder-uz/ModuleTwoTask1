package uz.pdp.task1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.task1.dto.WorkerDto;
import uz.pdp.task1.entity.Address;
import uz.pdp.task1.entity.Department;
import uz.pdp.task1.entity.Worker;
import uz.pdp.task1.repository.AddressRepository;
import uz.pdp.task1.repository.DepartmentRepository;
import uz.pdp.task1.repository.WorkerRepository;
import uz.pdp.task1.response.ApiResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService implements BaseService<WorkerDto> {

    private final WorkerRepository workerRepository;
    private final AddressRepository addressRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("All", 1, workerRepository.findAll());
    }

    @Override
    public ApiResponse add(WorkerDto item) {
        int addressId = item.getAddressId();
        int departmentId = item.getDepartmentId();

        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isEmpty())
            return new ApiResponse("Department Not Found", 2, null);

        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if(optionalAddress.isEmpty())
            return new ApiResponse("Address Not Found", 2, null);

        Worker worker = new Worker();
        worker.setAddress(optionalAddress.get());
        worker.setDepartment(optionalDepartment.get());
        worker.setName(item.getName());
        worker.setPhoneNumber(item.getPhoneNumber());

        return new ApiResponse("add", 1, workerRepository.save(worker));
    }

    @Override
    public ApiResponse edit(Integer id, WorkerDto itemDto) {
        Optional<Worker> byId = workerRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("Worker Not Found", 2, null);

        int departmentId = itemDto.getDepartmentId();
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isEmpty())
            return new ApiResponse("Department Not Found", 2, null);

        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isEmpty())
            return new ApiResponse("Address Not Found", 2, null);

        Worker worker = new Worker();
        worker.setAddress(optionalAddress.get());
        worker.setDepartment(optionalDepartment.get());
        worker.setName(itemDto.getName());
        worker.setPhoneNumber(itemDto.getPhoneNumber());

        workerRepository.save(worker);

        return new ApiResponse("Edited", 1, worker);
    }

    @Override
    public ApiResponse delete(Integer id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (optionalWorker.isEmpty())
            return new ApiResponse("Not Found", 2, null);

        workerRepository.deleteWorker(id);
        return new ApiResponse("Deleted", 1, null);
    }

    @Override
    public ApiResponse getById(Integer id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (optionalWorker.isEmpty())
            return new ApiResponse("Not Found", 2, null);
        return new ApiResponse("Worker", 1, optionalWorker.get());
    }
}
