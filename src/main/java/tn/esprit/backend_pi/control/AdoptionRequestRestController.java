package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.AdoptionRequest;
import tn.esprit.backend_pi.service.IAdoptionRequestService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/adoptionRequest")
public class AdoptionRequestRestController {
    @Autowired
    IAdoptionRequestService adoptionRequestService ;

    // http://localhost:8089/Backend/api/adoptionRequest/retrieve-all-adoptionRequests
    @GetMapping("/retrieve-all-adoptionRequests")
    public List<AdoptionRequest> getAdoptionRequests(){
        return adoptionRequestService.retrieveAllAdoptionRequests();
    }


    @GetMapping("/retrieve-adoptionRequest/{adoptionRequest-id}")
    public AdoptionRequest retrieveAdoptionRequest(@PathVariable("adoptionRequest-id") Long idAdoptionRequest){
        return adoptionRequestService.retrieveAdoptionRequest(idAdoptionRequest) ;
    }

    @PostMapping("/add-adoptionRequest")
    public AdoptionRequest addAdoptionRequest(@RequestBody AdoptionRequest adoptionRequest){
        System.out.println("Received AdoptionRequest: " + adoptionRequest);  // Log the received adoptionRequest

        return adoptionRequestService.addAdoptionRequest(adoptionRequest) ;
    }

    @DeleteMapping("/delete-adoptionRequest/{adoptionRequest-id}")
    public void removeAdoptionRequest(@PathVariable("adoptionRequest-id") Long idAdoptionRequest){
        adoptionRequestService.removeAdoptionRequest(idAdoptionRequest);
    }

    @PutMapping("/modify-adoptionRequest")
    public AdoptionRequest modifyAdoptionRequest(@RequestBody AdoptionRequest adoptionRequest){
        return adoptionRequestService.modifyAdoptionRequest(adoptionRequest) ;
    }
}
