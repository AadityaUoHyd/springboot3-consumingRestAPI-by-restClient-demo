package org.aadi.productcrudapi.service;

import lombok.RequiredArgsConstructor;
import org.aadi.productcrudapi.entity.Product;
import org.aadi.productcrudapi.errors.ResourceNotFoundException;
import org.aadi.productcrudapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findOneProducts(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String deleteProducts(long id) {
        productRepository.deleteById(id);
        return "Product successfully deleted.";
    }

    @Override
    public Product updateProducts(long id, Product product) {
        Optional<Product> productDb = this.productRepository.findById(product.getId());
        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setPrice(product.getPrice());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }

    }
}