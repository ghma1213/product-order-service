package com.example.productorderservice.product;


interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}
