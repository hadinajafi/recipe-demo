package guru.springframework.recipedemo.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private String description;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitMeasure unitOfMeasure;

    public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitMeasure unitMeasure, Recipe recipe) {
        this.description = description;
        this.unitOfMeasure = unitMeasure;
        this.amount = amount;
        this.recipe = recipe;
    }

}
