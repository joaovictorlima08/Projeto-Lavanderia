package br.edu.fiec.lavanderia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {

    private Integer id;

    private String nome;

    private Integer quantidadeRoupas;

}
