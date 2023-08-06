package com.example.VaccinationBookingSystem.dto.RequestDto;

import com.example.VaccinationBookingSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPersonRequestDto {

String name;

int age;

String email;

Gender gender;
}
