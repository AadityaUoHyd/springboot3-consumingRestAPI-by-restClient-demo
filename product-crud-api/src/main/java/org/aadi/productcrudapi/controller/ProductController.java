package org.aadi.productcrudapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aadi.productcrudapi.entity.Product;
import org.aadi.productcrudapi.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findOneProduct(@PathVariable("id") long id){
        return ResponseEntity.ok().body(productService.findOneProducts(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable("id") long id, @RequestBody Product product){
        return ResponseEntity.ok().body(productService.updateProducts(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        return ResponseEntity.ok().body(productService.deleteProducts(id));
    }
}