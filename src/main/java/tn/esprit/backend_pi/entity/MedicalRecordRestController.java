package tn.esprit.pi_houssem.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pi_houssem.entity.MedicalRecord;
import tn.esprit.pi_houssem.service.IMedicalRecordService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/medicalrecord")
public class MedicalRecordRestController {
@Autowired
    IMedicalRecordService medicalRecordService;

    @GetMapping("/retrieve-all-medicalRecords")
    public List<MedicalRecord> getMedicalRecords() {
        List<MedicalRecord> medicalRecordList = medicalRecordService.retrieveAllMedicalRecords();
        return medicalRecordList;
    }

    @GetMapping("/retrieve-medicalRecord/{medicalRecord-id}")
    public MedicalRecord retrieveMedicalRecord(@PathVariable("medicalRecord") Long med) {
        MedicalRecord medicalRecord = medicalRecordService.retrieveMedicalRecord(med);
        return medicalRecord;
    }
    @PostMapping("/add-medicalRecord")
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        MedicalRecord medicalrecord = medicalRecordService.addMedicalRecord(medicalRecord);
        return medicalrecord;
    }

    @DeleteMapping("/remove-medicalRecord/{medicalRecord-id}")
    public void removeMedicalRecord(@PathVariable("medicalRecord-id") Long cId) {
        medicalRecordService.removeMedicalRecord(cId);
    }

    @PutMapping("/modify-medicalRecord")
    public MedicalRecord modifyMedicalRecord(@RequestBody MedicalRecord md) {
        MedicalRecord medicalrecord = medicalRecordService.modifyMedicalRecord(md);
        return medicalrecord;
    }

}
