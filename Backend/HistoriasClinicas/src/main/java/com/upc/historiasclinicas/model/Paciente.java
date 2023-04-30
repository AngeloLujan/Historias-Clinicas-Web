package com.upc.historiasclinicas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombres;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private String tipoDocumento;

    private String numeroDocumento;

    private String direccion;

    private String celular;

    private String telefono;

    private String sexo;

    private String lugarNacimiento;

    private Date fechaNacimiento;

    private String estadoCivil;

    private String gradoInstruccion;

    private String ocupacion;

    private String grupoSanguineo;
}
