package by.itcollege.dao;

import by.itcollege.entity.Product;
import by.itcollege.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAllBy();
    Product findById(Long id);
    void deleteById(Long id);
    Product save(Product product);
    Optional<Product> findProductById(Long id);
}
