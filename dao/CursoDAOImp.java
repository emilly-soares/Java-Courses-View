/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao.dao;

import br.com.avaliacao.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soare
 */
public class CursoDAOImp implements CursoDAO {

    private Connection conn;

    @Override
    public void adicionar(Curso curso) throws Exception {
        String sql = "INSERT INTO curso (titulo, descricao, horas, dataInicio, dataFim, empresa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getTitulo());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getHoras());
            stmt.setDate(4, java.sql.Date.valueOf(curso.getDataInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(curso.getDataFim()));
            stmt.setString(6, curso.getEmpresa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Curso> listarTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                int horas = rs.getInt("horas");
                LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
                LocalDate dataFim = rs.getDate("dataFim").toLocalDate();
                String empresa = rs.getString("empresa");
                Curso curso = new Curso(id, titulo, descricao, horas, dataInicio, dataFim, empresa);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Logger.getLogger(CursoDAOImp.class.getName()).log(Level.SEVERE, null, e);
        }
        return cursos;
    }

    @Override
    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM curso WHERE id=?";
        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setDescricao(rs.getString("descricao"));
                c.setHoras(rs.getInt("horas"));
                c.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                c.setDataFim(rs.getDate("dataFim").toLocalDate());
                c.setEmpresa(rs.getString("empresa"));
                rs.close();
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean remover(int id) {
        String sql = "DELETE FROM curso WHERE id=?";
        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Curso> buscarPorTitulo(String titulo) {
        //public Curso buscarPorTitulo(String titulo) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso WHERE titulo LIKE ?";
        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, "%" + titulo + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setDescricao(rs.getString("descricao"));
                c.setHoras(rs.getInt("horas"));
                c.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                c.setDataFim(rs.getDate("dataFim").toLocalDate());
                c.setEmpresa(rs.getString("empresa"));
                cursos.add(c);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursos;
    }

    @Override
    public List<Curso> buscarCursoPorEmpresa(String empresa) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso WHERE empresa=?";
        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, empresa);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setDescricao(rs.getString("descricao"));
                c.setHoras(rs.getInt("horas"));
                c.setDataInicio(rs.getDate("dataInicio").toLocalDate());
                c.setDataFim(rs.getDate("dataFim").toLocalDate());
                c.setEmpresa(rs.getString("empresa"));
                cursos.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
    }

    public void atualizar(int id, String titulo, String descricao, int horas,
            LocalDate dataInicio, LocalDate dataFim, String empresa) {
        String sql = "UPDATE curso "
                + "SET titulo = ?, descricao = ?, horas = ?, dataInicio = ?, dataFim = ?, empresa = ? "
                + "WHERE id = ? ";

        try (Connection conn = new ConnectionFactory().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.setInt(3, horas);
            stmt.setDate(4, java.sql.Date.valueOf(dataInicio));
            stmt.setDate(5, java.sql.Date.valueOf(dataFim));
            stmt.setString(6, empresa);
            stmt.setInt(7, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
