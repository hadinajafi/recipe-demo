package guru.springframework.recipedemo.repository;

import guru.springframework.recipedemo.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
