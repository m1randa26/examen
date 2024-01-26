package com.example.examenisaac.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "personas")
public class PersonaBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPerson;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column(name = "estado_nacimiento")
    private String estadoNacimiento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "curp")
    private String curp;
}
