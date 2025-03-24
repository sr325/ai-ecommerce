package aiecommerce.repository;

import aiecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{ " +
            "'variants.size.sizeName': ?1, " +
            "'price': { $lte: ?2 }" +
            "}")
    List<Product> findByFilters(String size, BigDecimal maxPrice);

}