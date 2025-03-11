package tn.esprit.pi_houssem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.pi_houssem.entity.Carnet;
import tn.esprit.pi_houssem.repository.CarnetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CarnetServiceImp implements ICarnetService {
    public CarnetRepository carnetRepository;
    @Override
    public List<Carnet> retrieveAllCarnets() {
        return carnetRepository.findAll();
    }
    @Override

    public Carnet retrieveCarnet(Long cId) {
        return carnetRepository.findById(cId).get();
    }
    @Override
    public Carnet addCarnet(Carnet c) {
        return carnetRepository.save(c);
    }
    @Override
    public void removeCarnet(Long cId) {
        carnetRepository.deleteById(cId);
    }
    @Override
    public Carnet modifyCarnet(Carnet carnet) {
        return carnetRepository.save(carnet);
    }
}
