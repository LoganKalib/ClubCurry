package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;

public interface ICustomerService extends IService<Customer, String> {
    String verify(Customer boss);
}
