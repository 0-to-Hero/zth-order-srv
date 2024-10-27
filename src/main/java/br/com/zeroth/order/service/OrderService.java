package br.com.zeroth.order.service;

import br.com.zeroth.order.domain.Order;
import br.com.zeroth.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(UUID id) {
        return orderRepository.findById(id);
    }

    public void deleteOrderById(UUID id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Order order) {
        if (orderRepository.existsById(order.getId())) {
            return orderRepository.save(order);
        }
        return null; // ou lançar uma exceção
    }
}