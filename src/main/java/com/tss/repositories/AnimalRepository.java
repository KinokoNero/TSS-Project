package com.tss.repositories;

import com.tss.entities.Animal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query(value="select 'Carnivore' as animalDiet, count(animals.id) as dietCount from Animal as animals where diet='Carnivore'"
            + " union all "
            + "select 'Herbivore', count(animals.id) from Animal as animals where diet='Herbivore'"
            + " union all "
            + "select 'Omnivore', count(animals.id) from Animal as animals where diet='Omnivore'", nativeQuery = true
    )
    List<IAnimalReport> getAnimalsDietStats();
}
