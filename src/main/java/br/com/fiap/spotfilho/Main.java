package br.com.fiap.spotfilho;

import br.com.fiap.spotfilho.model.Artista;
import br.com.fiap.spotfilho.model.Estilo;
import br.com.fiap.spotfilho.model.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");

        EntityManager manager = factory.createEntityManager();

        save(manager);

        //   findByID(manager);

        findAll(manager);

    }

    private static void findAll(EntityManager manager) {
        String jpql = "From Musica";
        List<Musica> resultList = manager.createQuery(jpql).getResultList();
        resultList.stream().forEach(System.out::println);
    }

    private static void findByID(EntityManager manager) {
        Musica musica = manager.find(Musica.class, 1L);
        System.out.println(musica);
    }

    private static void save(EntityManager manager) {
        Estilo estilo = new Estilo();
        estilo.setNome("Rock");


        Musica musica = new Musica();
        musica.setNome("Só os loucos sabem")
                .setEstilo(estilo)
                .setDuracao(LocalTime.of(0, 3, 20));

        var vocal = new Artista();
        vocal.setNome("Chorão");
        vocal.addMusica(musica);

        var baixo = new Artista();
        baixo.setNome("Champignon");
        baixo.addMusica(musica);

        var guitarra = new Artista();
        guitarra.setNome("Marcão Britto");
        guitarra.addMusica(musica);

        var guitarra2 = new Artista();
        guitarra2.setNome("Thiago Castanho").addMusica(musica);

        var bateria = new Artista();
        bateria.setNome("Bruno Graveto").addMusica(musica);


        manager.getTransaction().begin();

        Arrays.asList(vocal, bateria, guitarra, guitarra2, baixo).forEach(
                manager::persist
        );

        manager.persist(estilo);
        manager.persist(musica);
        manager.getTransaction().commit();
    }
}