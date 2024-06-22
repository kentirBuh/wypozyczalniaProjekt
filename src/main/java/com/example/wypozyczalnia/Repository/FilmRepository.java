package com.example.wypozyczalnia.Repository;

import com.example.wypozyczalnia.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>
{


    @Query("SELECT f.nazwa, COUNT(f) FROM Film f GROUP BY f.nazwa ORDER BY COUNT(f) DESC")
    List<Object[]> najliczniejszyFilm();//nie używane, zwraca film który pokazuje się najwięcej razy w naszych zapasach

    @Query("Select f from Film f")
    List<Film> wszystkieFilmy();
}

