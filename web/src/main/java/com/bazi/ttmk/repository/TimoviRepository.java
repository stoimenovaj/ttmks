package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Sala;
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

    @Query(value =
            "select s.ime_sala, g.ime_grad, broenje.pobedi from ( " +
                    "select count(*) as pobedi, s.id_sala from project.sali as s " +
                    "inner join ( " +
                    "select  " +
                    "case  " +
                    "when n.dobieni_mechevi_domakjin > n.dobieni_mechevi_gostin then n.id_tim_domakjin " +
                    "when n.dobieni_mechevi_domakjin < n.dobieni_mechevi_gostin then n.id_tim_gostin " +
                    "end as pobednik_tim, n.id_sala " +
                    "from project.natprevari as n" +
                    ") as pobednici on s.id_sala=pobednici.id_sala " +
                    "where pobednici.pobednik_tim=?1 " +
                    "group by s.id_sala " +
                    ") as broenje " +
                    "inner join project.sali as s on s.id_sala=broenje.id_sala " +
                    "inner join project.gradovi as g on g.id_grad=s.id_grad " +
                    "where broenje.pobedi = ( " +
                    "select max(broenje.pobedi) from project.sali as s " +
                    "inner join (\n" +
                    "select count(*) as pobedi, s.id_sala from project.sali as s " +
                    "inner join ( " +
                    "select " +
                    "case " +
                    "when n.dobieni_mechevi_domakjin > n.dobieni_mechevi_gostin then n.id_tim_domakjin " +
                    "when n.dobieni_mechevi_domakjin < n.dobieni_mechevi_gostin then n.id_tim_gostin " +
                    "end as pobednik_tim, n.id_sala " +
                    "from project.natprevari as n " +
                    ") as pobednici on s.id_sala=pobednici.id_sala " +
                    "where pobednici.pobednik_tim=?1 " +
                    "group by s.id_sala " +
                    "\t) as broenje on s.id_sala=broenje.id_sala " +
                    ") "
            ,nativeQuery = true)
    List<Object> findSrekjniSali(Integer idTim);

    @Query(value =
            "select odigrani, pobedi, zagubeni from ( " +
                    "select 1 as tim, count(*) as odigrani from project.timovi as t " +
                    "inner join project.natprevari as n on t.id_tim=n.id_tim_domakjin or t.id_tim=n.dobieni_mechevi_gostin " +
                    "where t.id_tim=?1 " +
                    ") as o " +
                    "inner join ( " +
                    "select 1 as tim, sum(stats.pobedi) as pobedi from ( " +
                    "( " +
                    "select count(*) as pobedi from project.natprevari as n " +
                    "where n.id_tim_domakjin=?1 and n.dobieni_mechevi_domakjin > n.dobieni_mechevi_gostin " +
                    ") " +
                    "union " +
                    "( " +
                    "select count(*) as pobedi from project.natprevari as n " +
                    "where n.id_tim_gostin=?1 and n.dobieni_mechevi_domakjin < n.dobieni_mechevi_gostin " +
                    ") " +
                    ") as stats " +
                    ") as p on o.tim=p.tim " +
                    "inner join ( " +
                    "select 1 as tim, sum(stats.zagubi) as zagubeni from ( " +
                    "( " +
                    "select count(*) as zagubi from project.natprevari as n " +
                    "where n.id_tim_domakjin=?1 and n.dobieni_mechevi_domakjin < n.dobieni_mechevi_gostin " +
                    ") " +
                    "union " +
                    "( " +
                    "select count(*) as zagubi from project.natprevari as n " +
                    "where n.id_tim_gostin=?1 and n.dobieni_mechevi_domakjin > n.dobieni_mechevi_gostin " +
                    ") " +
                    ") as stats " +
                    ") as i on i.tim=p.tim "
            , nativeQuery = true)
    List<Object> findTimStats(Integer idTim);
}
