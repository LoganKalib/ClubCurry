package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import za.ac.cput.config.JWTService;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.repository.GenStaffRepo;
import za.ac.cput.service.interfaces.IGenStaffService;

import java.util.List;

@Service
public class GenStaffService implements IGenStaffService {

    private GenStaffRepo genStaffRepo;
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    @Autowired
    public GenStaffService(GenStaffRepo genStaffRepo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.genStaffRepo = genStaffRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public GeneralStaff save(GeneralStaff obj) {
        return genStaffRepo.save(obj);
    }

    @Override
    public GeneralStaff read(String s) {
        return genStaffRepo.findById(s).orElse(null);
    }

    @Override
    public GeneralStaff update(GeneralStaff obj) {
        if(genStaffRepo.existsById(obj.getId())){
            return genStaffRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(genStaffRepo.existsById(s)){
            genStaffRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<GeneralStaff> getAll() {
        return genStaffRepo.findAll();
    }

    @Override
    public Boolean findByUsername(String username) {
        GeneralStaff guy = genStaffRepo.findByUsername(username);
        return guy != null;
    }
    public GeneralStaff findAdminByUsername2(String username) {
        return genStaffRepo.findByUsername(username);
    }

    @Override
    public String verify(GeneralStaff boss) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        boss.getUsername(),boss.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(boss.getUsername());
        }
        return "Fail";
    }
}
