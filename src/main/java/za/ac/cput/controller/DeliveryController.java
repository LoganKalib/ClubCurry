package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class DeliveryController {

    private final DeliveryService deliveryService;


    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    /**
     * Save a new delivery.
     * @param delivery the delivery object to be saved
     */
    @PostMapping("/save")
    public ResponseEntity<Delivery> save(@RequestBody Delivery delivery) {
        Delivery savedDelivery = deliveryService.save(delivery);

        if (savedDelivery == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(savedDelivery);
    }

    /**
     * Retrieve a delivery by its ID.
     * @param id the ID of the delivery to retrieve
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Delivery> read(@PathVariable Long id) {
        Delivery delivery = deliveryService.read(id);
        if (delivery == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(delivery);
    }

    /**
     * Update an existing delivery.
     * @param delivery the delivery object with updated information
     */
    @PutMapping("/update")
    public ResponseEntity<Delivery> update(@RequestBody Delivery delivery) {
        Delivery updatedDelivery = deliveryService.update(delivery);

        if (updatedDelivery == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedDelivery);
    }

    /**
     * Delete a delivery by its ID.
     * @param id the ID of the delivery to delete
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Boolean isDeleted = deliveryService.delete(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    /**
     * Retrieve a list of all deliveries.
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Delivery>> getAll() {
        List<Delivery> deliveries = deliveryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(deliveries);
    }

    @GetMapping("/getByCustomerEmail/{email}")
    public ResponseEntity<List<Delivery>> getAllDeliveriesByEmail(@PathVariable String email){
        List<Delivery> deliveries = deliveryService.getDeliveryByCustomer(email);
        return ResponseEntity.status(HttpStatus.OK).body(deliveries);

    }
    @GetMapping("/getAllByDriverId/{id}")
    public ResponseEntity<List<Delivery>> getAllByDriverId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryService.getDeliveryByDriverId(id));
    }
}
