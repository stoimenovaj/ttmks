package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Natprevar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NatprevariRepository extends JpaRepository<Natprevar, Integer> {

    @Query(value = "select sum(dobieni_mechevi_domakjin) from project.natprevari as n " +
            "where n.id_tim_domakjin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    int brojDomakjinOsvoeniMechevi(int sezonaId, int ligaId, int timId);

    @Query(value = "select sum(dobieni_mechevi_gostin) from project.natprevari as n " +
            "where n.id_tim_gostin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    int brojGostinOsvoeniMechevi(int sezonaId, int ligaId, int timId);

    @Query(value = "select sum(dobieni_mechevi_gostin) from project.natprevari as n " +
            "where n.id_tim_domakjin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    int brojDomakjinIzgubeniMechevi(int sezonaId, int ligaId, int timId);

    @Query(value = "select sum(dobieni_mechevi_domakjin) from project.natprevari as n " +
            "where n.id_tim_gostin=?3 and n.id_sezona=?1 and n.id_liga=?2 ", nativeQuery = true)
    int brojGostinIzgubeniMechevi(int sezonaId, int ligaId, int timId);

    @Query(value = "select count(*) from project.natprevari as n " +
            "where (n.id_tim_gostin=?3 or n.id_tim_domakjin=?3) and n.id_sezona=?1 and n.id_liga=?2", nativeQuery = true)
    int odigraniNatprevari(int sezonaId, int ligaId, int timId);

    @Query(value = "select count(*) from project.natprevari as n " +
            "where n.id_tim_domakjin=?3 and n.id_sezona=?1 and n.id_liga=?2 " +
            "and n.dobieni_mechevi_domakjin > n.dobieni_mechevi_gostin", nativeQuery = true)
    int pobedeniNatprevariDomakjin(int sezonaId, int ligaId, int timId);

    @Query(value = "select count(*) from project.natprevari as n " +
            "where n.id_tim_gostin=?3 and n.id_sezona=?1 and n.id_liga=?2 " +
            "and n.dobieni_mechevi_domakjin < n.dobieni_mechevi_gostin", nativeQuery = true)
    int pobedeniNatprevariGostin(int sezonaId, int ligaId, int timId);

    List<Natprevar> findByLiga_Id_IdLigaAndLiga_Id_IdSezonaOrderByKoloAsc(int idLiga, int idSezona);

}
