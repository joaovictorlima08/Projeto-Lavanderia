package br.edu.fiec.lavanderia.service;

import br.edu.fiec.lavanderia.model.dto.InventarioDTO;
import br.edu.fiec.lavanderia.model.entity.InventarioEntity;
import br.edu.fiec.lavanderia.repository.InventarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Define a classe como camada de serviço (regras de negócio)
@AllArgsConstructor // Cria construtor com todos os atributos
public class InventarioService {

    private InventarioRepository inventarioRepository;

    //Criação Maquinas
    public void criarInventario(InventarioDTO dto){
        InventarioEntity maquina = new InventarioEntity();

        maquina.setMarca(dto.getMarca()); // Define a marca
        maquina.setLitragem(dto.getLitragem()); // Define a litragem
        maquina.setModelo(dto.getModelo()); // Define o modelo
        maquina.setConsumo(dto.getConsumo()); // Define o consumo
        inventarioRepository.save(maquina); // Salva no banco de dados

        //Esse trecho cria um objeto da entidade InventarioEntity,
        // copia os dados recebidos do DTO para a entidade e joga no banco
    }

    //Listar Todas as Maquinas
    public List<InventarioEntity> listarInventario(){
        return inventarioRepository.findAll();
    }

    //Listar por ID
    public InventarioEntity buscarPorId(Long id){
        return inventarioRepository.findById(id).orElse(null);
    }

    //Atualizar Maquinas
    public void atualizarInventario(Long id, InventarioDTO dto){

        InventarioEntity maquina =
                inventarioRepository.findById(id).orElse(null);

        if(maquina != null){
            maquina.setMarca(dto.getMarca());
            maquina.setLitragem(dto.getLitragem());
            maquina.setModelo(dto.getModelo());
            maquina.setConsumo(dto.getConsumo());

            inventarioRepository.save(maquina);
        }
    }

    //Deletar Maquinas
    public void deletarInventario(Long id){
        inventarioRepository.deleteById(id);
    }
}
