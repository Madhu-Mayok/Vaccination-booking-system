package com.example.VaccinationBookingSystem.dto.ResonseDto;

import com.example.VaccinationBookingSystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterResponseDto {

    String centerName;

    CenterType centerType;

    String address;
}