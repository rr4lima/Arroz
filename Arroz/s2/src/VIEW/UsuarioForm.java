/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

/**
 *
 * @author aluno.saolucas
 */
public class UsuarioForm extends javax.swing.JInternalFrame {

    UsuarioDAO us = new UsuarioDAO();
    UsuarioDTO ua = new UsuarioDTO();

    public UsuarioForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imgAdd1 = new javax.swing.JLabel();
        imgLimpar1 = new javax.swing.JLabel();
        imgEditar1 = new javax.swing.JLabel();
        imgExcluir1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbUsuarios = new javax.swing.JTable();
        cboPerfilUsu = new javax.swing.JComboBox<>();
        imgProcurar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Login:");

        jLabel4.setText("Senha:");

        imgAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/adicionar.png"))); // NOI18N
        imgAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgAdd1MousePressed(evt);
            }
        });

        imgLimpar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/limpar.png"))); // NOI18N
        imgLimpar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgLimpar1MousePressed(evt);
            }
        });

        imgEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/editar.png"))); // NOI18N
        imgEditar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgEditar1MousePressed(evt);
            }
        });

        imgExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/excluir.png"))); // NOI18N
        imgExcluir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgExcluir1MousePressed(evt);
            }
        });

        TbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID:", "Nome:", "Login:", "Senha:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TbUsuarios);

        cboPerfilUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPerfilUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPerfilUsuActionPerformed(evt);
            }
        });

        imgProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VIEW/procurar.png"))); // NOI18N
        imgProcurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imgProcurarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(cboPerfilUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtSenha)
                            .addComponent(txtLogin)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(imgAdd1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imgLimpar1)
                        .addGap(12, 12, 12)
                        .addComponent(imgEditar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imgExcluir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imgProcurar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgExcluir1)
                    .addComponent(imgEditar1)
                    .addComponent(imgLimpar1)
                    .addComponent(imgAdd1)
                    .addComponent(imgProcurar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(cboPerfilUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void btnAdcMousePressed(java.awt.event.MouseEvent evt) {

    }


    private void cboPerfilUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPerfilUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPerfilUsuActionPerformed

    private void imgExcluir1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgExcluir1MousePressed
        UsuarioDTO DTOedit = new UsuarioDTO();
        DTOedit.setId_usuario(Integer.parseInt(txtId.getText()));
        DTOedit.setLogin_usuario(txtLogin.getText());
        DTOedit.setNome_usuario(txtNome.getText());
        DTOedit.setSenha_usuario(txtSenha.getText());

        UsuarioDAO DAOedit = new UsuarioDAO();
        DAOedit.deletar(DTOedit);
    }//GEN-LAST:event_imgExcluir1MousePressed

    private void imgProcurarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgProcurarMousePressed
        us.PesquisaAuto();
    }//GEN-LAST:event_imgProcurarMousePressed

    private void imgEditar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgEditar1MousePressed
        UsuarioDTO DTOedit = new UsuarioDTO();
        DTOedit.setId_usuario(Integer.parseInt(txtId.getText()));
        DTOedit.setLogin_usuario(txtLogin.getText());
        DTOedit.setNome_usuario(txtNome.getText());
        DTOedit.setSenha_usuario(txtSenha.getText());

        UsuarioDAO DAOedit = new UsuarioDAO();
        DAOedit.editar(DTOedit);


    }//GEN-LAST:event_imgEditar1MousePressed

    private void imgLimpar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLimpar1MousePressed
        us.limparCampos();
    }//GEN-LAST:event_imgLimpar1MousePressed

    private void imgAdd1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgAdd1MousePressed
        ua.setId_usuario(Integer.parseInt(txtId.getText()));
        ua.setNome_usuario(txtNome.getText());
        ua.setLogin_usuario(txtLogin.getText());
        ua.setSenha_usuario(txtSenha.getText());
        ua.setPerfil_usuario((String) cboPerfilUsu.getSelectedItem());

        us.inserirUsuario(ua);
    }//GEN-LAST:event_imgAdd1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TbUsuarios;
    private javax.swing.JComboBox<String> cboPerfilUsu;
    private javax.swing.JLabel imgAdd1;
    private javax.swing.JLabel imgEditar1;
    private javax.swing.JLabel imgExcluir1;
    private javax.swing.JLabel imgLimpar1;
    private javax.swing.JLabel imgProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
