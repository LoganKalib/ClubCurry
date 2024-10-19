package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;

import java.util.List;

public interface IDeliveryService extends IService<Delivery, Long> {
    List<Delivery> getDeliveryByCustomer(String email);
    List<Delivery> getDeliveryByDriverId(String id);
}
