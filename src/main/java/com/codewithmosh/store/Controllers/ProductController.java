package com.codewithmosh.store.Controllers;

import com.codewithmosh.store.Mapper.ProductMapper;
import com.codewithmosh.store.details.ProductDto;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repositories.ProductRepository;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper; // Injected by Spring

    @GetMapping
    public List<ProductDto> getAllProducts(@RequestParam(required = false,name="categoryId") Byte categoryId) {
        List<Product> products = (categoryId!=null)?
                productRepository.findByCategoryId(categoryId):
                productRepository.findAllWithCategory();
        return products.stream().map(productMapper::toDto).toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}