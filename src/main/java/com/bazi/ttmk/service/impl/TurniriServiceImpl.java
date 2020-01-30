package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.repository.TurniriRepository;
import com.bazi.ttmk.service.TurniriService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurniriServiceImpl implements TurniriService {
    private final TurniriRepository turniriRepository;

    public TurniriServiceImpl(TurniriRepository turniriRepository) {
        this.turniriRepository = turniriRepository;
    }


    @Override
    public List<Turnir> getAllTurniri() {
        return this.turniriRepository.findAll();
    }
}
