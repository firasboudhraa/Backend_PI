package tn.esprit.backend_pi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.Donation;
import tn.esprit.backend_pi.repository.DonationRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements IDonationService{
    @Autowired
    DonationRepository DonationRepository;
    public List<Donation> retrieveAllDonations() {
        return DonationRepository.findAll();
    }
    public Donation retrieveDonation(Long donationId) {
        return DonationRepository.findById(donationId).get();
    }
    public Donation addDonation(Donation d) {
        return DonationRepository.save(d);
    }
    public void removeDonation(Long donationId) {
        DonationRepository.deleteById(donationId);
    }
    public Donation modifyDonation(Donation donation) {
        return DonationRepository.save(donation);

    }
}
