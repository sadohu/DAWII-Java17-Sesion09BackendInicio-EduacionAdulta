package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entidades.Pasatiempo;
import com.empresa.repository.PasatiempoRepository;

@Service
public class PasatiempoServiceImpl implements PasatiempoService {

    @Autowired
    private PasatiempoRepository repository;

    @Override
    public List<Pasatiempo> listaPasatiempo() {
        return repository.findAll();
    }

}
