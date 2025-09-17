package net.springdatajpa.springboot.repository;

import net.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
