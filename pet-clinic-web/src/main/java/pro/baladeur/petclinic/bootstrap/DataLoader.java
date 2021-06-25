package pro.baladeur.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.baladeur.petclinic.model.Owner;
import pro.baladeur.petclinic.model.Pet;
import pro.baladeur.petclinic.model.PetType;
import pro.baladeur.petclinic.model.Vet;
import pro.baladeur.petclinic.services.OwnerService;
import pro.baladeur.petclinic.services.VetService;
import pro.baladeur.petclinic.services.PetTypeService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Generate 2 pet types: dog and cat
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        // Generate 2 owners
        Owner o1 = new Owner();
        o1.setFirstName("Andrew");
        o1.setLastName("Cunningham");
        o1.setAddress("221B Baker Street");
        o1.setCity("London");
        o1.setTelephone("1234567891");

        Pet p1 = new Pet();
        p1.setPetType(savedDogPetType);
        p1.setOwner(o1);
        p1.setBirthDate(LocalDate.now());
        p1.setName("Vijay");
        o1.getPets().add(p1);

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Gunther");
        o2.setLastName("Lutjens");
        o1.setAddress("177A Hans Strasse");
        o1.setCity("Berlin");
        o1.setTelephone("1234567892");

        Pet p2 = new Pet();
        p2.setPetType(savedCatPetType);
        p2.setOwner(o2);
        p2.setBirthDate(LocalDate.now());
        p2.setName("Vishnu");
        o2.getPets().add(p2);

        ownerService.save(o2);

        System.out.println("Owners loaded");

        // Generate 2 vets
        Vet v1 = new Vet();
        v1.setFirstName("Nikolai");
        v1.setLastName("Kuznetsov");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("William");
        v2.setLastName("Halsey");

        vetService.save(v2);

        System.out.println("Vets loaded");
    }
}
