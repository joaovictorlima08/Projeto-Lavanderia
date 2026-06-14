package br.edu.fiec.lavanderia.controller;


import br.edu.fiec.lavanderia.model.dto.InventarioDTO;
import br.edu.fiec.lavanderia.model.entity.InventarioEntity;
import br.edu.fiec.lavanderia.service.InventarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController // Define a classe como Controller
@AllArgsConstructor // Gera construtor automaticamente
@RequestMapping("inventario") // Rota base da API
public class InventarioController {

    private InventarioService inventarioService;

    //Cadastro Maquina no Inventario
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/maquina", consumes = APPLICATION_JSON_VALUE)
    public void criarInventario(@RequestBody InventarioDTO dto){inventarioService.criarInventario(dto);}

    //Retorna todas as maquinas
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE )
    public List<InventarioEntity> listarInventario(){
        return inventarioService.listarInventario();
    }

    //Retorna Maquina por ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public InventarioEntity buscarPorId(@RequestParam Long id){
        return inventarioService.buscarPorId(id);
    }

    //Alteração de Maquinas
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}",consumes = APPLICATION_JSON_VALUE)
    public void atualizarInventario(@RequestParam Long id, @RequestBody InventarioDTO dto){
        inventarioService.atualizarInventario(id, dto);
    }

    //DELETE
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void deletarInventario(@RequestParam Long id){
        inventarioService.deletarInventario(id);
    }
}
