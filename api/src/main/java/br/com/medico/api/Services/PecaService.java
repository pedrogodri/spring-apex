package br.com.medico.api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.medico.api.model.Mensagem;
import br.com.medico.api.model.Peca;
import br.com.medico.api.repository.PecasRepository;

@Service
public class PecaService {
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private PecasRepository repository;

    public ResponseEntity<?> cadastrarPeca(Peca peca) {
        //Validação dos atributos

        repository.save(peca);
        mensagem.setMensagem("Peça salva com sucesso");
        return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }
}