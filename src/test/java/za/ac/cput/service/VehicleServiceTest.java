package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;

    private static Vehicle vehicle1, vehicle2;

//    @BeforeEach
//    void a_setUp() {
//        vehicle1 = VehicleFactory.buildVehicle(123455, "Toyota", "2011", "Blue");
//        assertNotNull(vehicle1);
//
//
//        vehicle2 = VehicleFactory.buildVehicle(137827, "Kia", "2009", "Black");
//        assertNotNull(vehicle2);
//
//
//
//    }

    @Test
    void b_save() {
        Vehicle savedVehicle1 = vehicleService.save(vehicle1);
        assertNotNull(savedVehicle1);
        System.out.println(savedVehicle1);

        Vehicle savedVehicle2 = vehicleService.save(vehicle2);
        assertNotNull(savedVehicle2);
        System.out.println(savedVehicle2);

    }

    @Test
    void c_read() {
        Vehicle read = vehicleService.read(123455L);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Vehicle newVehicle = new Vehicle.Builder().copy(vehicle1).setColor("Red").build();
        Vehicle updated = vehicleService.update(newVehicle);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void f_delete() {
        vehicleService.delete(vehicle2.getId());
        System.out.println("vehicle2 successfully deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(vehicleService.getAll());
    }
}