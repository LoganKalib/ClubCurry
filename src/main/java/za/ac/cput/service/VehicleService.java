package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.VehicleRepo;
import za.ac.cput.service.interfaces.IVehicleService;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public Vehicle save(Vehicle obj) {
        return vehicleRepo.save(obj);
    }

    @Override
    public Vehicle read(String aLong) {
        return vehicleRepo.findById(aLong).orElse(null);
    }

    @Override
    public Vehicle update(Vehicle obj) {
        if(vehicleRepo.existsById(obj.getId())){
            return vehicleRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String aLong) {
        if(vehicleRepo.existsById(aLong)){
            vehicleRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepo.findAll();
    }
}
