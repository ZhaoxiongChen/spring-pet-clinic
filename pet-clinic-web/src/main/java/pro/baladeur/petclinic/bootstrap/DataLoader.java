package pro.baladeur.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.baladeur.petclinic.model.*;
import pro.baladeur.petclinic.services.OwnerService;
import pro.baladeur.petclinic.services.SpecialityService;
import pro.baladeur.petclinic.services.VetService;
import pro.baladeur.petclinic.services.PetTypeService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            // Load data when the pet type is empty
            loadData();
        }
    }

    private void loadData() {
        /* Owners */
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

        /* Vets */
        // Create 3 types of specialities
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        // Generate 2 vets
        Vet v1 = new Vet();
        v1.setFirstName("Nikolai");
        v1.setLastName("Kuznetsov");
        v1.getSpecialities().add(savedRadiology);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("William");
        v2.setLastName("Halsey");
        v2.getSpecialities().add(savedSurgery);

        vetService.save(v2);

        System.out.println("Vets loaded");
    }
}
