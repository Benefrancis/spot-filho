package br.com.fiap.spotfilho.model;

import jakarta.persistence.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "TB_ARTISTA")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARTISTA")
    @SequenceGenerator(name = "SQ_ARTISTA", sequenceName = "SQ_ARTISTA")
    @Column(name = "ID_ARTISTA")
    private long id;

    @Column(name = "NM_ARTISTA")
    private String nome;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "artista_musica",
            joinColumns = @JoinColumn(name = "ID_ARTISTA"),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSICA")
    )
    private Set<Musica> musicas = new HashSet<>();

    public Artista() {
    }

    public Artista(long id, String nome, Set<Musica> musicas) {
        this.id = id;
        this.nome = nome;
        this.musicas = musicas;
    }

    public void addMusica(Musica m) {
        this.musicas.add(m);
        m.getArtistas().add(this);
    }

    public void removeMusica(Musica m) {
        this.musicas.remove(m);
        m.getArtistas().remove(this);
    }

    public void removeMusicas() {
        Iterator<Musica> iterator = this.musicas.iterator();
        while (iterator.hasNext()) {
            Musica m = iterator.next();
            m.getArtistas().remove(this);
            iterator.remove();
        }
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
