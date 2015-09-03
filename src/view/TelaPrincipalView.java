/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
// aaaaaaaaaaaaaateste

public class TelaPrincipalView extends javax.swing.JFrame {

    public TelaPrincipalView() {
        initComponents();     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBotoesIniciar = new javax.swing.ButtonGroup();
        jpfundo = new javax.swing.JPanel();
        pnlBarraFerramenta = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCadastroProfessor = new javax.swing.JButton();
        btnConsultaProfessor = new javax.swing.JButton();
        btnCadastroSolicitante = new javax.swing.JButton();
        btnConsultaSolicitante = new javax.swing.JButton();
        btnCadastroAluno = new javax.swing.JButton();
        btnConsultaAluno = new javax.swing.JButton();
        btnConsultaIdeias = new javax.swing.JButton();
        btnCadastroIdeia = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnSair = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        LblValorQtdeAluno = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        LblValorQtdeProfessor = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        LblValorQtdeSolicitante = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        LblValorQtdeIdeia = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        aluno = new javax.swing.JMenu();
        menuCadastroAluno = new javax.swing.JMenuItem();
        menuConsultaAluno = new javax.swing.JMenuItem();
        professor = new javax.swing.JMenu();
        menuCadastroProfessor = new javax.swing.JMenuItem();
        menuConsultaProfessor = new javax.swing.JMenuItem();
        solicitante = new javax.swing.JMenu();
        menuCadastroSolicitante = new javax.swing.JMenuItem();
        menuConsultaSolicitante = new javax.swing.JMenuItem();
        ideias = new javax.swing.JMenu();
        menuCadastroIdeia = new javax.swing.JMenuItem();
        menuConsultaIdeia = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Banco de Idéias");

        jpfundo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpfundo.setLayout(new java.awt.CardLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aluno");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Professor");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Solicitante");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ideias");

        btnCadastroProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/professor.png"))); // NOI18N
        btnCadastroProfessor.setActionCommand("ProfessorCadastrar");
        bgBotoesIniciar.add(btnCadastroProfessor);
        btnCadastroProfessor.setContentAreaFilled(false);

        btnConsultaProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaProfessor.setActionCommand("ProfessorConsulta");
        bgBotoesIniciar.add(btnConsultaProfessor);
        btnConsultaProfessor.setContentAreaFilled(false);

        btnCadastroSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/solic.png"))); // NOI18N
        btnCadastroSolicitante.setActionCommand("SolicitanteCadastrar");
        bgBotoesIniciar.add(btnCadastroSolicitante);
        btnCadastroSolicitante.setContentAreaFilled(false);

        btnConsultaSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaSolicitante.setActionCommand("SolicitanteConsulta");
        bgBotoesIniciar.add(btnConsultaSolicitante);
        btnConsultaSolicitante.setContentAreaFilled(false);

        btnCadastroAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alunos.png"))); // NOI18N
        btnCadastroAluno.setActionCommand("AlunoCadastrar");
        btnCadastroAluno.setBorderPainted(false);
        bgBotoesIniciar.add(btnCadastroAluno);
        btnCadastroAluno.setContentAreaFilled(false);
        btnCadastroAluno.setFocusPainted(false);
        btnCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroAlunoActionPerformed(evt);
            }
        });

        btnConsultaAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaAluno.setActionCommand("AlunoConsulta");
        bgBotoesIniciar.add(btnConsultaAluno);
        btnConsultaAluno.setContentAreaFilled(false);
        btnConsultaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaAlunoActionPerformed(evt);
            }
        });

        btnConsultaIdeias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaIdeias.setActionCommand("consultaIdeias");
        bgBotoesIniciar.add(btnConsultaIdeias);
        btnConsultaIdeias.setContentAreaFilled(false);

        btnCadastroIdeia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jabber.png"))); // NOI18N
        btnCadastroIdeia.setActionCommand("cadastroIdeia");
        bgBotoesIniciar.add(btnCadastroIdeia);
        btnCadastroIdeia.setContentAreaFilled(false);
        btnCadastroIdeia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/turn_off.png"))); // NOI18N
        btnSair.setToolTipText("");
        btnSair.setActionCommand("PrincipalSair");
        bgBotoesIniciar.add(btnSair);
        btnSair.setContentAreaFilled(false);
        btnSair.setPreferredSize(new java.awt.Dimension(97, 73));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sair");

        javax.swing.GroupLayout pnlBarraFerramentaLayout = new javax.swing.GroupLayout(pnlBarraFerramenta);
        pnlBarraFerramenta.setLayout(pnlBarraFerramentaLayout);
        pnlBarraFerramentaLayout.setHorizontalGroup(
            pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(btnCadastroAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(btnCadastroProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(btnCadastroSolicitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaSolicitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(btnCadastroIdeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaIdeias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlBarraFerramentaLayout.setVerticalGroup(
            pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadastroIdeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultaIdeias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBarraFerramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnConsultaProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCadastroProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCadastroSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBarraFerramentaLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));

        LblValorQtdeAluno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblValorQtdeAluno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alunos32x32.png"))); // NOI18N

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Aluno(s)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblValorQtdeAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18))
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblValorQtdeAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 1, true));

        LblValorQtdeProfessor.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblValorQtdeProfessor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/professor32x32.png"))); // NOI18N

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Professor(s)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblValorQtdeProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18))
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblValorQtdeProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 102), 1, true));

        LblValorQtdeSolicitante.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblValorQtdeSolicitante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/solic32x32.png"))); // NOI18N

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Solicitante(s)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblValorQtdeSolicitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addGap(18, 18, 18))
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblValorQtdeSolicitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 102), 1, true));

        LblValorQtdeIdeia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LblValorQtdeIdeia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ideia32x32.png"))); // NOI18N

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Ideia(s)");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblValorQtdeIdeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addGap(18, 18, 18))
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblValorQtdeIdeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        aluno.setText("Aluno");

        menuCadastroAluno.setText("Cadastro");
        menuCadastroAluno.setActionCommand("AlunoCadastrar");
        menuCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroAlunoActionPerformed(evt);
            }
        });
        aluno.add(menuCadastroAluno);

        menuConsultaAluno.setText("Consulta");
        menuConsultaAluno.setActionCommand("AlunoConsulta");
        aluno.add(menuConsultaAluno);

        jMenuBar1.add(aluno);

        professor.setText("Professor");

        menuCadastroProfessor.setText("Cadastro");
        menuCadastroProfessor.setActionCommand("ProfessorCadastrar");
        professor.add(menuCadastroProfessor);

        menuConsultaProfessor.setText("Consulta");
        menuConsultaProfessor.setActionCommand("ProfessorConsulta");
        professor.add(menuConsultaProfessor);

        jMenuBar1.add(professor);

        solicitante.setText("Solicitante");

        menuCadastroSolicitante.setText("Cadastro");
        menuCadastroSolicitante.setActionCommand("SolicitanteCadastrar");
        solicitante.add(menuCadastroSolicitante);

        menuConsultaSolicitante.setText("Consulta");
        menuConsultaSolicitante.setActionCommand("SolicitanteConsulta");
        solicitante.add(menuConsultaSolicitante);

        jMenuBar1.add(solicitante);

        ideias.setText("Ideias");

        menuCadastroIdeia.setText("Cadastro");
        menuCadastroIdeia.setActionCommand("menuCadIdeia");
        ideias.add(menuCadastroIdeia);

        menuConsultaIdeia.setText("Consulta");
        menuConsultaIdeia.setActionCommand("menuConIdeia");
        ideias.add(menuConsultaIdeia);

        jMenuBar1.add(ideias);

        Sair.setText("Sair");

        menuSair.setText("Sair");
        menuSair.setActionCommand("PrincipalSair");
        Sair.add(menuSair);

        jMenuBar1.add(Sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBarraFerramenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpfundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlBarraFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 203, Short.MAX_VALUE))
                    .addComponent(jpfundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultaAlunoActionPerformed

    private void menuCadastroAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroAlunoActionPerformed

    private void btnCadastroAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroAlunoActionPerformed
        
    }//GEN-LAST:event_btnCadastroAlunoActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaPrincipalView().setVisible(true);
