package ua.almost_unreal.medicalproj1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.almost_unreal.medicalproj1.entity.Patient;
import ua.almost_unreal.medicalproj1.repo.PatientRepo;

import java.util.List;

@Component
@Service
public class PatientDao {
    private final PatientRepo patientRepo;

    @Autowired
    public PatientDao(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }


    public List<Patient> findAllUsers() {
        return patientRepo.findAll();
    }

    public void removeUser(Patient user) {
        patientRepo.delete(user);
    }


    public Patient save(Patient user) {
        return patientRepo.save(user);
    }
    public Patient findById(long id) {
        return patientRepo.findById(id);
    }

}
