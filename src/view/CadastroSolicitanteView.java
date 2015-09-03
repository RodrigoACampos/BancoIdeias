/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.TelaPrincipalController;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author joao_petri
 */
public class CadastroSolicitanteView extends javax.swing.JPanel {

    

    /**
     * Creates new form CadastroSolicitanteView
     */
    public CadastroSolicitanteView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbIdeia = new javax.swing.JTable();
        btnAdiconarIdeia = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ftfTelefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfEmail1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ftfTelefone1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbObrigatorioNome = new javax.swing.JLabel();
        lbObrigatorioEmail = new javax.swing.JLabel();
        lbObrigatorioTelefone = new javax.swing.JLabel();
        lbObrigatorioInfo = new javax.swing.JLabel();
        btnRemoverIdeia = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro Solicitante", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setText("Nome Completo:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setActionCommand("SolicitanteCadastroSalvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("SolicitanteCancelar");

        tbIdeia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tema"
            }
        ));
        jScrollPane1.setViewportView(tbIdeia);

        btnAdiconarIdeia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ideia16x16.png"))); // NOI18N
        btnAdiconarIdeia.setText("Cadastro Ideia");
        btnAdiconarIdeia.setActionCommand("SolicitanteCadastroAddIdeia");

        jLabel3.setText("Email:");

        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Telefone:");

        jLabel2.setText("Minhas Ideias:");

        jLabel4.setText("Email:");

        try {
            ftfTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Telefone:");

        jLabel7.setText("Minhas Ideias:");

        lbObrigatorioNome.setForeground(new java.awt.Color(255, 0, 0));
        lbObrigatorioNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbObrigatorioNome.setText("*");

        lbObrigatorioEmail.setForeground(new java.awt.Color(255, 0, 0));
        lbObrigatorioEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbObrigatorioEmail.setText("*");

        lbObrigatorioTelefone.setForeground(new java.awt.Color(255, 0, 0));
        lbObrigatorioTelefone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbObrigatorioTelefone.setText("*");

        lbObrigatorioInfo.setForeground(new java.awt.Color(255, 0, 0));
        lbObrigatorioInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbObrigatorioInfo.setText("Preencha os Campos Marcados com \" * \"");

        btnRemoverIdeia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ideia16x16.png"))); // NOI18N
        btnRemoverIdeia.setText("Remover Ideia");
        btnRemoverIdeia.setActionCommand("AlunoCadastroDelIdeia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObrigatorioInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdiconarIdeia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverIdeia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbObrigatorioEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbObrigatorioTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbObrigatorioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbObrigatorioNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbObrigatorioEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbObrigatorioTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdiconarIdeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoverIdeia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbObrigatorioInfo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnAdiconarIdeia() {
        return btnAdiconarIdeia;
    }

    public JButton getBtnRemoverIdeia() {
        return btnRemoverIdeia;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JTable getTbIdeia() {
        return tbIdeia;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public JLabel getLbObrigatorioEmail() {
        return lbObrigatorioEmail;
    }

    public JLabel getLbObrigatorioInfo() {
        return lbObrigatorioInfo;
    }

    public JLabel getLbObrigatorioNome() {
        return lbObrigatorioNome;
    }

    public JLabel getLbObrigatorioTelefone() {
        return lbObrigatorioTelefone;
    }

    public javax.swing.JFormattedTextField getFtfTelefone() {
        return ftfTelefone;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdiconarIdeia;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverIdeia;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JFormattedTextField ftfTelefone1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbObrigatorioEmail;
    private javax.swing.JLabel lbObrigatorioInfo;
    private javax.swing.JLabel lbObrigatorioNome;
    private javax.swing.JLabel lbObrigatorioTelefone;
    private javax.swing.JTable tbIdeia;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

}
