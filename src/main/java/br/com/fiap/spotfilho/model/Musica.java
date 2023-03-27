package br.com.fiap.spotfilho.model;

import jakarta.persistence.*;

import java.time.LocalTime;


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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_ARTISTA", referencedColumnName = "ID_ARTISTA",
            foreignKey = @ForeignKey(name = "FK_MUSICA_ARTISTA", value = ConstraintMode.CONSTRAINT)
    )
    private Artista artista;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_ESTILO", referencedColumnName = "ID_ESTILO",
            foreignKey = @ForeignKey(name = "FK_MUSICA_ESTILO", value = ConstraintMode.CONSTRAINT)
    )
    private Estilo estilo;


    public Musica() {
    }

    public Musica(long id, String nome, LocalTime duracao, Artista artista, Estilo estilo) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.artista = artista;
        this.estilo = estilo;
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

    public Artista getArtista() {
        return artista;
    }

    public Musica setArtista(Artista artista) {
        this.artista = artista;
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
        final StringBuilder sb = new StringBuilder("Musica{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", duracao=").append(duracao);
        sb.append(", artista=").append(artista);
        sb.append(", estilo=").append(estilo);
        sb.append('}');
        return sb.toString();
    }
}
