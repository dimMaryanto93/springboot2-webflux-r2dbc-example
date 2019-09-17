package com.maryanto.dimas.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "examples")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleEntity {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthday", nullable = false)
    private Date birthDay;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

}
