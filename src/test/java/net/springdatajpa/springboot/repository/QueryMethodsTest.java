package net.springdatajpa.springboot.repository;

import net.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private  ProductRepository productRepository;

    @Test
    void findByNameMethod() {

        Product product = productRepository.findByName("Product 2");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
}
