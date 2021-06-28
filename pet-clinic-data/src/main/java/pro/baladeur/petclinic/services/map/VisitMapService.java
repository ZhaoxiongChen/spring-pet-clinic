package pro.baladeur.petclinic.services.map;

import org.springframework.stereotype.Service;
import pro.baladeur.petclinic.model.Visit;
import pro.baladeur.petclinic.services.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        // Defensive coding
        if (visit.getPet() == null // Every visit must has a pet
                || visit.getPet().getOwner() == null // Pet must has a owner
                || visit.getPet().getId() == null // Pet cannot be empty
                || visit.getPet().getOwner().getId() == null) { // Pet must has a owner
            // Make component of a visit is valid
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
