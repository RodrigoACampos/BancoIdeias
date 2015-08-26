/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Gustavo
 */
public class ConsultaProfessorView extends javax.swing.JPanel {

    /**
     * Creates new form CadastroProfessorView
     */
    public ConsultaProfessorView() {
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

        jPanel2 = new javax.swing.JPanel();
        btnExcluirProfessor = new javax.swing.JButton();
        btnAlterarProfessor = new javax.swing.JButton();
        jScrollPaneCProfessor = new javax.swing.JScrollPane();
        jTableProfessor = new javax.swing.JTable();
        lbProfessorView = new javax.swing.JLabel();
        tfBuscaProfessor = new javax.swing.JTextField();
        btnBuscaProfessor = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Professor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        btnExcluirProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Trash.png"))); // NOI18N
        btnExcluirProfessor.setText("Excluir");

        btnAlterarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sync.png"))); // NOI18N
        btnAlterarProfessor.setText("Alterar");
        btnAlterarProfessor.setActionCommand("alterar");
        btnAlterarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProfessorActionPerformed(evt);
            }
        });

        jTableProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "E-mail", "Matéria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneCProfessor.setViewportView(jTableProfessor);

        lbProfessorView.setText("Nome:");

        tfBuscaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscaProfessorActionPerformed(evt);
            }
        });

        btnBuscaProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Find.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAlterarProfessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirProfessor))
                    .addComponent(jScrollPaneCProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbProfessorView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBuscaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscaProfessor)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfBuscaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbProfessorView)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneCProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirProfessor)
                    .addComponent(btnAlterarProfessor))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("Cadastro Professor");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarProfessorActionPerformed

    private void tfBuscaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscaProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscaProfessorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarProfessor;
    private javax.swing.JButton btnBuscaProfessor;
    private javax.swing.JButton btnExcluirProfessor;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneCProfessor;
    private javax.swing.JTable jTableProfessor;
    private javax.swing.JLabel lbProfessorView;
    private javax.swing.JTextField tfBuscaProfessor;
    // End of variables declaration//GEN-END:variables
}