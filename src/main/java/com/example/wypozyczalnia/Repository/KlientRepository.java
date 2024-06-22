package com.example.wypozyczalnia.Repository;

import com.example.wypozyczalnia.Model.Klient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Integer> {

    @Query("select k from Klient k")
    List<Klient> findAllKlient();

    Boolean existsByTelefon(String telefon);
}
