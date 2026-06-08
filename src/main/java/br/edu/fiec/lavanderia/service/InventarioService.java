package br.edu.fiec.lavanderia.service;


import br.edu.fiec.lavanderia.model.dto.InventarioDTO;
import br.edu.fiec.lavanderia.repository.InventarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventarioService {

    private InventarioRepository inventarioRepository;

    public void criarInventario (InventarioDTO inventarioDTO){
        inventarioDTO.save(new Inventario("Maquina",inventarioDTO));
    }
}
