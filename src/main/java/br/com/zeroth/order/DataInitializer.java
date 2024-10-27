package br.com.zeroth.order;

import br.com.zeroth.order.domain.Order;
import br.com.zeroth.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        // Cria uma massa de dados
        Order order1 = new Order();
        order1.setId(UUID.randomUUID()); // Gera um UUID
        order1.setDescription("First Order");
        order1.setAmount(100.0);
        order1.setProductId("product1");

        Order order2 = new Order();
        order2.setId(UUID.randomUUID()); // Gera um UUID
        order2.setDescription("Second Order");
        order2.setAmount(200.0);
        order2.setProductId("product2");

        Order order3 = new Order();
        order3.setId(UUID.randomUUID()); // Gera um UUID
        order3.setDescription("Third Order");
        order3.setAmount(300.0);
        order3.setProductId("product3");

        // Salva os dados no repositório
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

    }
}