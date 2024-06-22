package com.example.wypozyczalnia.Model;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue
    private Integer Id;
    private String nazwa;
    private String kategoria;
    private String studio;
    private String rezyser;
    @Column(name = "dostepnosc")
    private Boolean dostepnosc;


  public Film(String nazwa, String kategoria, String studio, String rezyser)
  {
      this(nazwa,kategoria,studio,rezyser,true);
  }
    public Film() {}
    public Film(String nazwa, String kategoria, String studio, String rezyser, boolean dostepnosc)
    {
        this.nazwa=nazwa;
        this.kategoria=kategoria;
        this.studio=studio;
        this.rezyser=rezyser;
        this.dostepnosc=dostepnosc;
    }



    public int getId()
        {
            return Id;
        }
        public void setId(int Id)
        {
            this.Id=Id;
        }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {this.nazwa = nazwa;}

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRezyser() {
        return rezyser;
    }

    public void setRezyser(String rezyser) {
        this.rezyser = rezyser;
    }

    public Boolean getDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(Boolean dostepnosc) {
        this.dostepnosc = dostepnosc;
    }
}
