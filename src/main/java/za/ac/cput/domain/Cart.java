package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Cart entity in the system.
 * A Cart is associated with a Customer and contains a list of CartMenuItems.
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Unique identifier for the Cart

    @ManyToOne
    @JoinColumn(name = "customer_email")
    private Customer customer; // Customer associated with the Cart

    @OneToMany
    private List<CartMenuItems> items; // List of items in the Cart

    // Protected no-args constructor for JPA
    protected Cart() {}

    // Constructor using Builder pattern to initialize a Cart instance
    public Cart(Builder obj) {
        this.id = obj.id;
        this.customer = obj.customer;
        this.items = obj.items;
    }

    // Getter methods for accessing private fields
    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartMenuItems> getItems() {
        return items;
    }

    // Overrides equals method to compare two Cart objects based on their fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && Objects.equals(customer, cart.customer) && Objects.equals(items, cart.items);
    }

    // Overrides hashCode method to generate a hash code for the Cart object
    @Override
    public int hashCode() {
        return Objects.hash(id, customer, items);
    }

    // Overrides toString method to provide a string representation of the Cart object
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }

    /**
     * Builder class for constructing a Cart object using the Builder pattern.
     */
    public static class Builder {
        private long id;
        private Customer customer;
        private List<CartMenuItems> items;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setItems(List<CartMenuItems> items) {
            this.items = items;
            return this;
        }

        // Copies the fields from an existing Cart object to this Builder
        public Builder copy(Cart obj) {
            this.id = obj.id;
            this.customer = obj.customer;
            this.items = obj.items;
            return this;
        }

        // Builds and returns a Cart instance using the Builder pattern
        public Cart build() {
            return new Cart(this);
        }
    }
}
