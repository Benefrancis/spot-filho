package br.com.fiap.spotfilho.model;

import java.time.LocalTime;

public class Musica {

    private long id;

    private String nome;

    private LocalTime duracao;

    private Artista artista;

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
