package tn.esprit.backend_pi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.Pet;
import tn.esprit.backend_pi.repository.PetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PetServiceImpl implements IPetService{
    @Autowired
    PetRepository petRepository ;
    public List<Pet> retrieveAllPets(){
        return petRepository.findAll();
    };
    public Pet retrievePet(Long idPet){
        return petRepository.findById(idPet).get() ;
    };
    public Pet addPet(Pet p){
        return petRepository.save(p) ;
    };
    public void removePet(Long idPet){
        petRepository.deleteById(idPet);
    };
    public Pet modifyPet(Pet pet){
        return petRepository.save(pet) ;
    };
}
