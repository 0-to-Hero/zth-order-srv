package br.com.zeroth.order.controller;

import br.com.zeroth.order.domain.Order;
import br.com.zeroth.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable UUID id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable UUID id) {
        orderService.deleteOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        order.setId(id);
        return orderService.updateOrder(order);
    }
}