/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.avaliacao.dao;

import br.com.avaliacao.model.Curso;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author soare
 */
public interface CursoDAO {

    public void adicionar(Curso curso) throws Exception;

    public List<Curso> listarTodos();

    public Curso buscarPorId(int id);

    public boolean remover(int id);

    public List<Curso> buscarPorTitulo(String titulo);
    // public Curso buscarPorTitulo(String titulo);

    public List<Curso> buscarCursoPorEmpresa(String empresa);

    public void atualizar(int id, String titulo, String descricao, int horas,
            LocalDate dataInicio, LocalDate dataFim, String empresa);

}
