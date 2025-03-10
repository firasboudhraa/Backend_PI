package tn.esprit.backend_pi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.PetService;
import tn.esprit.backend_pi.repository.ServiceRepository;

import java.util.List;

@Service
public class PetServiceImpl implements IPetService{
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<PetService> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public PetService getServiceById(Long id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public PetService createService(PetService service) {
        return serviceRepository.save(service);
    }

    @Override
    public PetService updateService( PetService service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
