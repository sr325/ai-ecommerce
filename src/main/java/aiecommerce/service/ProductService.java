package aiecommerce.service;

import aiecommerce.model.Product;
import aiecommerce.repository.ProductRepository;
import dev.langchain4j.agent.tool.Tool;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Tool
    public Product findById(final String id) {
        log.info("Finding by id={}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found for id: " + id));
    }

    @Tool
    public List<Product> searchProducts(String size, BigDecimal maxPrice) {
        log.info("Searching for size={}, maxPrice={}", size, maxPrice);

        return productRepository.findByFilters(size, maxPrice);
    }
}
