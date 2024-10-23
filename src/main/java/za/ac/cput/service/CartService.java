package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CartRepo;
import za.ac.cput.service.interfaces.ICartService;

import java.util.List;

/**
 * Service implementation for Cart-related operations.
 */
@Service
public class CartService implements ICartService {
    private CartRepo cartRepo;

    /**
     * Constructor-based dependency injection of CartRepo.
     *
     * @param cartRepo the Cart repository instance
     */
    @Autowired
    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    /**
     * Saves a Cart object to the database.
     *
     * @param obj the Cart object to save
     * @return the saved Cart object
     */
    @Override
    public Cart save(Cart obj) {
        return cartRepo.save(obj);
    }

    /**
     * Reads a Cart object from the database by ID.
     *
     * @param s the ID of the Cart
     * @return the Cart object if found; otherwise, null
     */
    @Override
    public Cart read(Long s) {
        return cartRepo.findById(s).orElse(null);
    }

    /**
     * Updates an existing Cart object in the database.
     *
     * @param obj the Cart object to update
     * @return the updated Cart object if it exists; otherwise, null
     */
    @Override
    public Cart update(Cart obj) {
        if (cartRepo.existsById(obj.getId())) {
            return cartRepo.save(obj);
        }
        return null;
    }

    /**
     * Deletes a Cart object from the database by ID.
     *
     * @param s the ID of the Cart to delete
     * @return true if the Cart was deleted; otherwise, false
     */
    @Override
    public Boolean delete(Long s) {
        if (cartRepo.existsById(s)) {
            cartRepo.deleteById(s);
            return true;
        }
        return false;
    }

    public Cart findByCustomer(Customer customer){
        return cartRepo.findByCustomer(customer);
    }
    /**
     * Retrieves all Cart objects from the database.
     *
     * @return a list of all Cart objects
     */
    @Override
    public List<Cart> getAll() {
        return cartRepo.findAll();
    }
}
