package pro.baladeur.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.baladeur.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
