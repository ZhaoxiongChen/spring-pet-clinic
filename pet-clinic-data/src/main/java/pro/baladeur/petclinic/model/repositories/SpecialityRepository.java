package pro.baladeur.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.baladeur.petclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
