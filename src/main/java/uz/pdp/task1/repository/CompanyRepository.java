package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.task1.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Modifying
    @Query(value = "update Company set active = false where id = ?1")
    boolean deleteCompany(Integer id);
}
