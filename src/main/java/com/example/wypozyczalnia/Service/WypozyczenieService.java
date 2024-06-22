package com.example.wypozyczalnia.Service;

import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Model.Wypozyczenie;
import com.example.wypozyczalnia.Repository.WypozyczenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WypozyczenieService {

    @Autowired
    private WypozyczenieRepository wypozyczenieRepository;


    public List<Wypozyczenie> getAllRentals()
    {
        return wypozyczenieRepository.findAll();
    }

    public List<Wypozyczenie> getAllActiveRentals()
    {
        return wypozyczenieRepository.wszystkieWypozyczania().stream()
                .filter(wypozyczenie -> !wypozyczenie.getStatus())
                .collect(Collectors.toList());
    }

    public List<Wypozyczenie> getAllInActiveRentals()
    {
        return wypozyczenieRepository.wszystkieWypozyczania().stream()
                .filter(Wypozyczenie::getStatus)
                .collect(Collectors.toList());
    }

    public List<Wypozyczenie> getAllLateRentals()
    {
        return wypozyczenieRepository.wszystkieSpoznioneWypozyczania();
    }

    public Wypozyczenie saveWypozyczenie(Wypozyczenie wypozyczenie)
    {
        return wypozyczenieRepository.save(wypozyczenie);
    }

    public Wypozyczenie findbyId(Integer id)
    {
        return wypozyczenieRepository.findById(id).orElse(null);
    }

}
