package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.factory.CartMenuItemsFactory;
import za.ac.cput.service.CartMenuItemsService;

import java.util.List;

@RestController
@RequestMapping("/cartMenuItems")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")

public class CartMenuItemsController {

    private CartMenuItemsService cartMenuItemsService;

    @Autowired
    public CartMenuItemsController (CartMenuItemsService cartMenuItemsService) {this.cartMenuItemsService = cartMenuItemsService;}

    @PostMapping("/save")
    public ResponseEntity<CartMenuItems> save(@RequestBody CartMenuItems obj){
        CartMenuItems cartMenuItem = CartMenuItemsFactory.buildCartMenuItem(obj.getMenuItem(), obj.getQuantity(), obj.getNote(), obj.getSpiceLevel());

        if (cartMenuItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cartMenuItemsService.save(cartMenuItem));
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<CartMenuItems> read(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartMenuItemsService.read(id));
    }

    @PutMapping("/update")
    public ResponseEntity<CartMenuItems> update(@RequestBody CartMenuItems obj) {
        CartMenuItems cartMenuItem = CartMenuItemsFactory.buildCartMenuItem(obj.getId(), obj.getMenuItem(), obj.getQuantity(), obj.getNote(), obj.getSpiceLevel());
        if(cartMenuItem == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cartMenuItemsService.update(cartMenuItem));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartMenuItemsService.delete(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CartMenuItems>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(cartMenuItemsService.getAll());
    }
}
