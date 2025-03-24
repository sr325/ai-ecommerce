package aiecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Category category;
    private BigDecimal price;
    private int stockQuantity;
    private String imageUrl;
    private List<ProductVariant> variants;

    // Embedded Category
    @Data
    public static class Category {
        private String id;
        private String name;
        private String description;
    }

    // Embedded Size
    @Data
    public static class Size {
        private String id;
        private String sizeName;
    }

    // Embedded Color
    @Data
    public static class Color {
        private String id;
        private String colorName;
        private String hexCode;
    }

    // Embedded Product Variant
    @Data
    public static class ProductVariant {
        private String id;
        private Size size;
        private Color color;
        private int stockQuantity;
    }

    // Referenced Pants
    @DBRef
    private List<Pants> pants;
}
