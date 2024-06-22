package com.example.wypozyczalnia.Service;

import com.example.wypozyczalnia.Exception.DuplicateKlientException;
import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Repository.FilmRepository;
import com.example.wypozyczalnia.Repository.KlientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.example.wypozyczalnia.Model.Klient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KlientService {

    @Autowired
    private KlientRepository klientRepository;

    public List<Klient> getAllKlients() {
        return klientRepository.findAllKlient();
    }

    public List<Klient> wyszukajKlientImie(String imie) {
        return klientRepository.findAllKlient().stream()
                .filter(klient -> klient.getImie().equalsIgnoreCase(imie))
                .collect(Collectors.toList());
    }

    public List<Klient> wyszukajKlientNazwisko(String nazwisko) {
        return klientRepository.findAllKlient().stream()
                .filter(klient -> klient.getNazwisko().equalsIgnoreCase(nazwisko))
                .collect(Collectors.toList());
    }

    public List<Klient> wyszukajKlientTelefon(String telefon) {
        return klientRepository.findAllKlient().stream()
                .filter(klient -> klient.getTelefon().equalsIgnoreCase(telefon))
                .collect(Collectors.toList());
    }

    public Klient saveKlient(Klient klient) {
        if (klientRepository.existsByTelefon(klient.getTelefon())) {
            throw new DuplicateKlientException("Klient z tym numerem telefonu już istnieje");
        }
        return klientRepository.save(klient);
    }

    public List<Klient> findAll() {
        return klientRepository.findAll();

    }
}