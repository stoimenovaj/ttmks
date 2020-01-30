package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.repository.LigiRepository;
import com.bazi.ttmk.service.LigiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigiServiceImpl implements LigiService {
    private final LigiRepository ligiRepository;

    public LigiServiceImpl(LigiRepository ligiRepository) {
        this.ligiRepository = ligiRepository;
    }

    @Override
    public List<Liga> getAllLigi() {
        return this.ligiRepository.findAll();
    }
}
