package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.task1.entity.Department;
import uz.pdp.task1.entity.Worker;

public interface WorkerRepository  extends JpaRepository<Worker, Integer> {
    @Modifying
    @Query(value = "update Worker set active = false where id = ?1")
    boolean deleteWorker(Integer id);
}
