package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Pet;

import java.util.List;

public interface IPetService {
    public List<Pet> retrieveAllPets();
    public Pet retrievePet(Long idPet);
    public Pet addPet(Pet p);
    public void removePet(Long idPet);
    public Pet modifyPet(Pet pet);

}
