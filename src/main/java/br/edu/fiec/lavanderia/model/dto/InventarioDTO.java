package br.edu.fiec.lavanderia.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera getters e setters
@NoArgsConstructor // Cria construtor vazio
@AllArgsConstructor // Cria construtor com todos os atributos
public class InventarioDTO {

    private String marca; // Marca da máquina

    private Integer litragem; // Capacidade em litros

    private String modelo;  // Modelo da máquina

    private Double consumo; // Consumo de água e energia
}
