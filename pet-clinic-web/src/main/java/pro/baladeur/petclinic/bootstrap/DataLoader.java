package pro.baladeur.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.baladeur.petclinic.model.Owner;
import pro.baladeur.petclinic.model.Vet;
import pro.baladeur.petclinic.services.OwnerService;
import pro.baladeur.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate 2 owners
        Owner o1 = new Owner();
        o1.setFirstName("Yamamoto");
        o1.setLastName("Isoroku");

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Gunther");
        o2.setLastName("Lutjens");

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
