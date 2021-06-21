package pro.baladeur.petclinic.services;

import pro.baladeur.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
