package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import za.ac.cput.config.JWTService;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepo;
import za.ac.cput.service.interfaces.IDriverService;


import java.util.List;

@Service
public class DriverService implements IDriverService{
    private DriverRepo driverRepo;
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    @Autowired
    public DriverService(DriverRepo driverRepo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.driverRepo = driverRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public Driver save(Driver obj) {
        return driverRepo.save(obj);
    }

    @Override
    public Driver read(String s) {
        return driverRepo.findById(s).orElse(null);
    }

    @Override
    public Driver update(Driver obj) {
        if(driverRepo.existsById(obj.getId())){
            return driverRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(driverRepo.existsById(s)){
            driverRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Driver> getAll() {
        return driverRepo.findAll();
    }
    @Override
    public boolean findByUsername(String username) {
        Driver guy = driverRepo.findByUsername(username);
        return guy != null;
    }
    public Driver findAdminByUsername2(String username) {
        return driverRepo.findByUsername(username);
    }


    @Override
    public String verify(Driver boss) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        boss.getUsername(),boss.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(boss.getUsername());
        }
        return "Fail";
    }
}
