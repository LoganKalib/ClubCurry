package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.service.AdminService;

import java.util.List;

/**
 * REST Controller for managing Admin-related operations.
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow cross-origin requests from localhost:3000
public class AdminController {

    private AdminService adminService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    /**
     * Constructor-based dependency injection of AdminService.
     *
     * @param adminService the Admin service instance
     */
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Saves a new Admin object to the database.
     *
     * @param obj the Admin object to save
     * @return a ResponseEntity containing the saved Admin object or an error status
     */
    @PostMapping("/save")
    public ResponseEntity<Admin> save(@RequestBody Admin obj) {
        String password = encoder.encode(obj.getPassword());
        Admin boss = AdminFactory.buildAdmin(obj.getId(), obj.getName(), obj.getSurname(), obj.getUsername(),password);
        if (boss != null) {
            if (!adminService.findAdminByUsername(boss.getUsername())) {
                return ResponseEntity.status(HttpStatus.OK).body(adminService.save(boss));
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    /**
     * Reads an Admin object by ID.
     *
     * @param id the ID of the Admin to read
     * @return a ResponseEntity containing the Admin object or an error status
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<Admin> read(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.read(id));
    }
    @GetMapping("/readByUsername/{username}")
    public ResponseEntity<Admin> readUsername(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAdminByUsername2(username));
    }

    /**
     * Updates an existing Admin object in the database.
     *
     * @param obj the Admin object to update
     * @return a ResponseEntity containing the updated Admin object or an error status
     */
    @PutMapping("/update")
    public ResponseEntity<Admin> update(@RequestBody Admin obj) {
        String password = encoder.encode(obj.getPassword());
        Admin boss = AdminFactory.buildAdmin(obj.getId(), obj.getName(), obj.getSurname(), obj.getUsername(), password);
        if (boss != null) {
            if (!adminService.findAdminByUsername(boss.getUsername())) {
                Admin bossMan = adminService.update(boss);
                if (bossMan != null) {
                    return ResponseEntity.status(HttpStatus.OK).body(bossMan);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    /**
     * Deletes an Admin object by ID.
     *
     * @param id the ID of the Admin to delete
     * @return a ResponseEntity containing the deletion status
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.delete(id));
    }

    /**
     * Retrieves all Admin objects from the database.
     *
     * @return a ResponseEntity containing a list of all Admin objects
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAll());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin obj){
        Admin boss = AdminFactory.buildAdmin(obj.getUsername(),obj.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(adminService.verify(boss));
    }

}
