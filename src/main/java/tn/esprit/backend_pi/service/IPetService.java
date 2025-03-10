package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.PetService;

import java.util.List;

public interface IPetService {
    List<PetService> getAllServices();
    PetService getServiceById(Long id);
    PetService createService(PetService service);
    PetService updateService(PetService service);
    void deleteService(Long id);
}
