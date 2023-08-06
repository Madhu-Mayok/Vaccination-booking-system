package com.example.VaccinationBookingSystem.Model;

import com.example.VaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true,nullable = false)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean dose1Taken;

//    public boolean isDose1Taken() {   // getter function of boolean doesnt start with get it will start with "is"
//        return dose1Taken;
//    }
//
//    public void setDose1Taken(boolean dose1Taken) {
//        this.dose1Taken = dose1Taken;
//    }
//
//    public boolean isDose2Taken() {
//        return dose2Taken;
//    }
//
//    public void setDose2Taken(boolean dose2Taken) {
//        this.dose2Taken = dose2Taken;
//    }

    boolean dose2Taken;


    @OneToMany(mappedBy ="person",cascade=CascadeType.ALL)
    List<Dose> dosesTaken = new ArrayList<>();

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    Certificate certificate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>();
}
