package br.edu.fiec.lavanderia.controller;


import br.edu.fiec.lavanderia.model.dto.InventarioDTO;
import br.edu.fiec.lavanderia.service.InventarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "maquinas")
public class InventarioController {

    private InventarioService inventarioService;

    //Criação da maquina
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "maquina", consumes = APPLICATION_JSON_VALUE)
    public void criarInventario(@RequestBody InventarioDTO inventarioDTO){
        inventarioService.criarInventario(inventarioDTO);
    }


}
