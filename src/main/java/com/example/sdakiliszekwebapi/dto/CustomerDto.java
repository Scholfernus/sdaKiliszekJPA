package com.example.sdakiliszekwebapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    private Long id;
    @NotBlank
    private String name;
    private String address;
}
