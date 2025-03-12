package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Donation;
import tn.esprit.backend_pi.service.IDonationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/donation")
public class DonationRestController {
    @Autowired
    IDonationService donationService;
    // http://localhost:8089/Backend/donation/retrieve-all-donations
    @GetMapping("/retrieve-all-donations")
    public List<Donation> getdonations() {
        List<Donation> listdonations = donationService.retrieveAllDonations();
        return listdonations;
    }
    // http://localhost:8089/Backend/donation/retrieve-donation/1
    @GetMapping("/retrieve-donation/{donation-id}")
    public Donation retrievedonation(@PathVariable("donation-id") Long dId) {
        Donation donation = donationService.retrieveDonation(dId);
        return donation;
    }
    // http://localhost:8089/Backend/donation/add-donation
    @PostMapping("/add-donation")
    public Donation adddonation(@RequestBody Donation d) {
        Donation donation = donationService.addDonation(d);
        return donation;
    }
    // http://localhost:8089/Backend/donation/remove-donation/{donation-id}
    @DeleteMapping("/remove-donation/{donation-id}")
    public void removedonation(@PathVariable("donation-id") Long dId) {
        donationService.removeDonation(dId);
    }
    // http://localhost:8089/Backend/donation/modify-donation
    @PutMapping("/modify-donation")
    public Donation modifydonation(@RequestBody Donation d) {
        Donation donation = donationService.modifyDonation(d);
        return donation;
    }

}