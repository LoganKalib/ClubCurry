package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;

import java.util.List;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
    List<Delivery> getDeliveriesByOrder_Cart_Customer_Email(String email);
}
