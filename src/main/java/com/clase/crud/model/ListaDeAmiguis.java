package com.clase.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ListaDeAmiguis {
    private Long id;
    private String nombre;
    private String apellido;

}
