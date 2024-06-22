package com.example.wypozyczalnia.Model;

import ch.qos.logback.core.joran.conditional.IfAction;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;


import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Wypozyczenie
{
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Film film;
    @ManyToOne
    private Klient klient;
    private LocalDate data_wypozyczenia;
    private LocalDate data_zwrotu;
    private Boolean status;


    public Wypozyczenie(){}
    public Wypozyczenie(Film film, Klient klient, LocalDate data_zwrotu)
    {
        this.film = film;
        this.klient = klient;
        this.data_wypozyczenia = LocalDate.now();
        this.data_zwrotu = data_zwrotu;
        this.status = false;
    }


    public int getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public LocalDate getData_wypozyczenia() {
        return data_wypozyczenia;
    }

    public void setData_wypozyczenia(LocalDate data_wypozyczenia) {
        this.data_wypozyczenia = data_wypozyczenia;
    }

    public LocalDate getData_zwrotu() {
        return data_zwrotu;
    }

    public void setData_zwrotu(LocalDate data_zwrotu) {
        this.data_zwrotu = data_zwrotu;
    }

    public Boolean getStatus() {
            return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
