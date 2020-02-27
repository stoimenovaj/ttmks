package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.model.dto.IgrachMechevi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TimoviRepository extends JpaRepository<Tim,Integer> {

    @Query(value =
            "(select rl.ime_lice, rl.prezime_lice, subq.broj_mechevi from (" +
            "select i.id_lice, count(*) as broj_mechevi from project.igrachi as i " +
                    "inner join project.mechevi as m " +
                    "on (m.id_lice_igrach_domakjin=i.id_lice or "+
                    "m.id_lice_igrach_gostin=i.id_lice) and m.id_natprevar is not null " +
                    "where m.id_natprevar in (" +
                    "select n.id_natprevar from project.natprevari as n " +
                    "where n.id_liga=?3 and n.id_sezona=?2) " +
                    "group by i.id_lice " +
                    "having i.id_tim=?1 " +
                    ") as subq "+
                    "inner join project.registrirani_lica as rl on rl.id_lice=subq.id_lice) " +
                    "union" +
                    "(select rl.ime_lice, rl.prezime_lice, subq.broj_mechevi from (" +
                    "select i.id_lice, 0 as broj_mechevi from project.igrachi as i " +
                    "where i.id_tim=?1 and i.id_lice not in ((" +
                    "select m.id_lice_igrach_domakjin as igrach from project.mechevi as m " +
                    "inner join project.natprevari as n on m.id_natprevar=n.id_natprevar " +
                    "where n.id_liga=?3 and n.id_sezona=?2 " +
                    ") " +
                    " union " +
                    "(" +
                    "select m.id_lice_igrach_gostin as igrach from project.mechevi as m " +
                    "inner join project.natprevari as n on m.id_natprevar=n.id_natprevar " +
                    "where n.id_liga=?3 and n.id_sezona=?2 " +
                    ") " +
                    ") " +
                    ") as subq " +
                    "inner join project.registrirani_lica as rl on rl.id_lice=subq.id_lice) " +
                    "order by broj_mechevi desc"
            , nativeQuery = true)
    List<Object> findCrazyQuery(Integer idTim, Integer idSezona, Integer idLiga);
}
