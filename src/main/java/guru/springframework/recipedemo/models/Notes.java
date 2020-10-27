package guru.springframework.recipedemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Notes {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Recipe recipe;
    private String recipeNote;
}
