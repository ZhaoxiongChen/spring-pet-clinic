package pro.baladeur.petclinic.services.map;

import org.springframework.stereotype.Service;
import pro.baladeur.petclinic.model.Speciality;
import pro.baladeur.petclinic.model.Vet;
import pro.baladeur.petclinic.services.SpecialityService;
import pro.baladeur.petclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        // Defensive coding to avoid error caused by unknown speciality
        if (object.getSpecialities().size() > 0) {
            // Check every speciality of the vet
            object.getSpecialities().forEach(speciality -> {
                // Find a speciality that is not being persisted
                if (speciality.getId() == null) {
                    // Make sure the new speciality is saved and its ID is created
                    Speciality savedSpeciality = specialityService.save(speciality);
                    savedSpeciality.setId(speciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
