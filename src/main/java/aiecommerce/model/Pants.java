package aiecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pants")
public class Pants {
    @Id
    private String id;
    @DBRef
    private Product product;
    private String waistSize;
    private String length;
}
