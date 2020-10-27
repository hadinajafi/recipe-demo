package guru.springframework.recipedemo.repository;

import guru.springframework.recipedemo.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
