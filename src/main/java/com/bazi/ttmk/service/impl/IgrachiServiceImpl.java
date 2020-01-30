package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Igrach;
import com.bazi.ttmk.repository.IgrachiRepository;
import com.bazi.ttmk.service.IgrachiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IgrachiServiceImpl implements IgrachiService {
    private final IgrachiRepository igrachiRepository;

    public IgrachiServiceImpl(IgrachiRepository igrachiRepository) {
        this.igrachiRepository = igrachiRepository;
    }

    @Override
    public List<Igrach> getAllIgrachi() {
        return this.igrachiRepository.findAll();
    }
}
