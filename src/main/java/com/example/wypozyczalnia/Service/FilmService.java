package com.example.wypozyczalnia.Service;

import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms()
    {
        return filmRepository.findAll();
    }

    public Film najliczniejszyFilm() //nie używane na razie
    {
        List<Object[]> results = filmRepository.najliczniejszyFilm();
        if (!results.isEmpty()) {
            return (Film) results.get(0)[0];
        }
        return null;
    }

    public List<Film> wyszukajFilmNazwa(String nazwa) {
        return filmRepository.wszystkieFilmy().stream()
                .filter(film -> film.getNazwa().equalsIgnoreCase(nazwa))
                .collect(Collectors.toList());
    }

    public List<Film> wyszukajFilmKategoria(String kategoria) {
        return filmRepository.wszystkieFilmy().stream()
                .filter(film -> film.getKategoria().equalsIgnoreCase(kategoria))
                .collect(Collectors.toList());
    }
    public List<Film> wyszukajFilmStudio(String studio) {
        return filmRepository.wszystkieFilmy().stream()
                .filter(film -> film.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }
    public List<Film> wyszukajFilmRezyser(String rezyser) {
        return filmRepository.wszystkieFilmy().stream()
                .filter(film -> film.getRezyser().equalsIgnoreCase(rezyser))
                .collect(Collectors.toList());
    }
    public  List<Film> wyszukajFilmDostepne(){
        return filmRepository.wszystkieFilmy().stream()
                .filter(Film::getDostepnosc) //changed lambda to '::' no clue what it is
                .collect(Collectors.toList());
    }
    public  List<Film> wyszukajFilmNieDostepne(){
        return filmRepository.wszystkieFilmy().stream()
                .filter(film -> !film.getDostepnosc())
                .collect(Collectors.toList());
    }
    public List<Film> findAll() {
        return filmRepository.findAll();
    }
    public Film findById(int id)
    {
        return filmRepository.findById(id).get();
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

}
