package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Orders;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<Orders> save(@RequestBody Orders obj){
        return ResponseEntity.ok().body(orderService.save(obj));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Orders> read(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.read(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> update(@RequestBody Orders obj){
        return ResponseEntity.ok().body(orderService.update(obj));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Orders>> getAll(){
        return ResponseEntity.ok().body(orderService.getAll());
    }
}
