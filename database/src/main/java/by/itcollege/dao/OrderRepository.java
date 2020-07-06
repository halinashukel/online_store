package by.itcollege.dao;

import by.itcollege.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllBy();
    Order findById(Long id);
    void deleteById(Long id);
    Order save(Order order);

}
