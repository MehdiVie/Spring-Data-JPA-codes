package net.springdatajpa.springboot.repository;

import net.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("Product Test");
        product.setDescription("Product Test Description");
        product.setSku("ABC");
        product.setPrice(new BigDecimal(90));
        product.setActive(true);
        product.setImageUrl("p-test.png");

        // save product
        Product savedProduct = productRepository.save(product);

        // show saved product
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // find and retrieve product by id
        Long id = 1L;
        Product updatedProduct = productRepository.findById(id).get();
        // update product
        updatedProduct.setName("Product Test Updated");
        updatedProduct.setDescription("Product Updated Description");
        // save updated product to database
        productRepository.save(updatedProduct);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(1L).get();
    }

    @Test
    void saveAllMethod() {
        Product product2 = new Product();
        product2.setName("2-Product Test");
        product2.setDescription("Product Test Description");
        product2.setSku("ABC");
        product2.setPrice(new BigDecimal(90));
        product2.setActive(true);
        product2.setImageUrl("p2-test.png");

        Product product3 = new Product();
        product3.setName("3-Product Test");
        product3.setDescription("3-Product Test Description");
        product3.setSku("ABC");
        product3.setPrice(new BigDecimal(90));
        product3.setActive(true);
        product3.setImageUrl("p3-test.png");

        productRepository.saveAll(List.of(product2,product3));

    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id=1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleMethod() {
        Long id = 3L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

}