package pro.baladeur.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.baladeur.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
