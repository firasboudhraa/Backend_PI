package tn.esprit.pi_houssem.service;

import tn.esprit.pi_houssem.entity.MedicalRecord;

import java.util.List;

public interface IMedicalRecordService {

    public List<MedicalRecord> retrieveAllMedicalRecords();


    public MedicalRecord retrieveMedicalRecord(Long cId);

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) ;

    public void removeMedicalRecord(Long cId);

    public MedicalRecord modifyMedicalRecord(MedicalRecord medicalRecord) ;
}
