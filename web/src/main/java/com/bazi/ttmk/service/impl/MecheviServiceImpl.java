package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.*;
import com.bazi.ttmk.model.dto.IgrachiInTurnirMech;
import com.bazi.ttmk.model.dto.MechRequest;
import com.bazi.ttmk.repository.*;
import com.bazi.ttmk.service.MecheviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecheviServiceImpl implements MecheviService {

    private final MecheviRepository mecheviRepository;

    private final IgrachiRepository igrachiRepository;

    private final SudiiRepository sudiiRepository;

    private final NatprevariRepository natprevariRepository;

    private final FaziRepository faziRepository;

    public MecheviServiceImpl(MecheviRepository mecheviRepository, IgrachiRepository igrachiRepository, SudiiRepository sudiiRepository, NatprevariRepository natprevariRepository, FaziRepository faziRepository) {
        this.mecheviRepository = mecheviRepository;
        this.igrachiRepository = igrachiRepository;
        this.sudiiRepository = sudiiRepository;
        this.natprevariRepository = natprevariRepository;
        this.faziRepository = faziRepository;
    }

    @Override
    public List<Mech> getAllMechevi() {
        return this.mecheviRepository.findAll();
    }

    @Override
    public Mech createMechForNatprevar(Integer idDomakjin, Integer idGostin, Integer dobieniSetoviDomakjin, Integer dobieniSetoviGostin, Integer idSudija, Integer idNatprevar) {
        Igrach igrach1 = this.igrachiRepository.findById(idDomakjin).orElseThrow(() -> new RuntimeException("Player with id" + idDomakjin + " not found"));
        Igrach igrach2 = this.igrachiRepository.findById(idGostin).orElseThrow(() -> new RuntimeException("Player with id" + idDomakjin + " not found"));
        Sudija sudija = this.sudiiRepository.findById(idSudija).orElseThrow(() -> new RuntimeException("Sudija with id" + idDomakjin + " not found"));
        Natprevar natprevar = this.natprevariRepository.findById(idNatprevar).orElseThrow(() -> new RuntimeException("Natprevar with id" + idDomakjin + " not found"));
        Mech mech = new Mech();
        mech.setDomakjinIgrach(igrach1);
        mech.setGostinIgrach(igrach2);
        mech.setSudija(sudija);
        mech.setNatprevar(natprevar);
        mech.setDobieniSetoviDomakjin(dobieniSetoviDomakjin);
        mech.setDobieniSetoviGostin(dobieniSetoviGostin);
        return this.mecheviRepository.save(mech);
    }

    @Override
    public Mech createMechForTurnir(Integer idTurnir, Integer idKategorija, Integer fazaRedenBroj,Integer idDomakjin, Integer idGostin, Integer dobieniSetoviDomakjin, Integer dobieniSetoviGostin, Integer idSudija) {
        Igrach igrach1 = this.igrachiRepository.findById(idDomakjin).orElseThrow(() -> new RuntimeException("Player with id" + idDomakjin + " not found"));
        Igrach igrach2 = this.igrachiRepository.findById(idGostin).orElseThrow(() -> new RuntimeException("Player with id" + idDomakjin + " not found"));
        Sudija sudija = this.sudiiRepository.findById(idSudija).orElseThrow(() -> new RuntimeException("Sudija with id" + idDomakjin + " not found"));
        Faza faza = this.faziRepository.findById(new FazaId(fazaRedenBroj,idTurnir,idKategorija)).orElseThrow(() -> new RuntimeException("Natprevar with id" + idDomakjin + " not found"));
        Mech mech = new Mech();
        mech.setDomakjinIgrach(igrach1);
        mech.setGostinIgrach(igrach2);
        mech.setSudija(sudija);
        mech.setFaza(faza);
        mech.setDobieniSetoviDomakjin(dobieniSetoviDomakjin);
        mech.setDobieniSetoviGostin(dobieniSetoviGostin);
        return this.mecheviRepository.save(mech);
    }

    @Override
    public IgrachiInTurnirMech getProtivnik(Integer idTurnir, Integer idKategorija, Integer brojFaza, Integer idIgrach) {

        Faza faza = this.faziRepository.findByIdTurnirAndIdKategorijaAndBrojFaza(idTurnir, idKategorija, brojFaza);

        IgrachiInTurnirMech rv = faza.getMechevi().stream()
                .filter(mech -> mech.getDomakjinIgrach().getIdLice() == idIgrach ||
                        mech.getGostinIgrach().getIdLice() == idIgrach)
                .findFirst()
                .map(mech -> new IgrachiInTurnirMech(
                        new IgrachiInTurnirMech.IgrachInTurnir(
                                mech.getDomakjinIgrach().getIdLice(),
                                mech.getDomakjinIgrach().getLice().getImeLice(),
                                mech.getDobieniSetoviDomakjin()
                        ),
                        new IgrachiInTurnirMech.IgrachInTurnir(
                                mech.getGostinIgrach().getIdLice(),
                                mech.getGostinIgrach().getLice().getImeLice(),
                                mech.getDobieniSetoviGostin()
                        ),
                        brojFaza,
                        true
                )).orElseThrow(() -> new RuntimeException("No mech found"));

        rv.setMore(this.faziRepository.findByIdTurnirAndIdKategorijaAndBrojFaza(idTurnir, idKategorija, brojFaza + 1) != null);
        return rv;
    }

    @Override
    public Mech createMechForNatprevar(MechRequest request) {
        Igrach igrach1 = this.igrachiRepository.findById(request.getDomakjinId()).orElseThrow(() -> new RuntimeException("Player with id"+" not found"));
        Igrach igrach2 = this.igrachiRepository.findById(request.getGostinId()).orElseThrow(() -> new RuntimeException("Player with id" + " not found"));
        //Sudija sudija = this.sudiiRepository.findById(1).orElseThrow(() -> new RuntimeException("Sudija with id" + " not found"));
        Natprevar natprevar = this.natprevariRepository.findById(request.getNatprevarId()).orElseThrow(() -> new RuntimeException("Natprevar with id" + request.getNatprevarId() +  " not found"));
        Mech mech = new Mech();
        mech.setDomakjinIgrach(igrach1);
        mech.setGostinIgrach(igrach2);
        //mech.setSudija(sudija);
        mech.setNatprevar(natprevar);
        mech.setDobieniSetoviDomakjin(request.getDomakjinSetovi());
        mech.setDobieniSetoviGostin(request.getGostinSetovi());
        return this.mecheviRepository.save(mech);
    }

}
