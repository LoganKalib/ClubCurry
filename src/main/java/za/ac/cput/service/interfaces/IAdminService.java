package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Admin;

/**
 * Interface for Admin service operations.
 * Extends the generic IService interface to inherit common service methods.
 * Defines additional custom service methods specific to Admin entities.
 */
public interface IAdminService extends IService<Admin, String> {

    /**
     * Method to check if an Admin exists with the given username.
     *
     * @param username the username of the Admin
     * @return true if the Admin exists; otherwise, returns false
     */
    public Boolean findAdminByUsername(String username);

    String verify(Admin boss);
}
