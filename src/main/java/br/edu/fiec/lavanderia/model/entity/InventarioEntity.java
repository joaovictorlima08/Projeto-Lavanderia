package br.edu.fiec.lavanderia.model.entity;

import br.edu.fiec.lavanderia.model.dto.InventarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //Gera getters e setters
@Entity // Indica que a classe representa uma tabela no banco
@NoArgsConstructor // Cria construtor vazio
@AllArgsConstructor // Cria construtor com todos os atributos
@Table(name = "inventario") // Nome da tabela no banco
public class InventarioEntity {

    @Id  //Chave primária da tabela
    @GeneratedValue // Gera o ID automaticamente
    private Long id;

    @Column(nullable = false) // Campo obrigatório
    private String marca;

    @Column(nullable = false) // Campo obrigatório
    private Integer litragem;

    @Column(nullable = false) // Campo obrigatório
    private String modelo;

    @Column(nullable = false) // Campo obrigatório
    private Double consumo;
    }