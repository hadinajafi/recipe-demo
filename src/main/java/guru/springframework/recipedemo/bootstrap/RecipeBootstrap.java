package guru.springframework.recipedemo.bootstrap;

import guru.springframework.recipedemo.models.*;
import guru.springframework.recipedemo.repository.CategoryRepository;
import guru.springframework.recipedemo.repository.RecipeRepository;
import guru.springframework.recipedemo.repository.UnitMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitMeasureRepository unitMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
                           UnitMeasureRepository unitMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitMeasureRepository = unitMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        //get Uom
        Optional<UnitMeasure> tableSpoonOptional = unitMeasureRepository.findByDescription("TableSpoon");
        if(!tableSpoonOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitMeasure> teaspoonOptional = unitMeasureRepository.findByDescription("TeaSpoon");
        if(!teaspoonOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        UnitMeasure tableUom = tableSpoonOptional.get();
        UnitMeasure teaUom = teaspoonOptional.get();


        //get category
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }

        Category americanCategory = americanCategoryOptional.get();

        //Recipe
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Best recipe ever");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(2);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirection("1. cut avocado, remove flesh" +
                "2. add salt");
        Notes guacNotes = new Notes("This is a recipe note. need to write more. it's my first note",
                guacRecipe);

        guacRecipe.setNote(guacNotes);
        guacRecipe.getCategories().add(americanCategory);

        guacRecipe.getIngredients().add(new Ingredient("this is desctiption of ingredian", new BigDecimal(2),
                tableUom, guacRecipe));

        recipes.add(guacRecipe);

        return recipes;
    }
}
