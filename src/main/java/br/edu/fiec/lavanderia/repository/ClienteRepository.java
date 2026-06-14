package br.edu.fiec.lavanderia.repository;

import br.edu.fiec.lavanderia.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByQuantidadeRoupas(Integer quantidadeRoupas); // Corrigido para Integer

    List<Cliente> findAllByNome(String nome);
}
