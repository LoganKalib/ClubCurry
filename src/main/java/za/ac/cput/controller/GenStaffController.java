package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.GenStaffFactory;
import za.ac.cput.service.GenStaffService;

import java.util.List;

@RestController
@RequestMapping("/generalStaff")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow all origins and headers
public class GenStaffController {
    private GenStaffService genStaffService;

    @Autowired
    public GenStaffController(GenStaffService genStaffService) {
        this.genStaffService = genStaffService;
    }

    @PostMapping("/save")
    public ResponseEntity<GeneralStaff> save(@RequestBody GeneralStaff obj){
        GeneralStaff guy = GenStaffFactory.buildGenStaff(obj.getId(),obj.getName(), obj.getSurname(), obj.getUsername(), obj.getPassword());
        if(guy != null){
            if(!genStaffService.findByUsername(guy.getUsername())){
                return ResponseEntity.status(HttpStatus.OK).body(genStaffService.save(guy));
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);

    }

    @GetMapping("/read/{id}")
    public ResponseEntity<GeneralStaff> read(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(genStaffService.read(id));
    }

    @PutMapping("/update")
    public ResponseEntity<GeneralStaff> update(@RequestBody GeneralStaff obj){
        GeneralStaff guy = GenStaffFactory.buildGenStaff(obj.getId(),obj.getName(), obj.getSurname(), obj.getUsername(), obj.getPassword());
        if(guy != null){
            if(!genStaffService.findByUsername(guy.getUsername())){
                GeneralStaff guysTwin = genStaffService.update(guy);
                if(guysTwin != null){
                    return ResponseEntity.status(HttpStatus.OK).body(guysTwin);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(genStaffService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GeneralStaff>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(genStaffService.getAll());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody GeneralStaff obj){
        GeneralStaff boss = GenStaffFactory.buildGenStaff(obj.getUsername(),obj.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(genStaffService.verify(boss));
    }
}
