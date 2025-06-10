package com.narendra.dtoandexception.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDTOupd {

    @NotNull(message = "name required")
    private String name;

    @NotNull(message = "price required")
    private double price;
}
