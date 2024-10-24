package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.facade.AddItemToCart;
import za.ac.cput.facade.CustomerCart;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.service.CartService;

import java.util.List;

/**
 * REST Controller for managing Cart-related operations.
 */
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow cross-origin requests from localhost:3000
public class CartController {

    private CartService cartService;
    private CustomerCart customerCart;
    private AddItemToCart addItemToCart;

    /**
     * Constructor-based dependency injection of services and facades.
     *
     * @param cartService     the Cart service instance
     * @param customerCart    the CustomerCart facade instance
     * @param addItemToCart   the AddItemToCart facade instance
     */
    @Autowired
    public CartController(CartService cartService, CustomerCart customerCart, AddItemToCart addItemToCart) {
        this.cartService = cartService;
        this.customerCart = customerCart;
        this.addItemToCart = addItemToCart;
    }

    /**
     * Saves a new Cart object to the database.
     *
     * @param obj the Cart object to save
     * @return a ResponseEntity containing the saved Cart object or an error status
     */
    @PostMapping("/save")
    public ResponseEntity<Cart> save(@RequestBody Cart obj) {
        Cart cart = CartFactory.buildCart(obj.getCustomer());
        if (customerCart.canSave(cart) == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        Cart reObj = cartService.save(cart);
        if (reObj == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reObj);
    }

    /**
     * Reads a Cart object by ID.
     *
     * @param id the ID of the Cart to read
     * @return a ResponseEntity containing the Cart object or an error status
     */
    @GetMapping("read/{id}")
    public ResponseEntity<Cart> read(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.read(id));
    }

    @GetMapping("readByCustomer/{id}")
    public ResponseEntity<Cart> readByCustomer(@PathVariable String id) {
  Customer obj =  new Customer.Builder().setEmail(id).build();
        return ResponseEntity.status(HttpStatus.OK).body(cartService.findByCustomer(obj));
    }

    /**
     * Updates the items in an existing Cart object.
     *
     * @param obj the Cart object with updated items
     * @return a ResponseEntity containing the updated Cart object or an error status
     */
    @PutMapping("/updateItems")
    public ResponseEntity<Cart> updateItems(@RequestBody Cart obj) {
        Cart cart = cartService.read(obj.getId());
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        if (addItemToCart.validItems(obj) == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        Cart cartUpdate = new Cart.Builder().copy(cart).setItems(obj.getItems()).build();
        return ResponseEntity.status(HttpStatus.OK).body(cartService.update(cartUpdate));
    }

    /**
     * Deletes a Cart object by ID.
     *
     * @param id the ID of the Cart to delete
     * @return a ResponseEntity containing the deletion status
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.delete(id));
    }

    /**
     * Retrieves all Cart objects from the database.
     *
     * @return a ResponseEntity containing a list of all Cart objects
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getAll());
    }
}
