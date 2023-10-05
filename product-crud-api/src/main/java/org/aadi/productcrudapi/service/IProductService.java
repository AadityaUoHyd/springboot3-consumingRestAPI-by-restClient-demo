package org.aadi.productcrudapi.service;

import org.aadi.productcrudapi.entity.Product;

import java.util.List;

public interface IProductService {

    public Product saveProduct(Product product);

    List<Product> getProducts();

    Product findOneProducts(long id);

    String deleteProducts(long id);

    Product updateProducts(long id, Product product);
}
