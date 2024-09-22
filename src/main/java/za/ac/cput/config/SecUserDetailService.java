package za.ac.cput.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepo;

@Service
public class SecUserDetailService implements UserDetailsService {
    @Autowired
    private AdminRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findAdminByUsername(username);
        if(admin == null){
            throw new UsernameNotFoundException("user not found...");
        }
        return new UserPrincipal(admin);
    }
}
