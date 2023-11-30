package br.com.medico.api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.medico.api.model.Cliente;
import br.com.medico.api.model.Mensagem;
import br.com.medico.api.repository.ClienteRepository;
import br.com.medico.api.repository.EnderecoRepository;

@Service
public class ClienteService {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ResponseEntity<?> cadastrarCliente(Cliente cliente) {
        if(cliente.getEndereco() != null) {
            if(cliente.getCpf() == null) {
                mensagem.setMensagem("Insira um cpf");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            if(cliente.getNome() == null || cliente.getNome().isEmpty()) {
                mensagem.setMensagem("Insira um nome");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            if(cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
                mensagem.setMensagem("Insira um nome");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            if(cliente.getEndereco().getCidade() == null || cliente.getEndereco().getCidade().isEmpty()) {
                mensagem.setMensagem("Insira um cidade");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }

            enderecoRepository.save(cliente.getEndereco());
            cliente.setEndereco(cliente.getEndereco());

            clienteRepository.save(cliente);

            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } else {
            mensagem.setMensagem("O endereço do cliente é nulo");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
    }

}
