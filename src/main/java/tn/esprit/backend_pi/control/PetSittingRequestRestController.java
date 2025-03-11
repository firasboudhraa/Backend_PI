package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.PetSittingRequest;
import tn.esprit.backend_pi.service.IPetSittingRequestService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/petSittingRequest")
public class PetSittingRequestRestController {
    @Autowired
    IPetSittingRequestService petSittingRequestService ;

    // http://localhost:8089/Backend/api/petSittingRequest/retrieve-all-petSittingRequests
    @GetMapping("/retrieve-all-petSittingRequests")
    public List<PetSittingRequest> getPetSittingRequests(){
        return petSittingRequestService.retrieveAllPetSittingRequests();
    }


    @GetMapping("/retrieve-petSittingRequest/{petSittingRequest-id}")
    public PetSittingRequest retrievePetSittingRequest(@PathVariable("petSittingRequest-id") Long idPetSittingRequest){
        return petSittingRequestService.retrievePetSittingRequest(idPetSittingRequest) ;
    }

    @PostMapping("/add-petSittingRequest")
    public PetSittingRequest addPetSittingRequest(@RequestBody PetSittingRequest petSittingRequest){
        System.out.println("Received PetSittingRequest: " + petSittingRequest);  // Log the received petSittingRequest

        return petSittingRequestService.addPetSittingRequest(petSittingRequest) ;
    }

    @DeleteMapping("/delete-petSittingRequest/{petSittingRequest-id}")
    public void removePetSittingRequest(@PathVariable("petSittingRequest-id") Long idPetSittingRequest){
        petSittingRequestService.removePetSittingRequest(idPetSittingRequest);
    }

    @PutMapping("/modify-petSittingRequest")
    public PetSittingRequest modifyPetSittingRequest(@RequestBody PetSittingRequest petSittingRequest){
        return petSittingRequestService.modifyPetSittingRequest(petSittingRequest) ;
    }
}
