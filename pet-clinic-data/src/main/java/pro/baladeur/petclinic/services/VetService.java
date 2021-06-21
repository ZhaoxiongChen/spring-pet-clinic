package pro.baladeur.petclinic.services;

import pro.baladeur.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);

}
