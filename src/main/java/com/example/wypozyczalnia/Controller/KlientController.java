package com.example.wypozyczalnia.Controller;

import com.example.wypozyczalnia.Exception.DuplicateKlientException;
import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Model.Klient;
import org.springframework.ui.Model;
import com.example.wypozyczalnia.Service.KlientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.zip.DataFormatException;

@Controller
public class KlientController {

    @Autowired
    private KlientService klientService;

    @GetMapping("/klient/all")
    public String getAllKlienci(Model model)
    {
        model.addAttribute("klients", klientService.getAllKlients());
        return "tabelaKlient";
    }

    @PostMapping("/klient/add")
    public String addKlient(@ModelAttribute Klient klient, RedirectAttributes redirectAttributes) {
        try {
            klientService.saveKlient(klient);
            return "redirect:/klient/all";
        }
        catch (DuplicateKlientException e)
        {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/klient/add";
        }
    }

    @GetMapping("/klient/add")
    public String showAddKlientForm(Model model) {
        model.addAttribute("klient", new Klient());
        return "add-klient";
    }

    @GetMapping("klient/szukaj")
    public String showSearchForm(Model model) {
        Klient emptyKlient = new Klient();
        model.addAttribute("klient", emptyKlient);
        return "searchKlient"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/klient/imie")
    public String SearchKlientImie(@RequestParam("imie") String imie){
        return "redirect:/klient/szukaj/"+imie;
    }

    @GetMapping("klient/imie/{imie}")
    public String klientByImie(@PathVariable("imie") String imie, Model model) {

        model.addAttribute("klients", klientService.wyszukajKlientImie(imie));
        return "tabelaKlient"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/klient/nazwisko")
    public String SearchKlientNazwisko(@RequestParam("nazwisko") String nazwisko){
        return "redirect:/klient/nazwisko/"+nazwisko;
    }

    @GetMapping("klient/nazwisko/{nazwisko}")
    public String klientByNazwisko(@PathVariable("nazwisko") String nazwisko, Model model) {

        model.addAttribute("klients", klientService.wyszukajKlientNazwisko(nazwisko));
        return "tabelaKlient"; // Nazwa pliku HTML w katalogu templates
    }

    @PostMapping("/klient/telefon")
    public String SearchKlientTelefon(@RequestParam("telefon") String telefon){
        return "redirect:/klient/telefon/"+telefon;
    }

    @GetMapping("klient/telefon/{telefon}")
    public String klientByTelefon(@PathVariable("telefon") String telefon, Model model) {

        model.addAttribute("klients", klientService.wyszukajKlientTelefon(telefon));
        return "tabelaKlient";
    }

}
