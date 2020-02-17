package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.model.Sudija;
import com.bazi.ttmk.repository.RegistriraniLicaRepository;
import com.bazi.ttmk.repository.SudiiRepository;
import com.bazi.ttmk.service.SudiiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SudiiServiceImpl implements SudiiService {

    private final SudiiRepository sudiiRepository;

    private final RegistriraniLicaRepository registriraniLicaRepository;

    public SudiiServiceImpl(SudiiRepository sudiiRepository, RegistriraniLicaRepository registriraniLicaRepository) {
        this.sudiiRepository = sudiiRepository;
        this.registriraniLicaRepository = registriraniLicaRepository;
    }

    @Override
    public List<Sudija> getAllSudii() {
        return this.sudiiRepository.findAll();
    }

    @Override
    public Sudija createSudija(Integer idLice, String titula) {
//        RegistriranoLice registriranoLice = this.registriraniLicaRepository.findById(idLice).orElseThrow(() -> new RuntimeException("Registrirano Lice with id " + idLice + " not found"));


        Sudija sudija = new Sudija();
        sudija.setIdLice(idLice);
        sudija.setTitula(titula);
        return this.sudiiRepository.save(sudija);
    }
}
