package br.edu.fiec.lavanderia.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //Gera getters e setters
@Entity // Indica que a classe representa uma tabela no banco
@NoArgsConstructor // Cria construtor vazio
@AllArgsConstructor // Cria construtor com todos os atributos
@Table(name = "reserva") // Nome da tabela no banco
public class ReservaEntity {

    @Id //Chave primária da tabela
    @GeneratedValue // Gera o ID automaticamente
    private Long id;

    @Column(nullable = false) //Campo obrigatório
    private String cliente;

    @Column(nullable = false) //Campo obrigatório
    private String telefone;

    @Column(nullable = false) //Campo obrigatório
    private String dataReserva;

    @Column(nullable = false) //Campo obrigatório
    private String horario;

    @Column(nullable = false) //Campo obrigatório
    private Long maquinaId;
}
