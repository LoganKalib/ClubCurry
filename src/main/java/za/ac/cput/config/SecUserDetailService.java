package za.ac.cput.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.repository.AdminRepo;
import za.ac.cput.repository.CustomerRepo;
import za.ac.cput.repository.DriverRepo;
import za.ac.cput.repository.GenStaffRepo;

@Service
public class SecUserDetailService implements UserDetailsService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private GenStaffRepo genStaffRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findAdminByUsername(username);
        Driver driver = driverRepo.findByUsername(username);
        GeneralStaff genStaff = genStaffRepo.findByUsername(username);
        Customer customer = customerRepo.findByEmail(username);
        if(admin != null){
            return new UserPrincipal(admin);
        } else if (driver != null) {
            return new DriverUserPrincipal(driver);
        } else if( genStaff != null){
            return new GenStaffUserPrincipal(genStaff);
        } else if(customer!=null){
            return new CustUserPrincipal(customer);
        }
        throw new UsernameNotFoundException("user not found...");
    }

}
