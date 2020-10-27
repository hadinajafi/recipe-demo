package guru.springframework.recipedemo.repository;

import guru.springframework.recipedemo.models.UnitMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitMeasureRepository extends CrudRepository<UnitMeasure, Long> {
}
