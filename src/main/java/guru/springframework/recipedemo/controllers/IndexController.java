package guru.springframework.recipedemo.controllers;

import guru.springframework.recipedemo.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController{

    RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndex(Model model){
        log.debug("getting index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
