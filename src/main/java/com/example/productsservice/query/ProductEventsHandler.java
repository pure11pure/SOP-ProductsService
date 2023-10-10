package com.example.productsservice.query;

import com.example.productsservice.core.data.ProductEntity;
import com.example.productsservice.core.data.ProductRepository;
import com.example.productsservice.core.events.ProductCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    public  ProductEventsHandler(ProductRepository productRepository){
        this.productRepository  = productRepository;
    }

    @EventHandler //listen
    public void on(ProductCreateEvent event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }
}
