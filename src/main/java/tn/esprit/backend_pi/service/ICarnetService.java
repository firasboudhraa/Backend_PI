package tn.esprit.pi_houssem.service;

import tn.esprit.pi_houssem.entity.Carnet;
import tn.esprit.pi_houssem.repository.CarnetRepository;

import java.util.List;

public interface ICarnetService {
    public List<Carnet> retrieveAllCarnets();
    public Carnet retrieveCarnet(Long carnetId);
    public Carnet addCarnet(Carnet c);
    public void removeCarnet(Long carnetId);
    public Carnet modifyCarnet(Carnet carnet);
}
