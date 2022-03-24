package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.task1.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Modifying
    @Query(value = "update Department set active = false where id = ?1")
    boolean deleteDepartment(Integer id);
}
