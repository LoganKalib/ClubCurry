package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import za.ac.cput.config.JWTService;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepo;
import za.ac.cput.service.interfaces.ICustomerService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private CustomerRepo customerRepo;
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    @Autowired
    public CustomerService(CustomerRepo customerRepo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.customerRepo = customerRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public Customer save(Customer obj) {
        return customerRepo.save(obj);
    }

    @Override
    public Customer read(String s) {
        return customerRepo.findById(s).orElse(null);
    }

    @Override
    public Customer update(Customer obj) {
        if(customerRepo.existsById(obj.getEmail())){
            return customerRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(customerRepo.existsById(s)){
            customerRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public Customer findByEmailAndPassword(String username, String password){
        return customerRepo.findCustomerByEmailAndPassword(username,password);
    }
    public Customer findAdminByUsername2(String username) {
        return customerRepo.findByEmail(username);
    }

    @Override
    public String verify(Customer boss) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        boss.getEmail(),boss.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(boss.getEmail());
        }
        return "Fail";
    }
}
