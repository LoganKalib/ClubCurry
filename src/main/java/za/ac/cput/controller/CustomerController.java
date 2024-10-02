package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow all origins and headers
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer obj) {
        // builds a customer with no addresses
        Customer buildObj = CustomerFactory.buildCustomer(obj.getEmail(), obj.getName(), obj.getSurname(), obj.getMobileNo(), obj.getPassword());
        Customer exists = customerService.read(obj.getEmail());
        if (buildObj == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        if (exists != null) {
            System.out.println(exists);
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerService.save(buildObj));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> read(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.read(id));
    }


    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer obj) {
        //  updates with addresses
        Customer buildObj = CustomerFactory.buildCustomer(obj.getEmail(), obj.getName(), obj.getSurname(), obj.getMobileNo(), obj.getPassword());
        Customer exists = customerService.read(obj.getEmail());

        if (buildObj == null) {
            System.out.println(1);
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        if (exists != null) {
            Customer updated = customerService.update(buildObj);
            System.out.println(updated.getAddresses());
            return ResponseEntity.status(HttpStatus.OK).body(customerService.read(updated.getEmail()));
        }
        System.out.println(exists);
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.delete(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin obj){
        Admin boss = AdminFactory.buildAdmin(obj.getUsername(),obj.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(customerService.verify(boss));
    }
}
