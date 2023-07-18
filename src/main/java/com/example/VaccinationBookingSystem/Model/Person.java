package com.example.VaccinationBookingSystem.Model;

import com.example.VaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


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
}
