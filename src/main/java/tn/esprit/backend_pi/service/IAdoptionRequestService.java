package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.AdoptionRequest;

import java.util.List;

public interface IAdoptionRequestService {
    public List<AdoptionRequest> retrieveAllAdoptionRequests();
    public AdoptionRequest retrieveAdoptionRequest(Long idAdoptionRequest);
    public AdoptionRequest addAdoptionRequest(AdoptionRequest b);
    public void removeAdoptionRequest(Long idAdoptionRequest);
    public AdoptionRequest modifyAdoptionRequest(AdoptionRequest adoptionRequest);
}
