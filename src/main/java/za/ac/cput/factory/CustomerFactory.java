package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Customer;
import za.ac.cput.utils.Validation;

import java.util.List;

public class CustomerFactory {

    public static Customer buildCustomer(String email, String name, String surname, String mobileNo, String password, List<Address> addresses){
        if(Validation.isValidEmail(email)
                && !addresses.isEmpty()
                && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidMobileNo(mobileNo)
                && Validation.isValidPassword(password)
                && !addresses.isEmpty()){
            return new Customer.Builder()
                    .setEmail(email)
                    .setName(name)
                    .setSurname(surname)
                    .setMobileNo(mobileNo)
                    .setPassword(password)
                    .setAddresses(addresses)
                    .build();
        }
        return null;
    }
    public static Customer buildCustomer(String email, String name, String surname, String mobileNo, String password){
        if(Validation.isValidEmail(email)
                && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidMobileNo(mobileNo)){
            return new Customer.Builder()
                    .setEmail(email)
                    .setName(name)
                    .setSurname(surname)
                    .setMobileNo(mobileNo)
                    .setPassword(password)
                    .build();
        }
        return null;
    }
    public static Customer buildCustomer(String email, String name, String surname, String mobileNo){
        if(Validation.isValidEmail(email)
                && Validation.isValidString(name)
                && Validation.isValidString(surname)
                && Validation.isValidMobileNo(mobileNo)){
            return new Customer.Builder()
                    .setEmail(email)
                    .setName(name)
                    .setSurname(surname)
                    .setMobileNo(mobileNo)
                    .build();
        }
        return null;
    }
    public static Customer buildCustomer(String username){
        if(Validation.isValidEmail(username)){
            return new Customer.Builder().setEmail(username).build();
        }
        return null;
    }
    public static Customer buildCustomer(String username, String password) {
        // Validate that the ID is a valid long number
        return new Customer.Builder()
                .setEmail(username)
                .setPassword(password)
                .build();
    }
}
