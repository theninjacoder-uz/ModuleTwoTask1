package uz.pdp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.task1.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Modifying
    @Query(value = "update Address set active = false where id = ?1")
    boolean deleteAddress(Integer id);
}
