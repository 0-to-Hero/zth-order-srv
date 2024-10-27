package br.com.zeroth.order.repository;

import br.com.zeroth.order.domain.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CassandraRepository<Order, UUID> {
}