package org.aadi.restClient.controller;

import org.aadi.restClient.client.ProductServiceClient;
import org.aadi.restClient.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-client/products")
public class ProductClientController {

    @Autowired
    private ProductServiceClient serviceClient;


    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        return serviceClient.saveNewProduct(product);
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return serviceClient.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return serviceClient.getProduct(id);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id,@RequestBody Product product){
        return serviceClient.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id){
        return serviceClient.deleteProduct(id);
    }

}
