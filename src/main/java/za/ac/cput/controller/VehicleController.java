package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;
import za.ac.cput.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow all origins and headers
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/save")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle obj) {
        // Build a Vehicle object using the factory
        Vehicle buildObj = VehicleFactory.buildVehicle(obj.getId(), obj.getMake(), obj.getModel(), obj.getColor());
        if (buildObj == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        Vehicle request = vehicleService.save(buildObj);

        if (request == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(request);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Vehicle> read(@PathVariable String id) {
        Vehicle vehicle = vehicleService.read(id);
        if (vehicle == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @PutMapping("/update")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle obj) {
        // Update the Vehicle object using the factory
        Vehicle vehicle = VehicleFactory.buildVehicle(obj.getId(), obj.getMake(), obj.getModel(), obj.getColor());
        if (vehicle == null) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.update(vehicle));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean result = vehicleService.delete(id);
        if (!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(vehicles);
    }
}
