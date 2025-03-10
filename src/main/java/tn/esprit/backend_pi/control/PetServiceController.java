package tn.esprit.backend_pi.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.PetService;
import tn.esprit.backend_pi.service.IPetService;

import java.util.List;

@RestController
@RequestMapping("/api/petServices")
public class PetServiceController {

    @Autowired
    private IPetService petService;

    // GET: Retrieve all PetServices
    @GetMapping("/retrieve-all-services")
    public List<PetService> getAllPetServices() {
        return petService.getAllServices();
    }

    // GET: Retrieve a PetService by ID
    @GetMapping("/retrieve-service/{id}")
    public PetService getPetServiceById(@PathVariable("id") Long id) {
        return petService.getServiceById(id);
    }

    @PostMapping("/add-service")
    public PetService addPetService(@RequestBody PetService petServiceRequest) {
        PetService newPetService = petService.createService(petServiceRequest);
        return newPetService;
    }

    @DeleteMapping("/remove-service/{id}")
    public void removePetService(@PathVariable("id") Long id) {
        petService.deleteService(id);
    }

    @PutMapping("/modify-service")
    public PetService modifyPetService(@RequestBody PetService p) {
        return petService.updateService(p);
    }
}
