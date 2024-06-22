package com.example.wypozyczalnia.Data;

import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Model.Klient;
import com.example.wypozyczalnia.Model.Wypozyczenie;
import com.example.wypozyczalnia.Repository.FilmRepository;
import com.example.wypozyczalnia.Repository.KlientRepository;
import com.example.wypozyczalnia.Repository.WypozyczenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
@Configuration
public class SampleData {
    @Autowired
    private KlientRepository klientRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private WypozyczenieRepository wypozyczenieRepository;
/*
    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Klient klient1 = new Klient();
            klient1.setImie("Jan");
            klient1.setNazwisko("Kowalski");
            klient1.setTelefon("123456789");

            Klient klient2 = new Klient();
            klient2.setImie("Anna");
            klient2.setNazwisko("Nowak");
            klient2.setTelefon("987654321");
            Klient klient3 = new Klient();
            klient2.setImie("Bnna");
            klient2.setNazwisko("Nowakp");
            klient2.setTelefon("9876543213");

            klientRepository.saveAll(Arrays.asList(klient1,klient2,klient3));

            Film film1 = new Film();
            film1.setNazwa("Film 1");
            film1.setKategoria("akcja");
            film1.setStudio("studio 1");
            film1.setRezyser("Tom");
            film1.setDostepnosc(true);

            Film film2 = new Film();
            film2.setNazwa("Film 1");
            film2.setKategoria("akcja");
            film2.setStudio("studio 1");
            film2.setRezyser("Tom");
            film2.setDostepnosc(false);

            Film film3 = new Film();
            film3.setNazwa("Film 1");
            film3.setKategoria("akcja");
            film3.setStudio("studio 1");
            film3.setRezyser("Tom");
            film3.setDostepnosc(true);

            Film film4 = new Film();
            film4.setNazwa("Film 2");
            film4.setKategoria("akcja");
            film4.setStudio("studio 2");
            film4.setRezyser("Tony");
            film4.setDostepnosc(true);

            Film film5 = new Film();
            film5.setNazwa("Film 2");
            film5.setKategoria("akcja");
            film5.setStudio("studio 2");
            film5.setRezyser("Tony");
            film5.setDostepnosc(false);


            Film krolLew1 = new Film("Król Lew", "Animacja", "Disney", "Roger Allers");
            Film krolLew2 = new Film("Król Lew", "Animacja", "Disney", "Roger Allers");
            Film krolLew3 = new Film("Król Lew", "Animacja", "Disney", "Roger Allers");
            Film krolLew4 = new Film("Król Lew", "Animacja", "Disney", "Roger Allers");
            Film krolLew5 = new Film("Król Lew", "Animacja", "Disney", "Roger Allers");
            Film titanic1 = new Film("Titanic", "Dramat", "20th Century Fox", "James Cameron");
            Film titanic2 = new Film("Titanic", "Dramat", "20th Century Fox", "James Cameron");
            Film titanic3 = new Film("Titanic", "Dramat", "20th Century Fox", "James Cameron");
            Film rat1 = new Film("Ratatoui", "Animacja", "Pixar", "Brad Bird");
            Film rat2 = new Film("Ratatoui", "Animacja", "Pixar", "Brad Bird");
            Film rat3 = new Film("Ratatoui", "Animacja", "Pixar", "Brad Bird");
            Film rat4 = new Film("Ratatoui", "Animacja", "Pixar", "Brad Bird");
            Film rat5 = new Film("Ratatoui", "Animacja", "Pixar", "Brad Bird");
            Film castAway1 = new Film("Cast Away", "Dramat", "20th Century Fox", "Robert Zemeckis");
            Film castAway2 = new Film("Cast Away", "Dramat", "20th Century Fox", "Robert Zemeckis");

            filmRepository.saveAll(Arrays.asList(film1, film2, film3, film4, film5, krolLew1, krolLew2, krolLew3,krolLew4,
                    krolLew5, titanic1, titanic2, titanic3, rat1, rat2, rat3,rat4,rat5, castAway1, castAway2));

            Wypozyczenie wypozyczenie1 = new Wypozyczenie(film1, klient1, LocalDate.now(), LocalDate.now().plusDays(7), false);
            Wypozyczenie wypozyczenie2 = new Wypozyczenie(film2, klient2, LocalDate.now(), LocalDate.now().minusDays(2), false);
            wypozyczenieRepository.save(wypozyczenie1);
            wypozyczenieRepository.save(wypozyczenie2);
        };
    }*/
}
