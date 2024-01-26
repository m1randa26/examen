package com.example.examenisaac.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonaDto {

    private Integer id_persona;

    private String nombre;

    private String primerApellido;

    private String segundoApellido;

    private String fechaNacimiento;

    private String estadoNacimiento;

    private String sexo;

    private String curp;
}
