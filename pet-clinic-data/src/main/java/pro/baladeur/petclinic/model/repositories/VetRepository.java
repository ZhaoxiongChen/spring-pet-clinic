package pro.baladeur.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.baladeur.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
