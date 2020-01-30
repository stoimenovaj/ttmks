package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Mech;
import com.bazi.ttmk.repository.MecheviRepository;
import com.bazi.ttmk.service.MecheviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecheviServiceImpl implements MecheviService {
    private final MecheviRepository mecheviRepository;

    public MecheviServiceImpl(MecheviRepository mecheviRepository) {
        this.mecheviRepository = mecheviRepository;
    }

    @Override
    public List<Mech> getAllMechevi() {
        return this.mecheviRepository.findAll();
    }
}
