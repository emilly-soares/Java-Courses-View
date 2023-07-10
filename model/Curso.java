/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao.model;

import java.time.LocalDate;

/**
 *
 * @author soare
 */
public class Curso {
    private int id;
    private String titulo;
    private String descricao;
    private int horas;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String empresa;

    public Curso() {
    }

    public Curso(String titulo, String descricao, int horas, LocalDate dataInicio, LocalDate dataFim, String empresa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horas = horas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.empresa = empresa;
    }

    public Curso(int id, String titulo, String descricao, int horas, LocalDate dataInicio, LocalDate dataFim, String empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.horas = horas;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
}
