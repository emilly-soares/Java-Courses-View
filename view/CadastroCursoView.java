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
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroCursoView extends JFrame {

    private final JTextField titulof;
    private final JTextField descricaof;
    private final JTextField horasf;
    private final JTextField dataIniciof;
    private final JTextField dataFimf;
    private final JTextField empresaf;
    private final CursoController c;

    public CadastroCursoView() {
        c = new CursoController();
        setTitle("Cursos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(14, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Título:");
        titulof = new JTextField();
        titulof.setPreferredSize(new Dimension(200, 25));

        JLabel labe2 = new JLabel("Descrição:");
        descricaof = new JTextField();
        descricaof.setPreferredSize(new Dimension(200, 25));

        JLabel labe3 = new JLabel("Horas:");
        horasf = new JTextField();
        horasf.setPreferredSize(new Dimension(200, 25));

        JLabel labe4 = new JLabel("Data Início:");
        dataIniciof = new JTextField();
        dataIniciof.setPreferredSize(new Dimension(200, 25));

        JLabel labe5 = new JLabel("Data Fim:");
        dataFimf = new JTextField();
        dataFimf.setPreferredSize(new Dimension(200, 25));

        JLabel labe6 = new JLabel("Empresa:");
        empresaf = new JTextField();
        empresaf.setPreferredSize(new Dimension(200, 25));

        JButton cadastrarb = new JButton("Cadastrar");
        cadastrarb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastrarCurso();
                } catch (Exception ex) {
                    Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton listagemb = new JButton("Listagem");
        listagemb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarCursoView().setVisible(true);
                //dispose();
            }
        }
        );

        JButton contabilizarb = new JButton("Contablizar h Total");

        contabilizarb.addActionListener(
                (ActionEvent e) -> {
                    try {
                        contabilizarCurso();
                    } catch (Exception ex) {
                        Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        JButton listarPeriodob = new JButton("Listar Cursos Período");

        listarPeriodob.addActionListener(
                (ActionEvent e) -> {
                    try {
                        listarPeriodo();
                    } catch (Exception ex) {
                        Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        JButton contabilizarHorasPeriodob = new JButton("Contablizar h Período");

        contabilizarHorasPeriodob.addActionListener(
                (ActionEvent e) -> {
                    try {
                        contabilizarHorasPeriodo();
                    } catch (Exception ex) {
                        Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        JButton listarFinalizadosb = new JButton("Listar Finalizados");

        listarFinalizadosb.addActionListener(
                (ActionEvent e) -> {
                    try {
                        listarFinalizados();
                    } catch (Exception ex) {
                        Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        JButton pesquisarTitulob = new JButton("Pesquisar Título");

        pesquisarTitulob.addActionListener(
                (ActionEvent e) -> {
                    try {
                        pesquisarTitulo();
                    } catch (Exception ex) {
                        Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        JButton pesquisarEmpresab = new JButton("Pesquisar Empresa");

        pesquisarEmpresab.addActionListener(
                (ActionEvent e) -> {
                    try {
                        pesquisarEmpresa();
                    } catch (Exception ex) {
                        Logger.getLogger(CadastroCursoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        panel.add(label);

        panel.add(titulof);

        panel.add(labe2);

        panel.add(descricaof);

        panel.add(labe3);

        panel.add(horasf);

        panel.add(labe4);

        panel.add(dataIniciof);

        panel.add(labe5);

        panel.add(dataFimf);

        panel.add(labe6);

        panel.add(empresaf);

        panel.add(
                new JLabel());
        panel.add(cadastrarb);

        panel.add(
                new JLabel());
        panel.add(listagemb);

        panel.add(
                new JLabel());
        panel.add(contabilizarb);

        panel.add(
                new JLabel());
        panel.add(listarPeriodob);

        panel.add(
                new JLabel());
        panel.add(contabilizarHorasPeriodob);

        panel.add(
                new JLabel());
        panel.add(listarFinalizadosb);

        panel.add(
                new JLabel());
        panel.add(pesquisarTitulob);

        panel.add(
                new JLabel());
        panel.add(pesquisarEmpresab);

        mainPanel.add(panel, BorderLayout.CENTER);

        getContentPane()
                .add(mainPanel);

        pack();

        setLocationRelativeTo(
                null);
    }

    private void cadastrarCurso() throws Exception {
        String titulo = titulof.getText();
        String descricao = descricaof.getText();
        int horas = Integer.parseInt(horasf.getText());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(dataIniciof.getText(), dtf);
        LocalDate dataFim = LocalDate.parse(dataFimf.getText(), dtf);
        String empresa = empresaf.getText();

        c.cadastrarCurso(titulo, descricao, horas, dataInicio, dataFim, empresa);
        JOptionPane.showMessageDialog(this, "Curso cadastrado com sucesso!");

        titulof.setText("");
        descricaof.setText("");
        horasf.setText("");
        dataIniciof.setText("");
        dataFimf.setText("");
        empresaf.setText("");
    }

    private void contabilizarCurso() throws Exception {
        c.carregarLista();
        int aux = 0;
        for (Curso cm : c.getCursos()) {
            aux = aux + cm.getHoras();
        }
        JOptionPane.showMessageDialog(null, "\nSoma Carga Horária: " + aux);
    }

    public void listarPeriodo() throws Exception {
        c.carregarLista();
        StringBuilder mensagem = new StringBuilder("--Buscar por Período---\n");
        int anoI = Integer.parseInt(JOptionPane.showInputDialog("Ano de início:"));
        int anoF = Integer.parseInt(JOptionPane.showInputDialog("Ano de fim:"));
        for (Curso cm : c.getCursos()) {
            int yf = cm.getDataFim().getYear();
            if (yf >= anoI && yf <= anoF) {
                mensagem.append("Início ").append(anoI).append(" fim ").append(anoF).append(" ano lista").append(yf).append("\n")
                        .append("id: ").append(cm.getId()).append("\n")
                        .append("titulo: ").append(cm.getTitulo()).append("\n")
                        .append("descricao: ").append(cm.getDescricao()).append("\n")
                        .append("carga horária: ").append(cm.getHoras()).append("\n")
                        .append("data início: ").append(cm.getDataInicio()).append("\n")
                        .append("data fim: ").append(cm.getDataFim()).append("\n\n");
            }
        }
        String message = mensagem.toString();
        JScrollPane scrollPane = new JScrollPane(new JTextArea(message));
        scrollPane.setPreferredSize(new Dimension(600, 400));
        JOptionPane.showMessageDialog(null, scrollPane, "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }

    public void contabilizarHorasPeriodo() throws Exception {
        c.carregarLista();
        int anoI = Integer.parseInt(JOptionPane.showInputDialog("Ano de início:"));
        int anoF = Integer.parseInt(JOptionPane.showInputDialog("Ano de fim:"));
        int aux = 0;
        for (Curso cm : c.getCursos()) {
            int yi = cm.getDataInicio().getYear();
            int yf = cm.getDataFim().getYear();
            if (yf >= anoI && yf <= anoF) {
                aux = aux + cm.getHoras();
            }
        }
        JOptionPane.showMessageDialog(null, "Carga horária do período: " + aux);

    }

    public void listarFinalizados() throws Exception {
        c.carregarLista();
        StringBuilder mensagem = new StringBuilder("---Cursos Concluídos:---\n");

        for (Curso cm : c.getCursos()) {
            LocalDate di = LocalDate.now();
            if (cm.getDataFim().compareTo(di) <= 0) {
                mensagem.append("\nid: ").append(cm.getId()).append("\n")
                        .append("titulo: ").append(cm.getTitulo()).append("\n")
                        .append("descricao: ").append(cm.getDescricao()).append("\n")
                        .append("carga horária: ").append(cm.getHoras()).append("\n")
                        .append("data início: ").append(cm.getDataInicio()).append("\n")
                        .append("data fim: ").append(cm.getDataFim()).append("\n\n");
            }
        }

        String message = mensagem.toString();
        JTextArea textArea = new JTextArea(message);
        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Cursos Concluídos", JOptionPane.INFORMATION_MESSAGE);

    }

    public void pesquisarTitulo() throws Exception {
        String titulo = JOptionPane.showInputDialog(null, "Digite o Título:", "Buscar por Título", JOptionPane.PLAIN_MESSAGE);

        c.carregarLista();
        c.buscarCursoPorTitulo(titulo);

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("---Cursos Encontrados---\n");

        for (Curso cm : c.getCursos()) {
            mensagem.append("\nid: ").append(cm.getId()).append("\n")
                    .append("titulo: ").append(cm.getTitulo()).append("\n")
                    .append("descricao: ").append(cm.getDescricao()).append("\n")
                    .append("carga horária: ").append(cm.getHoras()).append("\n")
                    .append("data inicio: ").append(cm.getDataInicio()).append("\n")
                    .append("data fim: ").append(cm.getDataFim()).append("\n")
                    .append("empresa: ").append(cm.getEmpresa()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString(), "Cursos Encontrados", JOptionPane.INFORMATION_MESSAGE);
    }

    public void pesquisarEmpresa() throws Exception {
        c.carregarLista();
        String empresa = JOptionPane.showInputDialog(null, "Digite a Empresa:", "Buscar por Empresa", JOptionPane.PLAIN_MESSAGE);

        c.buscarCursoPorEmpresa(empresa);

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("---Cursos Encontrados---\n");

        for (Curso cm : c.getCursos()) {
            mensagem.append("\nid: ").append(cm.getId()).append("\n")
                    .append("titulo: ").append(cm.getTitulo()).append("\n")
                    .append("descricao: ").append(cm.getDescricao()).append("\n")
                    .append("carga horária: ").append(cm.getHoras()).append("\n")
                    .append("data inicio: ").append(cm.getDataInicio()).append("\n")
                    .append("data fim: ").append(cm.getDataFim()).append("\n")
                    .append("empresa: ").append(cm.getEmpresa()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString(), "Cursos Encontrados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        CadastroCursoView cadCursoView = new CadastroCursoView();
        cadCursoView.setVisible(true);
    }
}
