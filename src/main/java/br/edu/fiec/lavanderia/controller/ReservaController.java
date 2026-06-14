package br.edu.fiec.lavanderia.controller;

import br.edu.fiec.lavanderia.model.dto.ReservaDTO;
import br.edu.fiec.lavanderia.model.entity.ReservaEntity;
import br.edu.fiec.lavanderia.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController // Define a classe como Controller
@AllArgsConstructor // Gera construtor automaticamente
@RequestMapping("reservas") // Rota base da API
public class ReservaController {

    private ReservaService reservaService;

    //Criação de Reserva
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/reserva", consumes = APPLICATION_JSON_VALUE)
    public void criarReserva(@RequestBody ReservaDTO reservaDTO){
        reservaService.criarReserva(reservaDTO);
    }

    //Retorna todas as Reservas
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ReservaEntity> listarReservas(){
        return reservaService.listarReservas();
    }

    //Retorna Reservas por ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ReservaEntity buscarPorId(@RequestParam Long id){
        return reservaService.buscarPorId(id);
    }

    //Alteração de Reservas por ID
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void atualizarReserva(@RequestParam Long id, @RequestBody ReservaDTO dto){
        reservaService.atualizarReserva(id, dto);
    }

    //Deleção de Reserva
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}",consumes = APPLICATION_JSON_VALUE)
    public void deletarReserva(@RequestParam Long id){
        reservaService.deletarReserva(id);
    }
}
