package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Delivery;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}
