package pro.baladeur.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.baladeur.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
