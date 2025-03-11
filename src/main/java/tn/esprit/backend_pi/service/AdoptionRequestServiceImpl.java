package tn.esprit.backend_pi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.AdoptionRequest;
import tn.esprit.backend_pi.repository.AdoptionRequestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AdoptionRequestServiceImpl implements IAdoptionRequestService{
    @Autowired
    AdoptionRequestRepository adoptionRequestRepository ;
    public List<AdoptionRequest> retrieveAllAdoptionRequests(){
        return adoptionRequestRepository.findAll();
    };
    public AdoptionRequest retrieveAdoptionRequest(Long idAdoptionRequest){
        return adoptionRequestRepository.findById(idAdoptionRequest).get() ;
    };
    public AdoptionRequest addAdoptionRequest(AdoptionRequest b){
        return adoptionRequestRepository.save(b) ;
    };
    public void removeAdoptionRequest(Long idAdoptionRequest){
        adoptionRequestRepository.deleteById(idAdoptionRequest);
    };
    public AdoptionRequest modifyAdoptionRequest(AdoptionRequest adoptionRequest){
        return adoptionRequestRepository.save(adoptionRequest) ;
    };
}

