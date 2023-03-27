package br.com.fiap.spotfilho;

import br.com.fiap.spotfilho.model.Artista;
import br.com.fiap.spotfilho.model.Estilo;
import br.com.fiap.spotfilho.model.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");

        EntityManager manager = factory.createEntityManager();

        //save(manager);

        //findByID(manager);

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

        Artista artista = new Artista();
        artista.setNome("Chorão");

        Musica musica = new Musica();
        musica.setNome("Só os loucos sabem")
                .setArtista(artista)
                .setEstilo(estilo)
                .setDuracao(LocalTime.of(0, 3, 20));

        manager.getTransaction().begin();
        manager.persist(estilo);
        manager.persist(artista);
        manager.persist(musica);
        manager.getTransaction().commit();
    }
}