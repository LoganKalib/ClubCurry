package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.MenuItem;

import java.util.List;

public class CartFactory {

    public static Cart buildCart(Customer customer, List<MenuItem> menuItems){
        if(customer != null && !menuItems.isEmpty()){
            return new Cart.Builder().setCustomer(customer).setItems(menuItems).build();
        }
        return null;
    }
    public static Cart buildCart(Long id, Customer customer, List<MenuItem> menuItems){
        if(customer != null && !menuItems.isEmpty() && id>=0){
            return new Cart.Builder().setId(id).setCustomer(customer).setItems(menuItems).build();
        }
        return null;
    }
}