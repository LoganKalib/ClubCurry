package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Driver;
public interface IDriverService extends IService<Driver, String>{
    public boolean findByUsername(String username);
    String verify(Driver boss);
}
