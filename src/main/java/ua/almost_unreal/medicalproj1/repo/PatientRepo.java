package ua.almost_unreal.medicalproj1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.almost_unreal.medicalproj1.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    public Patient findById(long id);
}
