package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Vehicle;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = VehicleFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class VehicleFactoryTest {

    @Test
    @Order(1)
    void buildVehicle(){
        Vehicle v1 = VehicleFactory.buildVehicle("Toyota", "2009", "White");
        assertNotNull(v1);
        System.out.println(v1);
    }

    @Test
    @Order(2)
    void testBuildVehicleFail(){
        Vehicle v1 = VehicleFactory.buildVehicle("Toyota", "", "White");
        assertNotNull(v1);
        System.out.println(v1);
    }

//    @Test
//    @Order(3)
//    void buildVehicleWithId(){
//        Vehicle v2 = VehicleFactory.buildVehicle(12345678, "Volkswagen", "2018", "Silver");
//        assertNotNull(v2);
//        System.out.println(v2);
//    }

//
//    @Test
//    @Order(4)
//    void buildVehicleWithIdFail(){
//        Vehicle v2 = VehicleFactory.buildVehicle(-344444444, "Volkswagen", "2018", "Silver");
//        assertNotNull(v2);
//        System.out.println(v2);
//    }

}
