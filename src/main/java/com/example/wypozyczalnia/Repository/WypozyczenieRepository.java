package com.example.wypozyczalnia.Repository;

import com.example.wypozyczalnia.Model.Film;
import com.example.wypozyczalnia.Model.Wypozyczenie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WypozyczenieRepository extends JpaRepository<Wypozyczenie, Integer> {

    @Query("Select w from Wypozyczenie w")
    List<Wypozyczenie> wszystkieWypozyczania();

    @Query("SELECT w FROM Wypozyczenie w WHERE w.data_zwrotu < CURRENT_DATE() and w.status=false") //checks all the late ones, and it works according to the system clock.
    List<Wypozyczenie> wszystkieSpoznioneWypozyczania();

    public Wypozyczenie findById(int id);
}