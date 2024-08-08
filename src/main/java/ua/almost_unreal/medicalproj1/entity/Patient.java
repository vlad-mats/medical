package ua.almost_unreal.medicalproj1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "patient_name")
    private String patient_name ;

    @Column(name = "height")
    int height ;

    @Column(name = "weight")
    int weight;

    @Column(name = "special_patient_id")
    int special_patient_id;

    @Column(name = "patient_info")
    String patient_info;
}
