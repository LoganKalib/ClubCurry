package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
}
