package tn.esprit.pi_houssem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pi_houssem.entity.Carnet;
import tn.esprit.pi_houssem.service.ICarnetService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/carnet")
public class CarnetRestController {

    ICarnetService carnetService;

    @GetMapping("/retrieve-all-carnets")
    public List<Carnet> getCarnets() {
        List<Carnet> listCarnets = carnetService.retrieveAllCarnets();
        return listCarnets;
    }

    @GetMapping("/retrieve-carnet/{carnet-id}")
    public Carnet retrieveCarnet(@PathVariable("carnet-id") Long cId) {
        Carnet carnet = carnetService.retrieveCarnet(cId);
        return carnet;
    }
    @PostMapping("/add-carnet")
        public Carnet addCarnet(@RequestBody Carnet c) {
        Carnet carnet = carnetService.addCarnet(c);
        return carnet;
    }

    @DeleteMapping("/remove-carnet/{carnet-id}")
    public void removeCarnet(@PathVariable("carnet-id") Long cId) {
        carnetService.removeCarnet(cId);
    }

    @PutMapping("/modify-carnet")
    public Carnet modifyCarnet(@RequestBody Carnet c) {
        Carnet carnet = carnetService.modifyCarnet(c);
        return carnet;
    }
}