//            }
//        });
//    }

    public JButton getBtnCadastroAluno() {
        return btnCadastroAluno;
    }

    public JButton getBtnCadastroProfessor() {
        return btnCadastroProfessor;
    }

    public JButton getBtnCadastroSolicitante() {
        return btnCadastroSolicitante;
    }

    public JButton getBtnConsultaAluno() {
        return btnConsultaAluno;
    }

    public JButton getBtnConsultaIdeias() {
        return btnConsultaIdeias;
    }

    public JButton getBtnConsultaProfessor() {
        return btnConsultaProfessor;
    }

    public JButton getBtnConsultaSolicitante() {
        return btnConsultaSolicitante;
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public JPanel getJpfundo() {
        return jpfundo;
    }

    public JMenuItem getMenuCadastroAluno() {
        return menuCadastroAluno;
    }

    public JMenuItem getMenuCadastroProfessor() {
        return menuCadastroProfessor;
    }

    public JMenuItem getMenuCadastroSolicitante() {
        return menuCadastroSolicitante;
    }

    public JMenuItem getMenuConsultaAluno() {
        return menuConsultaAluno;
    }

    public JMenuItem getMenuConsultaIdeia() {
        return menuConsultaIdeia;
    }

    public JMenuItem getMenuConsultaProfessor() {
        return menuConsultaProfessor;
    }

    public JMenuItem getMenuConsultaSolicitante() {
        return menuConsultaSolicitante;
    }

    public JMenuItem getMenuSair() {
        return menuSair;
    }

    public JButton getBtnCadastroIdeia() {
        return btnCadastroIdeia;
    }

    public JMenuItem getMenuCadastroIdeia() {
        return menuCadastroIdeia;
    }

    public JLabel getLblValorQtdeAluno() {
        return LblValorQtdeAluno;
    }

    public JLabel getLblValorQtdeIdeia() {
        return LblValorQtdeIdeia;
    }

    public JLabel getLblValorQtdeProfessor() {
        return LblValorQtdeProfessor;
    }

    public JLabel getLblValorQtdeSolicitante() {
        return LblValorQtdeSolicitante;
    }

    public JPanel getPnlBarraFerramenta() {
        return pnlBarraFerramenta;
    }
                       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblValorQtdeAluno;
    private javax.swing.JLabel LblValorQtdeIdeia;
    private javax.swing.JLabel LblValorQtdeProfessor;
    private javax.swing.JLabel LblValorQtdeSolicitante;
    private javax.swing.JMenu Sair;
    private javax.swing.JMenu aluno;
    private javax.swing.ButtonGroup bgBotoesIniciar;
    private javax.swing.JButton btnCadastroAluno;
    private javax.swing.JButton btnCadastroIdeia;
    private javax.swing.JButton btnCadastroProfessor;
    private javax.swing.JButton btnCadastroSolicitante;
    private javax.swing.JButton btnConsultaAluno;
    private javax.swing.JButton btnConsultaIdeias;
    private javax.swing.JButton btnConsultaProfessor;
    private javax.swing.JButton btnConsultaSolicitante;
    private javax.swing.JButton btnSair;
    private javax.swing.JMenu ideias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel jpfundo;
    private javax.swing.JMenuItem menuCadastroAluno;
    private javax.swing.JMenuItem menuCadastroIdeia;
    private javax.swing.JMenuItem menuCadastroProfessor;
    private javax.swing.JMenuItem menuCadastroSolicitante;
    private javax.swing.JMenuItem menuConsultaAluno;
    private javax.swing.JMenuItem menuConsultaIdeia;
    private javax.swing.JMenuItem menuConsultaProfessor;
    private javax.swing.JMenuItem menuConsultaSolicitante;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JPanel pnlBarraFerramenta;
    private javax.swing.JMenu professor;
    private javax.swing.JMenu solicitante;
    // End of variables declaration//GEN-END:variables

    public javax.swing.ButtonGroup getBgBotoesIniciar() {
        return bgBotoesIniciar;
    }

    public void setBgBotoesIniciar(javax.swing.ButtonGroup bgBotoesIniciar) {
        this.bgBotoesIniciar = bgBotoesIniciar;
    }
}
