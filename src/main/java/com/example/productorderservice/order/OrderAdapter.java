package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import com.example.productorderservice.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private ProductRepository productRepository;
    private OrderRepository orderRepository;


    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 없습니다."));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
