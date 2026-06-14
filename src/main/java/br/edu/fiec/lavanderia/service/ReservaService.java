package br.edu.fiec.lavanderia.service;

import br.edu.fiec.lavanderia.model.dto.ReservaDTO;
import br.edu.fiec.lavanderia.model.entity.ReservaEntity;
import br.edu.fiec.lavanderia.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Define a classe como camada de serviço (regras de negócio)
@AllArgsConstructor // Cria construtor com todos os atributos
public class ReservaService {

    private ReservaRepository reservaRepository;

    //Criação de Reservas
    public void criarReserva(ReservaDTO dto){

        ReservaEntity reserva = new ReservaEntity();
        reserva.setCliente(dto.getCliente()); // Define o nome do cliente
        reserva.setTelefone(dto.getTelefone()); // Define o numero do cliente
        reserva.setDataReserva(dto.getDataReserva()); // Define a data da rreserva
        reserva.setHorario(dto.getHorario()); // Define o horário da reserva
        reserva.setMaquinaId(dto.getMaquinaId()); // Define a maquina reservada
        reservaRepository.save(reserva);
    }

    //Listar Todas as Reservas
    public List<ReservaEntity> listarReservas(){
        return reservaRepository.findAll();
    }

    //Listar as Reservas por Id
    public ReservaEntity buscarPorId(Long id){
        return reservaRepository.findById(id).orElse(null);
    }

    //Alterações de Reservas
    public void atualizarReserva(Long id, ReservaDTO dto){

        ReservaEntity reserva =
                reservaRepository.findById(id).orElse(null);

        if(reserva != null){
            reserva.setCliente(dto.getCliente());
            reserva.setTelefone(dto.getTelefone());
            reserva.setDataReserva(dto.getDataReserva());
            reserva.setHorario(dto.getHorario());
            reserva.setMaquinaId(dto.getMaquinaId());
            reservaRepository.save(reserva);
        }
    }

    //Deletar Reservas
    public void deletarReserva(Long id){
        reservaRepository.deleteById(id);
    }
}