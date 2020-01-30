package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.repository.TimoviRepository;
import com.bazi.ttmk.service.TimoviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimoviServiceImpl implements TimoviService {
    private final TimoviRepository timoviRepository;

    public TimoviServiceImpl(TimoviRepository timoviRepository) {
        this.timoviRepository = timoviRepository;
    }

    @Override
    public List<Tim> getAllTimovi() {
        return this.timoviRepository.findAll();
    }
}
