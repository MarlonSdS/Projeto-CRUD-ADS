
package univs.edu.telas;

import javax.swing.JOptionPane;
import univs.edu.usuario.Usuario;
import univs.edu.usuario.UsuarioDAO;
import univs.edu.usuario.UsuarioTableModel;

/**
 *
 * @author Marlon Santana dos S
 */
public class ConsultarUsuarios extends javax.swing.JFrame {
    
    Usuario usuario = new Usuario();
    UsuarioDAO dao = new UsuarioDAO();

    /**
     * Creates new form ConsultarUsuarios
     */
    public ConsultarUsuarios() {
        initComponents();
        atualizarTabela();
    }
    
    public void atualizarTabela(){
        UsuarioTableModel tm = new UsuarioTableModel(dao.pesquisar());
        tbUsuarios.setModel(tm);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnExcluir1 = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbUsuarios);

        btnExcluir1.setText("Excluir");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(93, 93, 93)
                        .addComponent(btnEditar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(317, Short.MAX_VALUE)
                    .addComponent(btnExcluir1)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditar))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(256, Short.MAX_VALUE)
                    .addComponent(btnExcluir1)
                    .addGap(21, 21, 21)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/*
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
     
    }//GEN-LAST:event_btnExcluirActionPerformed
*/
    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        int linha = tbUsuarios.getSelectedRow();
        if (linha != -1){
            int id = (int) tbUsuarios.getValueAt(linha, 0);
            usuario = dao.pesquisar(id);
            dao.excluir(usuario);
            atualizarTabela();
            JOptionPane.showMessageDialog(null, "Usuário Excluído!");
        } else{          
           JOptionPane.showMessageDialog(null, "Selecione uma linha!");
       }
        
    }//GEN-LAST:event_btnExcluir1ActionPerformed
    
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaUsuario tela1 = new TelaUsuario();
        tela1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tbUsuarios.getSelectedRow();
       if(linha == -1){
           JOptionPane.showMessageDialog(null, "Selecione um Usuário!");
       }else{
           usuario = dao.pesquisar((int) tbUsuarios.getValueAt(linha, 0));
           TelaUsuario tUsuario = new TelaUsuario();
           tUsuario.usuario = usuario;
           tUsuario.atualizarCampos();
           tUsuario.setVisible(true);
           dispose();
    }//GEN-LAST:event_btnEditarActionPerformed
    }
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
            java.util.logging.Logger.getLogger(ConsultarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
