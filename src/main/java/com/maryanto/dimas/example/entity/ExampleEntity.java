package com.maryanto.dimas.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("examples")
public class ExampleEntity implements Serializable {

    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String nama;
    @Column("age")
    private Integer umur;
    @Column("birthdate")
    private LocalDate tanggalLahir;
    @Column("balance")
    private BigDecimal saldo;
    @Column("created_date")
    private LocalDateTime createdDate;

}
