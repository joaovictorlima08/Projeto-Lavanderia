package br.edu.fiec.lavanderia.service;

import br.edu.fiec.lavanderia.model.dto.ClienteDTO;
import br.edu.fiec.lavanderia.model.entity.ClienteEntity;
import br.edu.fiec.lavanderia.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.Optional; // Removido

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteEntity registrarCliente(ClienteDTO clienteDTO){
        clienteRepository.save(new ClienteEntity("", clienteDTO));
        return null;
    }

    public void registrarRoupas(ClienteDTO clienteDTO){
        clienteRepository.save(new ClienteEntity("", clienteDTO));
    }

    public List<ClienteEntity> buscarTodos() {
        return clienteRepository.findAll();
    }

    public List<ClienteEntity> buscarPorNome(String nome) {
        return clienteRepository.findAllByNome(nome);
    }

    public ClienteEntity buscarClientePorId(Integer id) {
        // Retorna o Cliente ou null se não for encontrado
        return clienteRepository.findById(id).orElse(null);
    }

    public ClienteEntity atualizarCliente(Integer id, ClienteDTO clienteDTO) {
        ClienteEntity cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNome(clienteDTO.getNome());
            cliente.setQuantidadeRoupas(clienteDTO.getQuantidadeRoupas());
            clienteRepository.save(cliente);
            return cliente;
        } else {
            return null;
        }
    }

    public boolean deletarCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
