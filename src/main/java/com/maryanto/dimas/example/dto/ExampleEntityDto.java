package com.maryanto.dimas.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExampleEntityDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {

        @NotNull
        @NotEmpty
        private String nama;
        @NotNull
        private Integer umur;
        @NotNull
        @Past
        private LocalDate tanggalLahir;
        @NotNull
        private BigDecimal saldo;
    }
}
