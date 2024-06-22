package com.example.wypozyczalnia.Controller;

import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Model.Wypozyczenie;
import com.example.wypozyczalnia.Service.FilmService;
import com.example.wypozyczalnia.Service.KlientService;
import com.example.wypozyczalnia.Service.WypozyczenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class WypozyczeniaController
{
    @Autowired
    private WypozyczenieService wypozyczenieService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private KlientService klientService;


    @GetMapping("/wypozyczenia/all")
    public String getAllRentals(Model model) {
        model.addAttribute("rentals", wypozyczenieService.getAllRentals());
        return "tabelaWypozyczenie";
    }
    @GetMapping("/wypozyczenia/active")
    public String getActiveRentals(Model model) {
        model.addAttribute("rentals", wypozyczenieService.getAllActiveRentals());
        return "tabelaWypozyczenie";
    }
    @GetMapping("/wypozyczenia/inactive")
    public String getInActiveRentals(Model model) {
        model.addAttribute("rentals", wypozyczenieService.getAllInActiveRentals());
        return "tabelaWypozyczenie";
    }
    @GetMapping("/wypozyczenia/late")
    public String getLateRentals(Model model) {
        model.addAttribute("rentals", wypozyczenieService.getAllLateRentals());
        return "tabelaWypozyczenie";
    }
    @PostMapping("/wypozyczenia/add")
    public String addRental(@ModelAttribute Wypozyczenie rental)
    {
        Film selectedFilm = filmService.findById(rental.getFilm().getId());

        rental.setStatus(false);
        rental.setData_wypozyczenia(LocalDate.now());
        wypozyczenieService.saveWypozyczenie(rental);
        selectedFilm.setDostepnosc(false);
        filmService.saveFilm(selectedFilm);
       return  "redirect:/wypozyczenia/all";
    }
    @GetMapping("/wypozyczenia/complete")
    public String showSearchForm(Model model)
    {
        model.addAttribute("wypozyczenia", wypozyczenieService.getAllInActiveRentals());
        return "complete-wypozyczenie";
    }
    @PostMapping("/wypozyczenia/complete")
    public String markAsComplete(@RequestParam("rentals") String[] rentalsIds) {


        List<Wypozyczenie> rentals = new ArrayList<>();
        for (String id : rentalsIds)
        {;

            int rentalId = parseInt(id);
            Wypozyczenie wypozyczenie = wypozyczenieService.findbyId(rentalId);
            if (wypozyczenie != null)
            {
                rentals.add(wypozyczenie);
            }
        }
        for (Wypozyczenie x : rentals) {
            x.setStatus(true);
            x.getFilm().setDostepnosc(true);
            wypozyczenieService.saveWypozyczenie(x);
        }
        return "redirect:/wypozyczenia/all";

    }

    @GetMapping("/wypozyczenia/add")
    public String getAddRental(Model model)
    {
        model.addAttribute("wypozyczenie", new Wypozyczenie());
        model.addAttribute("film",filmService.wyszukajFilmDostepne());
        model.addAttribute("klient",klientService.findAll());
        return "add-wypozyczenie";
    }
}
