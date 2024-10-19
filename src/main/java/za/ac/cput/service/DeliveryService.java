package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.DeliveryRepo;
import za.ac.cput.service.interfaces.IDeliveryService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    private DeliveryRepo deliveryRepo;

    @Autowired
    public DeliveryService(DeliveryRepo deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }
    @Override
    public Delivery save(Delivery obj) {
        return deliveryRepo.save(obj);
    }

    @Override
    public Delivery read(Long s) {
        return deliveryRepo.findById(s).orElse(null);
    }

    @Override
    public Delivery update(Delivery obj) {
        if(deliveryRepo.existsById(obj.getId())){
            return deliveryRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long s) {
        if(deliveryRepo.existsById(s)){
            deliveryRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepo.findAll();
    }

    @Override
    public List<Delivery> getDeliveryByCustomer(String email) {
        return deliveryRepo.getDeliveriesByOrder_Cart_Customer_Email(email);
    }

    @Override
    public List<Delivery> getDeliveryByDriverId(String id) {
        return deliveryRepo.getDeliveriesByDriver_Id(id);
    }
}
