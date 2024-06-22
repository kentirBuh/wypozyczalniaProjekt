package com.example.wypozyczalnia.Controller;

import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/filmy")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/filmy/add")
    public String showAddFilmForm(Model model) {
        model.addAttribute("film", new Film());
        return "add-film";
    }
    @PostMapping("/filmy/add")
    public String addFilm(@ModelAttribute Film film) {
        film.setDostepnosc(true);
        filmService.saveFilm(film);
        return "redirect:/filmy/all";
    }
    @GetMapping("/filmy/all")
    public String getAllFilms(Model model) {
        model.addAttribute("films", filmService.getAllFilms());
        return "tabelaFilm";
    }


    @GetMapping("filmy/szukaj")
    public String showSearchForm(Model model) {
        Film emptyFilm = new Film(); // Tworzymy nowy pusty obiekt klasy Film
        model.addAttribute("film", emptyFilm);
        return "searchFilm"; // Nazwa pliku HTML w katalogu templates
    }


    @GetMapping("filmy/szukaj/{nazwa}")
    public String filmByName(@PathVariable("nazwa") String nazwa, Model model) {

        model.addAttribute("films", filmService.wyszukajFilmNazwa(nazwa));
        return "tabelaFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @GetMapping("filmy/cathegory")
    public String showSearchForm2(Model model) {
        Film emptyFilm = new Film(); // Tworzymy nowy pusty obiekt klasy Film
        model.addAttribute("film", emptyFilm);
        return "searchFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/filmy/cathegory")
    public String SearchFilmCathegory(@RequestParam("kategoria") String kategoria){
        return "redirect:/filmy/cathegory/"+kategoria;
    }

    @GetMapping("filmy/cathegory/{kategoria}")
    public String filmByCathegory(@PathVariable("kategoria") String kategoria, Model model) {

        model.addAttribute("films", filmService.wyszukajFilmKategoria(kategoria));
        return "tabelaFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @GetMapping("filmy/studio")
    public String showSearchForm3(Model model) {
        Film emptyFilm = new Film(); // Tworzymy nowy pusty obiekt klasy Film
        model.addAttribute("film", emptyFilm);
        return "searchFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/filmy/studio")
    public String SearchFilmStudio(@RequestParam("studio") String studio){
        return "redirect:/filmy/studio/"+studio;
    }

    @GetMapping("filmy/studio/{studio}")
    public String filmByStudio(@PathVariable("studio") String studio, Model model) {

        model.addAttribute("films", filmService.wyszukajFilmStudio(studio));
        return "tabelaFilm"; // Nazwa pliku HTML w katalogu templates
    }


    @GetMapping("filmy/rezyser")
    public String showSearchForm4(Model model) {
        Film emptyFilm = new Film(); // Tworzymy nowy pusty obiekt klasy Film
        model.addAttribute("film", emptyFilm);
        return "searchFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/filmy/rezyser")
    public String SearchFilmRezyser(@RequestParam("rezyser") String rezyser){
        return "redirect:/filmy/studio/"+rezyser;
    }

    @GetMapping("filmy/rezyser/{rezyser}")
    public String filmByRezyser(@PathVariable("rezyser") String rezyser, Model model) {

        model.addAttribute("films", filmService.wyszukajFilmRezyser(rezyser));
        return "tabelaFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/filmy/dostepnosc")
    public String searchFilmByAvailability(@RequestParam("dostepnosc") String dostepnosc) {
        return "redirect:/filmy/dostepnosc/" + dostepnosc;
    }

    @GetMapping("/filmy/dostepnosc/{dostepnosc}")
    public String filmByAvailability(@PathVariable("dostepnosc") String dostepnosc, Model model) {
        List<Film> filmy;
        if ("dostepne".equals(dostepnosc)) {
            filmy = filmService.wyszukajFilmDostepne();
        } else {
            filmy = filmService.wyszukajFilmNieDostepne();
        }
        model.addAttribute("films", filmy);
        return "tabelaFilm"; // Nazwa pliku HTML w katalogu templates
    }

    @GetMapping("/filmy/nie-dostepne")
    public List<Film> filmByNieDostepne()
    {
        return filmService.wyszukajFilmNieDostepne();
    }
}
