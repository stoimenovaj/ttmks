package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Natprevar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface NatprevariRepository extends JpaRepository<Natprevar, Integer> {

    @Query(value = "select sum(dobieni_mechevi_domakjin) from project.natprevari as n " +
            "where n.id_tim_domakjin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    Optional<Integer> brojDomakjinOsvoeniMechevi(int idSezona, int idLiga, int idTim);

    @Query(value = "select sum(dobieni_mechevi_gostin) from project.natprevari as n " +
            "where n.id_tim_gostin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    Optional<Integer> brojGostinOsvoeniMechevi(int idSezona, int idLiga, int idTim);

    @Query(value = "select sum(dobieni_mechevi_gostin) from project.natprevari as n " +
            "where n.id_tim_domakjin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    Optional<Integer> brojDomakjinIzgubeniMechevi(int idSezona, int idLiga, int idTim);

    @Query(value = "select sum(dobieni_mechevi_domakjin) from project.natprevari as n " +
            "where n.id_tim_gostin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    Optional<Integer> brojGostinIzgubeniMechevi(int idSezona, int idLiga, int idTim);

    @Query(value = "select count(*) from project.natprevari as n " +
            "where (n.id_tim_gostin=?3 or n.id_tim_domakjin=?3) and n.id_sezona=?1 and n.id_liga=?2", nativeQuery = true)
    Optional<Integer> odigraniNatprevari(int idSezona, int idLiga, int idTim);

    @Query(value = "select count(*) from project.natprevari as n " +
            "where n.id_tim_domakjin=?3 and n.id_sezona=?1 and n.id_liga=?2 " +
            "and n.dobieni_mechevi_domakjin > n.dobieni_mechevi_gostin", nativeQuery = true)
    Optional<Integer> pobedeniNatprevariDomakjin(int idSezona, int idLiga, int idTim);

    @Query(value = "select count(*) from project.natprevari as n " +
            "where n.id_tim_gostin=?3 and n.id_sezona=?1 and n.id_liga=?2 " +
            "and n.dobieni_mechevi_domakjin < n.dobieni_mechevi_gostin", nativeQuery = true)
    Optional<Integer> pobedeniNatprevariGostin(int idSezona, int idLiga, int idTim);

    List<Natprevar> findByLiga_IdSezonaAndLiga_IdLigaOrderByKolo(int idSezona, int idLiga);

}
