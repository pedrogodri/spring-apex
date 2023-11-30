package br.com.medico.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.medico.api.Services.ClienteService;
import br.com.medico.api.model.Cliente;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping("/cliente")
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        return service.cadastrarCliente(cliente);
    }
}
