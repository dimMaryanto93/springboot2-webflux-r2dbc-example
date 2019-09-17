package com.maryanto.dimas.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExampleEntity implements Serializable {

    @Id
    private String id;
    private String nama;
    private Integer umur;
    private Date tanggalLahir;
    private BigDecimal saldo;
    private Timestamp createdDate;

}
