package tn.esprit.backend_pi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.PetSittingRequest;
import tn.esprit.backend_pi.repository.PetSittingRequestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PetSittingRequestServiceImpl implements IPetSittingRequestService{
    @Autowired
    PetSittingRequestRepository petSittingRequestRepository ;
    public List<PetSittingRequest> retrieveAllPetSittingRequests(){
        return petSittingRequestRepository.findAll();
    };
    public PetSittingRequest retrievePetSittingRequest(Long idPetSittingRequest){
        return petSittingRequestRepository.findById(idPetSittingRequest).get() ;
    };
    public PetSittingRequest addPetSittingRequest(PetSittingRequest b){
        return petSittingRequestRepository.save(b) ;
    };
    public void removePetSittingRequest(Long idPetSittingRequest){
        petSittingRequestRepository.deleteById(idPetSittingRequest);
    };
    public PetSittingRequest modifyPetSittingRequest(PetSittingRequest petSittingRequest){
        return petSittingRequestRepository.save(petSittingRequest) ;
    };
}
