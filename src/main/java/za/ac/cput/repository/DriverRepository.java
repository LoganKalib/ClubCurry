package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository <Driver, String>{
}
