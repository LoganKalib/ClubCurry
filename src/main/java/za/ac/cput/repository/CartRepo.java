package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;

/**
 * Repository interface for Cart entity.
 * Extends JpaRepository to provide CRUD operations for Cart entities.
 */
@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    public Cart findByCustomer(Customer customer);
}
