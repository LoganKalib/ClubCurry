package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.service.DriverService;

import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    // Builds a new driver and saves it
    @PostMapping("/save")
    public ResponseEntity<Driver> save(@RequestBody Driver obj){
        System.out.println(obj);
        Vehicle vehicle = VehicleFactory.buildVehicle(obj.getRegistration().getId(), obj.getRegistration().getMake(), obj.getRegistration().getModel(), obj.getRegistration().getColor());
        Driver driver = DriverFactory.buildDriver(obj.getId(),obj.getPetrolAllowance(),vehicle,obj.getName(),obj.getSurname(),obj.getPassword(),obj.getUsername());

        if(driver != null){
            if(!driverService.findByUsername(driver.getUsername())){
                return ResponseEntity.status(HttpStatus.OK).body(driverService.save(driver));
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    // Retrieves a driver by ID
    @GetMapping("/read/{id}")
    public ResponseEntity<Driver> read(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.read(id));
    }

    // Updates an existing driver
    @PutMapping("/update")
    public ResponseEntity<Driver> update(@RequestBody Driver obj){
        Driver driver = DriverFactory.buildDriver(obj.getId(), obj.getName(), obj.getSurname(), obj.getPassword(), obj.getUsername());
        if(driver != null){
            if(!driverService.findByUsername(driver.getUsername())){
                Driver updatedDriver = driverService.update(driver);
                if(updatedDriver != null){
                    return ResponseEntity.status(HttpStatus.OK).body(updatedDriver);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    // Deletes a driver by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.delete(id));
    }

    // Retrieves a List of Drivers
    @GetMapping("/getAll")
    public ResponseEntity<List<Driver>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.getAll());
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Driver obj){
        Driver boss = DriverFactory.buildDriver(obj.getUsername(),obj.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(driverService.verify(boss));
    }
}
