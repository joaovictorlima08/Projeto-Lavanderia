package br.edu.fiec.lavanderia.repository;

import br.edu.fiec.lavanderia.model.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    List<ReservaEntity> findByCliente(String cliente); // Busca reservas pelo nome do cliente

    List<ReservaEntity> findByTelefone(String telefone); // Busca reservas pelo telefone

    List<ReservaEntity> findByMaquinaId(Long maquinaId); // Busca reservas pelo ID da máquina

    List<ReservaEntity> findByDataReserva(String dataReserva); // Busca reservas pela data da reserva

}