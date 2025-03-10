package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Pet;
import tn.esprit.backend_pi.service.IPetService;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/api/pet")
public class PetRestController {
    @Autowired
    IPetService petService ;

    @GetMapping("/retrieve-all-pets")
    public List<Pet> getPets(){
        return petService.retrieveAllPets();
    }


    @GetMapping("/retrieve-pet/{pet-id}")
    public Pet retrievePet(@PathVariable("pet-id") Long idPet){
        return petService.retrievePet(idPet) ;
    }

    @PostMapping("/add-pet")
    public Pet addPet(@RequestBody Pet pet){
        return petService.addPet(pet) ;
    }

    @DeleteMapping("/delete-pet/{pet-id}")
    public void removePet(@PathVariable("pet-id") Long idPet){
        petService.removePet(idPet);
    }

    @PutMapping("/modify-pet")
    public Pet modifyPet(@RequestBody Pet pet){
        return petService.modifyPet(pet) ;
    }
}
