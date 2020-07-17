package by.itcollege.entity;

import by.itcollege.configuration.DaoConfig;
import by.itcollege.dao.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DaoConfig.class)

public class TestProductRepository {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findProductById() {
        Optional<Product> product = productRepository.findProductById(1L);
        System.out.println(product.get());
    }
}




