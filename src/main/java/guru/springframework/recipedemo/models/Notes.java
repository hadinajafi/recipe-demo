package guru.springframework.recipedemo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;

    public Notes() {}

    public Notes(String note, Recipe recipe){
        this.recipeNote = note;
        this.recipe = recipe;
    }

}
