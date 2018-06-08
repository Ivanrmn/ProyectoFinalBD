package org.mvpigs.proyectoFinalBD.repository;

import org.mvpigs.proyectoFinalBD.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
