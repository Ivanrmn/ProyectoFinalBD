package org.mvpigs.proyectoFinalBD.repository;

import org.mvpigs.proyectoFinalBD.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByDescription(String description);
    List<Product> findByName(String name);
    List<Product> findByPrice(Double price);

    Product findOne(Long id);
}
