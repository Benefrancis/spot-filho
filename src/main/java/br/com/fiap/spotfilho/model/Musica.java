package br.com.fiap.spotfilho.model;

import jakarta.persistence.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "TB_MUSICA")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MUSICA")
    @SequenceGenerator(name = "SQ_MUSICA", sequenceName = "SQ_MUSICA")
    @Column(name = "ID_MUSICA")
    private long id;

    @Column(name = "NM_MUSICA")
    private String nome;

    @Temporal(TemporalType.TIME)
    @Column(name = "DURACAO")
    private LocalTime duracao;


    @ManyToMany(mappedBy = "musicas")
    @OrderBy("nome DESC")
    private Set<Artista> artistas = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_ESTILO", referencedColumnName = "ID_ESTILO",
            foreignKey = @ForeignKey(name = "FK_MUSICA_ESTILO", value = ConstraintMode.CONSTRAINT)
    )
    private Estilo estilo;


    public Musica() {
    }

    public Musica(long id, String nome, LocalTime duracao, Set<Artista> artistas, Estilo estilo) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.artistas = artistas;
        this.estilo = estilo;
    }


    public Set<Artista> getArtistas() {
        return artistas;
    }

    public Musica setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
        return this;
    }

    public long getId() {
        return id;
    }

    public Musica setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Musica setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public Musica setDuracao(LocalTime duracao) {
        this.duracao = duracao;
        return this;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public Musica setEstilo(Estilo estilo) {
        this.estilo = estilo;
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
