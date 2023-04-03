package br.com.fiap.spotfilho.model;

import jakarta.persistence.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;

@Entity
@Table(name = "TB_ESTILO")
public class Estilo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTILO")
    @SequenceGenerator(name = "SQ_ESTILO", sequenceName = "SQ_ESTILO")
    @Column(name = "ID_ESTILO")
    private long id;

    @Column(name = "NM_ESTILO")
    private String nome;


    public Estilo() {
    }

    public Estilo(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public Estilo setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estilo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        //By default all fields without explicit view definition are included, disable this
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);


        //display name only
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(this);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonInString;

    }
}
