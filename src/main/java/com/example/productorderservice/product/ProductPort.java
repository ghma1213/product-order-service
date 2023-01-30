package com.example.productorderservice.product;

import org.springframework.stereotype.Service;

interface ProductPort {
    void save(Product product);
}
