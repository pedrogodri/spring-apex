package br.com.medico.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pecas")
@Getter
@Setter
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pecas_id;
    private String nome;

    @Column(name = "foto", length = 1000485760)
    @Lob
    private byte[] foto;
    @Column(length = 10000000)
    private String base64;
}
