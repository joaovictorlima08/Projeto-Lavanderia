package br.edu.fiec.lavanderia.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDTO {

    private String marca;

    private Integer litragem;

    private String modelo;

    private Double consumo;
}
