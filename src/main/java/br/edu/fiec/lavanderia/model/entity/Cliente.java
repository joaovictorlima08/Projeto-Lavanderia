package br.edu.fiec.lavanderia.model.entity;

import br.edu.fiec.lavanderia.model.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer quantidadeRoupas;

    public Cliente(String id, ClienteDTO clienteDTO){
        setId(Integer.valueOf(id));
        setQuantidadeRoupas(clienteDTO.getQuantidadeRoupas());
        setNome(clienteDTO.getNome());
    }

    public void setQuantidadeRoupas(Integer quantidadeRoupas) {
    }
}
