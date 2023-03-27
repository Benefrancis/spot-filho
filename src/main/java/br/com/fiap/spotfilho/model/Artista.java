package br.com.fiap.spotfilho.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ARTISTA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_ARTISTA", columnNames = "NM_ARTISTA")
})
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARTISTA")
    @SequenceGenerator(name = "SQ_ARTISTA", sequenceName = "SQ_ARTISTA")
    @Column(name = "ID_ARTISTA")
    private long id;

    @Column(name = "NM_ARTISTA")
    private String nome;

    public Artista() {
    }

    public Artista(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public Artista setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Artista setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artista{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
