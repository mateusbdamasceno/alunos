package com.example.demo;

import com.example.demo.bean.Aluno;
import com.example.demo.bean.Chamada;
import com.example.demo.repository.ChamadaRepository;
import com.example.demo.service.ResponderChamadaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ResponderChamadaServiceTest extends TestBase{

    @InjectMocks //Como se eu tivesse dando um new
    ResponderChamadaService responderChamadaService;

    @Mock
    ChamadaRepository chamadaRepository;

    @Test
    void salvarChamada(){
        var aluno = new Aluno();
        aluno .setNome("Mateus");

        var chamada = new Chamada();
        chamada.setAluno(aluno);
        chamada.setPresente(true);
        chamada.setDate(LocalDate.now());

        var outraChamada = new Chamada();
        outraChamada.setAluno(aluno);
        outraChamada.setPresente(true);
        outraChamada.setDate(LocalDate.now());

        Mockito.when(chamadaRepository.salvar(outraChamada)).thenReturn(outraChamada);

        var resultado = responderChamadaService.apply(chamada);

        Mockito.verify(chamadaRepository).salvar(chamada);

        Assertions.assertEquals(resultado.getDate(), outraChamada.getDate());

        //responderChamadaService.apply(chamada);
    }
}
