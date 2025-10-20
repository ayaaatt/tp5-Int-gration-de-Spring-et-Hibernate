package entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", uniqueConstraints =
@UniqueConstraint(name = "uk_category_name", columnNames = "name"))
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 500)
    private String description;

    // >>> "mappedBy" DOIT pointer sur le NOM EXACT du champ dans Product : "category"
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products = new ArrayList<>();

    public Category() {}
    public Category(String name) { this.name = name; }
    public Category(String name, String description) { this.name = name; this.description = description; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    // Helpers (optionnel)
    public void addProduct(Product p){
        products.add(p);
        p.setCategory(this);
    }
    public void removeProduct(Product p){
        products.remove(p);
        p.setCategory(null);
    }

}
