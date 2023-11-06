package com.example.demo.service;

import com.example.demo.bean.Chamada;
import com.example.demo.repository.ChamadaRepository;

public class ResponderChamadaService {

    private ChamadaRepository chamadaRepository;

    public ResponderChamadaService(ChamadaRepository chamadaRepository){
        this.chamadaRepository = chamadaRepository;
    }

    public Chamada apply(Chamada chamada){
        var chamadaSalva = chamadaRepository.salvar(chamada);

        return chamadaSalva;
    }
}
