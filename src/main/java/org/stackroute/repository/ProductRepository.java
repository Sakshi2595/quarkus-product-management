package org.stackroute.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.stackroute.model.Product;


@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product>{

    //add findbyid method
    public Product findById(Long id) {
        return find("id", id).firstResult();
    }
}
