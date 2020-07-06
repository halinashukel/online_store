package by.itcollege.dao;

import by.itcollege.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllBy();
    Product findById(Long id);
    void deleteById(Long id);
    Product save(Product product);
}
