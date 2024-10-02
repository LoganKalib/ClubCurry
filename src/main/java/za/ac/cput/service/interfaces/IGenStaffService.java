package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.GeneralStaff;

public interface IGenStaffService extends IService<GeneralStaff, String> {

    public Boolean findByUsername(String username);
    String verify(GeneralStaff boss);
}
