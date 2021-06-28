package pro.baladeur.petclinic.services.map;

import org.springframework.stereotype.Service;
import pro.baladeur.petclinic.model.Owner;
import pro.baladeur.petclinic.model.Pet;
import pro.baladeur.petclinic.model.PetType;
import pro.baladeur.petclinic.services.OwnerService;
import pro.baladeur.petclinic.services.PetService;
import pro.baladeur.petclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        // Make sure that Owner is not null
        if (object != null) {
            // If the Owner has pets
            if (object.getPets() != null) {
                // Iterate each pet
                object.getPets().forEach(pet -> {
                    // Solving issue: unknown petType
                    if (pet.getPetType() != null) {
                        // If PetType ID is null, current pet type has not been saved to the map yet
                        // Need to save the newPetType to the map
                        if (pet.getPetType().getId() == null) {
                            PetType newPetType = petTypeService.save(pet.getPetType());
                            pet.setPetType(newPetType);
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    // Solving issue: unsaved pet
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            // Finally save the Owner with Published Id properties
            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
