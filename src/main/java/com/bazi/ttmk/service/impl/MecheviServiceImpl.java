package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.*;
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

}
