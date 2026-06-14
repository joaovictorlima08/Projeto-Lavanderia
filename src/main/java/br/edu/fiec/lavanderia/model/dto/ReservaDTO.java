package br.edu.fiec.lavanderia.model.dto;

import lombok.Data;

@Data //Gera getters e setters
public class ReservaDTO {

    private String cliente; // Nome do cliente

    private String telefone; // Telefone do cliente

    private String dataReserva; // Data da reserva do cliente

    private String horario; // Horário reservado do cliente

    private Long maquinaId;  // ID da máquina reservada
}
