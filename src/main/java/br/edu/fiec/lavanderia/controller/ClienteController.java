package br.edu.fiec.lavanderia.controller;

import br.edu.fiec.lavanderia.model.dto.ClienteDTO;
import br.edu.fiec.lavanderia.model.entity.ClienteEntity;
import br.edu.fiec.lavanderia.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "clientes")
public class ClienteController {

    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED) // Status 201 para criação
    @PostMapping(value = "cliente", consumes = APPLICATION_JSON_VALUE)
    public ClienteEntity registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.registrarCliente(clienteDTO);
    }

    // Este endpoint pode ser revisado para uma abordagem mais específica,
    // como associar roupas a um cliente existente.
    // Por exemplo: POST /clientes/{clienteId}/roupas
    @ResponseStatus(HttpStatus.CREATED) // Status 201 para criação
    @PostMapping(value = "roupas", consumes = APPLICATION_JSON_VALUE)
    public void registrarRoupas(@RequestBody ClienteDTO clienteDTO) {
        clienteService.registrarRoupas(clienteDTO);
    }

    @ResponseStatus(HttpStatus.OK) // Status 200 para sucesso
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ClienteEntity> buscarTodos(){
        return clienteService.buscarTodos();
    }

    @ResponseStatus(HttpStatus.OK) // Status 200 para sucesso
    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public ClienteEntity buscarClientePorId(@PathVariable Integer id) {
        return clienteService.buscarClientePorId(id);
    }

    @ResponseStatus(HttpStatus.OK) // Status 200 para sucesso
    @GetMapping(value = "nome", produces = APPLICATION_JSON_VALUE)
    public List<ClienteEntity> buscarPorNome(@RequestParam String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @ResponseStatus(HttpStatus.OK) // Status 200 para sucesso
    @PutMapping(value = "{id}", consumes = APPLICATION_JSON_VALUE)
    public ClienteEntity atualizarCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.atualizarCliente(id, clienteDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // Status 204 para sucesso sem conteúdo
    @DeleteMapping(value = "{id}")
    public void deletarCliente(@PathVariable Integer id) {
        boolean deletado = clienteService.deletarCliente(id);
        if (!deletado) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }
}