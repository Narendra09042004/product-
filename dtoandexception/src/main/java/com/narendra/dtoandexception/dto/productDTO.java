package com.narendra.dtoandexception.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDTO {
    @NotNull(message = "id required")
    private int id;

    @NotNull(message = "Name required")
    private String name;
}
