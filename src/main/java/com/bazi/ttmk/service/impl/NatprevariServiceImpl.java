package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.repository.NatprevariRepository;
import com.bazi.ttmk.service.NatprevariService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatprevariServiceImpl implements NatprevariService {
    private final NatprevariRepository natprevariRepository;

    public NatprevariServiceImpl(NatprevariRepository natprevariRepository) {
        this.natprevariRepository = natprevariRepository;
    }

    @Override
    public List<Natprevar> getAllNatprevari() {
        return this.natprevariRepository.findAll();
    }
}
