package com.example.VaccinationBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.VaccinationBookingSystem.Model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
