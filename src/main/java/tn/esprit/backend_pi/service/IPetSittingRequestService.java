package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.PetSittingRequest;

import java.util.List;

public interface IPetSittingRequestService {
    public List<PetSittingRequest> retrieveAllPetSittingRequests();
    public PetSittingRequest retrievePetSittingRequest(Long idPetSittingRequest);
    public PetSittingRequest addPetSittingRequest(PetSittingRequest req);
    public void removePetSittingRequest(Long idPetSittingRequest);
    public PetSittingRequest modifyPetSittingRequest(PetSittingRequest petSittingRequest);
}
