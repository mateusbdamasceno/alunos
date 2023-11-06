package com.example.demo.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Chamada {
    private Aluno aluno;
    private boolean presente;
    private LocalDate date;
}
