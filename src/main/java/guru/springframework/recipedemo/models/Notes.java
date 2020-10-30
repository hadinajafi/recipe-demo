package guru.springframework.recipedemo.models;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNote() {
        return recipeNote;
    }

    public void setRecipeNote(String recipeNote) {
        this.recipeNote = recipeNote;
    }
}
