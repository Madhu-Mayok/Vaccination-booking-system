package com.example.VaccinationBookingSystem.dto.ResonseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPersonResponseDto {
    String name;
    String message;
}
