package org.aadi.restClient.client;

import org.aadi.restClient.dto.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductServiceClient {

    private final RestClient restClient;

    public ProductServiceClient() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:9090")
                .build();
    }

    public Product saveNewProduct(Product product) {
        return restClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }


    public List<Product> getAllProducts(){
        return restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>(){});
    }

    public Product getProduct(long id){
        return restClient.get()
                .uri("/products/find/{id}",id)
                .retrieve()
                .body(Product.class);
    }


    public Product updateProduct(long id,Product product){
     return restClient.put()
             .uri("/products/update/{id}",id)
             .contentType(MediaType.APPLICATION_JSON)
             .body(product)
             .retrieve()
             .body(Product.class);
    }

    public String deleteProduct(long id){
        restClient.delete()
                .uri("/products/delete/{id}",id)
                .retrieve()
                .toBodilessEntity();
        return "product removed : "+id;
    }

}