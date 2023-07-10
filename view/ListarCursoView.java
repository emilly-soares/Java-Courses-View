/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao.view;

import br.com.avaliacao.controller.CursoController;
import br.com.avaliacao.model.Curso;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarCursoView extends JFrame {

    private JList<String> cursosList;
    private DefaultListModel<String> listModel;
    private CursoController c;

    public ListarCursoView() {
        c = new CursoController();
        List<Curso> cursos = c.listarCursos();
        setTitle("Listagem de Cursos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        for (Curso curso : cursos) {
            String item = "Id: " + curso.getId() + " - Título: " + curso.getTitulo()
                    + " - Horas: " + curso.getHoras()
                    + " - Descrição: " + curso.getDescricao() + " - Data Início: " + curso.getDataInicio()
                    + " - Data Fim: " + curso.getDataFim() + " - Empresa: " + curso.getEmpresa();
            listModel.addElement(item);
        }

        cursosList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(cursosList);

        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCursoSelecionado();
            }
        });

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCursoSelecionado();
            }
        });

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(btnExcluir);
        btnPanel.add(btnAtualizar);

        panel.add(btnPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    private void excluirCursoSelecionado() {
        int selectedIndex = cursosList.getSelectedIndex();
        if (selectedIndex != -1) {
            String item = cursosList.getSelectedValue();
            String[] parts = item.split(" - ");
            String idPart = parts[0];
            int id = Integer.parseInt(idPart.substring(4));
            c.removerCurso(id);
            listModel.remove(selectedIndex);
        }
    }

    private void atualizarCursoSelecionado() {
        int selectedIndex = cursosList.getSelectedIndex();
        if (selectedIndex != -1) {
            String item = cursosList.getSelectedValue();
            String[] parts = item.split(" - ");
            if (parts.length < 7) {
                JOptionPane.showMessageDialog(this, "Formato inválido.");
                return;
            }
            String idPart = parts[0];
            int id = Integer.parseInt(idPart.substring(4));
            String titulo = parts[1].substring(8);
            int horas = Integer.parseInt(parts[2].substring(7));
            String descricao = parts[3].substring(11);
            String dataInicioStr = parts[4].substring(parts[4].indexOf(":") + 1).trim();
            String dataFimStr = parts[5].substring(parts[5].indexOf(":") + 1).trim();
            String empresa = parts[6].substring(10);

            AlterarCursoView alterarCursoView = new AlterarCursoView(id, titulo, descricao, horas, dataInicioStr, dataFimStr, empresa);
            //JOptionPane.showMessageDialog(this, "Editar Curso com ID: " + id);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListarCursoView view = new ListarCursoView();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        });
    }
}
