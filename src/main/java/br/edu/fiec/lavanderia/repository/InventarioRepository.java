package br.edu.fiec.lavanderia.repository;

import br.edu.fiec.lavanderia.model.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {

    List<InventarioEntity> findByMarca(String marca); // Busca por marca

    List<InventarioEntity> findByModelo(String modelo); // Busca por modelo

    List<InventarioEntity> findByLitragem(Integer litragem); // Busca por litragem

}
