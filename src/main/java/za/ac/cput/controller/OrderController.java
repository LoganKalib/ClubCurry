package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order obj){
        Order order = OrderFactory.buildOrder(
                obj.getOrderId(),
                obj.getOrdered(),
                obj.getCart(),
                obj.getDateOrdered(),
                obj.isCompleted());
        return orderService.create(obj);
    }

    @GetMapping("/read/{id}")
    public Order read(@PathVariable String id){
        return orderService.read(id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Order order = OrderFactory.buildOrder(id);
        orderService.delete(order);
    }

    @GetMapping("/getAll")
    public List<Order> getAll(){
        return orderService.getAll();

    }
}
