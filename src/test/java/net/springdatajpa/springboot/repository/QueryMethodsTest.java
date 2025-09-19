package net.springdatajpa.springboot.repository;

import net.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("Product 2");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("Product 2",
                "Product 5 Description");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("Product 5",
                "Product 5 Description");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDustinctByName("product 4");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(99.0));

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });

    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(99.0));

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });

    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("pro");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });

    }

    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("%pro%");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });

    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(80) , new BigDecimal(200));

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });

    }

    @Test
    void findByDateCreatedBetweenMethod() {
        LocalDateTime startDate = LocalDateTime.parse("2025-09-02T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2025-09-03T00:00:00");
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getDateCreated());
        });

    }

    @Test
    void findByNameInMethod() {
        List<Product> products = productRepository.findByNameIn(List.of("product 2","product 5"));

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }

    @Test
    void findTop2ByOrderByPriceDescMethod() {
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getPrice());
        });

    }

}
