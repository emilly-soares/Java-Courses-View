/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao.controller;

import br.com.avaliacao.dao.CursoDAO;
import br.com.avaliacao.dao.CursoDAOImp;
import br.com.avaliacao.model.Curso;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author soare
 */
public class CursoController {
    
    private Curso curso;
    private List<Curso> cursos;
    private CursoDAO dao;
    
    public CursoController() {
        novoCurso();
        dao = new CursoDAOImp();
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public CursoDAO getDao() {
        return dao;
    }
    
    public void setDao(CursoDAO dao) {
        this.dao = dao;
    }
    
    private void novoCurso() {
        this.curso = new Curso();
    }
    
    public void cadastrarCurso(String titulo, String descricao, int horas, LocalDate dataInicio, LocalDate dataFim, String empresa) throws Exception {
        Curso curso = new Curso(titulo, descricao, horas, dataInicio, dataFim, empresa);
        dao.adicionar(curso);
    }
    
    public void carregarLista() {
        cursos = dao.listarTodos();
    }
    
    public boolean removerCurso(int id) {
        boolean removido = dao.remover(id);
        carregarLista();
        return removido;
    }
    
    public void buscarCursoPorID(int id) {
        this.curso = dao.buscarPorId(id);
    }
    
    public List<Curso> buscarCursoPorTitulo(String titulo) {
        cursos.clear();
        cursos.addAll(dao.buscarPorTitulo(titulo));
        return cursos;
    }
    
    public List<Curso> buscarCursoPorEmpresa(String empresa) {
        cursos.clear();
        cursos.addAll(dao.buscarCursoPorEmpresa(empresa));
        return cursos;
    }
    
    public List<Curso> listarCursos() {
        return dao.listarTodos();
    }
    
    public void atualizar(int id, String titulo, String descricao, int horas,
            LocalDate dataInicio, LocalDate dataFim, String empresa) {
        dao.atualizar(id, titulo, descricao, horas, dataInicio, dataFim, empresa);
    }
}
