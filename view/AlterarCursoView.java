package br.com.avaliacao.view;

import br.com.avaliacao.controller.CursoController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlterarCursoView extends JFrame {

    private int cursoId;
    private CursoController c;
    private JTextField titulof;
    private JTextField descricaof;
    private JTextField horasf;
    private JTextField dataIniciof;
    private JTextField dataFimf;
    private JTextField empresaf;
    private JButton btnSalvar;

    public AlterarCursoView(int cursoId, String titulo, String descricao, int horas, String dataInicio, String dataFim, String empresa) {
        this.cursoId = cursoId;
        this.c = new CursoController();
        setTitle("Cursos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel label = new JLabel("Título:");
        titulof = new JTextField(titulo);
        titulof.setPreferredSize(new Dimension(200, 25));

        JLabel labe2 = new JLabel("Descrição:");
        descricaof = new JTextField(descricao);
        descricaof.setPreferredSize(new Dimension(200, 25));

        JLabel labe3 = new JLabel("Horas:");
        horasf = new JTextField(String.valueOf(horas));
        horasf.setPreferredSize(new Dimension(200, 25));

        JLabel labe4 = new JLabel("Data Início:");
        dataIniciof = new JTextField(dataInicio);
        dataIniciof.setPreferredSize(new Dimension(200, 25));

        JLabel labe5 = new JLabel("Data Fim:");
        dataFimf = new JTextField(dataFim);
        dataFimf.setPreferredSize(new Dimension(200, 25));

        JLabel labe6 = new JLabel("Empresa:");
        empresaf = new JTextField(empresa);
        empresaf.setPreferredSize(new Dimension(200, 25));

        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracao();
            }
        });

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
        panel.add(new JLabel());
        panel.add(btnSalvar, BorderLayout.SOUTH);

        mainPanel.add(panel, BorderLayout.CENTER);
        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void salvarAlteracao() {
        String titulo = titulof.getText();
        String descricao = descricaof.getText();
        int horas = Integer.parseInt(horasf.getText());
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(dataIniciof.getText());
        LocalDate dataFim = LocalDate.parse(dataFimf.getText());
        String empresa = empresaf.getText();

        c.atualizar(cursoId, titulo, descricao, horas, dataInicio, dataFim, empresa);

        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        CadastroCursoView cadastroCursoView = new CadastroCursoView();
        cadastroCursoView.setVisible(true);
    }
}
