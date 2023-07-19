package org.stackroute.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.stackroute.model.Product;
import org.stackroute.repository.ProductRepository;

import java.util.List;

//annotate class with @ApplicationScoped
@ApplicationScoped
public class ProductService {
    //inject ProductRepository
    @Inject
    ProductRepository productRepository;

    //implement getAllProducts method
    public List<Product> getAllProducts() {
        return productRepository.listAll();
    }

    //implement getProductById method
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    //implement addProduct method
    @Transactional
    public Product addProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    //implement updateProduct method by id
    @Transactional
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            // No need to call persist() as the entity is already managed.
        }
        return product;
    }
//    @Transactional
//    public Product updateProduct(Product updatedProduct) {
//        Product product = productRepository.findById(updatedProduct.getId());
//        if (product != null) {
//            product.setName(updatedProduct.getName());
//            product.setPrice(updatedProduct.getPrice());
//            // No need to call persist() as the entity is already managed.
//        }
//        return product;
//    }

    //implement deleteProduct method
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
