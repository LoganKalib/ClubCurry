package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CartMenuItems;

/**
 * Repository interface for CartMenuItems entity.
 * Extends JpaRepository to provide CRUD operations for CartMenuItems entities.
 */
@Repository
public interface CartMenuItemsRepo extends JpaRepository<CartMenuItems, Long> {
}
