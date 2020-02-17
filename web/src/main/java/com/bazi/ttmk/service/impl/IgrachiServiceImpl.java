package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Igrach;
import com.bazi.ttmk.model.Kategorija;
import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.repository.IgrachiRepository;
import com.bazi.ttmk.repository.KategoriiRepository;
import com.bazi.ttmk.repository.RegistriraniLicaRepository;
import com.bazi.ttmk.repository.TimoviRepository;
import com.bazi.ttmk.service.IgrachiService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IgrachiServiceImpl implements IgrachiService {

    private final IgrachiRepository igrachiRepository;

    private final RegistriraniLicaRepository registriraniLicaRepository;

    private final TimoviRepository timoviRepository;

    private final KategoriiRepository kategoriiRepository;

    public IgrachiServiceImpl(IgrachiRepository igrachiRepository, RegistriraniLicaRepository registriraniLicaRepository, TimoviRepository timoviRepository, KategoriiRepository kategoriiRepository) {
        this.igrachiRepository = igrachiRepository;
        this.registriraniLicaRepository = registriraniLicaRepository;
        this.timoviRepository = timoviRepository;
        this.kategoriiRepository = kategoriiRepository;
    }

    @Override
    public List<Igrach> getAllIgrachi() {
        return this.igrachiRepository.findAll();
    }

    @Override
    public Igrach createIgrach(Integer idLice, String opisNaReket, Date posledenLekarskiPregled, Integer idKategorija, Integer idTim) {
//        RegistriranoLice registriranoLice = this.registriraniLicaRepository.findById(idLice).orElseThrow(() -> new RuntimeException("Registrirano Lice with id " + idLice + " not found"));
        Kategorija kategorija = this.kategoriiRepository.findById(idKategorija).orElseThrow(() -> new RuntimeException("Kategorijata with id " + idKategorija + " not found"));
        Optional<Tim> tim = this.timoviRepository.findById(idTim);

        Igrach igrach = new Igrach();
        igrach.setIdLice(idLice);
        igrach.setKategorija(kategorija);
        igrach.setOpisNaReket(opisNaReket);
        igrach.setPosledenLekarskiPregled(posledenLekarskiPregled);
        tim.ifPresent(igrach::setTim);
        return this.igrachiRepository.save(igrach);
    }
}
