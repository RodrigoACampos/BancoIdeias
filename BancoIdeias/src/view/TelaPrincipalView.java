/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
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

        jpfundo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        setPreferredSize(new java.awt.Dimension(900, 725));

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
        btnCadastroProfessor.setActionCommand("cadastroProfessor");
        btnCadastroProfessor.setContentAreaFilled(false);

        btnConsultaProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaProfessor.setActionCommand("consultaProfessor");
        btnConsultaProfessor.setContentAreaFilled(false);

        btnCadastroSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/solic.png"))); // NOI18N
        btnCadastroSolicitante.setActionCommand("cadastroSolicitante");
        btnCadastroSolicitante.setContentAreaFilled(false);

        btnConsultaSolicitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaSolicitante.setActionCommand("consultaSolicitante");
        btnConsultaSolicitante.setContentAreaFilled(false);

        btnCadastroAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alunos.png"))); // NOI18N
        btnCadastroAluno.setActionCommand("cadastroAluno");
        btnCadastroAluno.setBorderPainted(false);
        btnCadastroAluno.setContentAreaFilled(false);
        btnCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroAlunoActionPerformed(evt);
            }
        });

        btnConsultaAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaAluno.setActionCommand("consultaAluno");
        btnConsultaAluno.setContentAreaFilled(false);
        btnConsultaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaAlunoActionPerformed(evt);
            }
        });

        btnConsultaIdeias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Consulta.png"))); // NOI18N
        btnConsultaIdeias.setActionCommand("consultaIdeias");
        btnConsultaIdeias.setContentAreaFilled(false);

        btnCadastroIdeia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jabber.png"))); // NOI18N
        btnCadastroIdeia.setActionCommand("cadastroIdeia");
        btnCadastroIdeia.setContentAreaFilled(false);
        btnCadastroIdeia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/turn_off.png"))); // NOI18N
        btnSair.setActionCommand("sair");
        btnSair.setContentAreaFilled(false);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sair");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCadastroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCadastroSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCadastroIdeia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(btnConsultaIdeias, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConsultaIdeias, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCadastroIdeia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConsultaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCadastroAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnConsultaProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCadastroProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnCadastroSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConsultaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alunos32x32.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/professor32x32.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/solic32x32.png"))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ideia24x24.png"))); // NOI18N
        jLabel9.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText(": 33");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText(": 33");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText(": 33");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText(": 33");

        aluno.setText("Aluno");

        menuCadastroAluno.setText("Cadastro");
        menuCadastroAluno.setActionCommand("menuCadAluno");
        menuCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroAlunoActionPerformed(evt);
            }
        });
        aluno.add(menuCadastroAluno);

        menuConsultaAluno.setText("Consulta");
        menuConsultaAluno.setActionCommand("menuConAluno");
        aluno.add(menuConsultaAluno);

        jMenuBar1.add(aluno);

        professor.setText("Professor");

        menuCadastroProfessor.setText("Cadastro");
        menuCadastroProfessor.setActionCommand("menuCadProfessor");
        professor.add(menuCadastroProfessor);

        menuConsultaProfessor.setText("Consulta");
        menuConsultaProfessor.setActionCommand("menuConProfessor");
        professor.add(menuConsultaProfessor);

        jMenuBar1.add(professor);

        solicitante.setText("Solicitante");

        menuCadastroSolicitante.setText("Cadastro");
        menuCadastroSolicitante.setActionCommand("menuCadSolicitante");
        solicitante.add(menuCadastroSolicitante);

        menuConsultaSolicitante.setText("Consulta");
        menuConsultaSolicitante.setActionCommand("menuConSolicitante");
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
        menuSair.setActionCommand("menuSair");
        Sair.add(menuSair);

        jMenuBar1.add(Sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))))
                .addGap(86, 86, 86)
                .addComponent(jpfundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpfundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
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
    
    
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Sair;
    private javax.swing.JMenu aluno;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JMenu professor;
    private javax.swing.JMenu solicitante;
    // End of variables declaration//GEN-END:variables
}
