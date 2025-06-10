package com.narendra.dtoandexception.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDTOins {
    @NotNull(message = "id required")
    @Min(value = 1,message = "id value >  0")
    private int id;

    @NotNull(message = "Name required")
    private String name;

    @NotNull(message = "price not be null")
    @Range(min = 0,max = 1000,message = "price between 0-1000")
    private double price;
}
