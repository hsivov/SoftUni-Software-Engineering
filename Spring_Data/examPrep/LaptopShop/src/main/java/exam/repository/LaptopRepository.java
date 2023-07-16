package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Optional<Laptop> findLaptopByMacAddress(String macAddress);

    Set<Laptop> findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddress();
}
