package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.GeneralStaff;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    public Customer findByEmail(String username);
    public Customer findCustomerByEmailAndPassword(String email, String password);
}
