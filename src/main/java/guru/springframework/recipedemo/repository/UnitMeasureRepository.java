package guru.springframework.recipedemo.repository;

import guru.springframework.recipedemo.models.UnitMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitMeasureRepository extends CrudRepository<UnitMeasure, Long> {
    Optional<UnitMeasure> findByDescription(String description);
}
