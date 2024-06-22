package com.example.wypozyczalnia.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Klient
{
    @Id
    @GeneratedValue
    private Integer id;

    private String imie;
    private String nazwisko;
    private String telefon;

    public Klient(){}
    public Klient(String imie, String nazwisko, String telefon){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
