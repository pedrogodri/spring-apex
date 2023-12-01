package br.com.medico.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.medico.api.Services.PecaService;
import br.com.medico.api.model.Peca;

@RestController
public class PecaController {
    
    @Autowired
    private PecaService service;

    @PostMapping(value = {"/pecas"}, consumes = {"multipart/form-data"})
    public ResponseEntity<?> salvar(@RequestPart("peca") String pecaJson, 
    @RequestPart("foto") MultipartFile foto) throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        Peca peca = objMap.readValue(pecaJson, Peca.class);
        if(foto != null) {
            peca.setFoto(foto.getBytes());
        }

        return service.cadastrarPeca(peca);
    }
}
