package br.com.equivalencia.telas;
import br.com.equivalencia.dao.ModuloConexao;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaArea extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Criando o método adicionar
    private void adicionar(){
        String sql = "insert into tb_area_tecnologica(nome_area) values(?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeArea.getText());
            
            //Validando campos de preenchimento obrigatório
            if (txtNomeArea.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos de preenchimento obrigatório está em branco!");
            } else {
                int adicionado = pst.executeUpdate();
                
                if (adicionado > 0){
                    JOptionPane.showMessageDialog(null, "Área Tecnológica cadastrada com sucesso!");
                    txtNomeArea.setText(null);
                    txtNomeArea.requestFocus();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Método para alterar um registro no banco de dados
    private void alterar(){
        String sql = "update tb_area_tecnologica set nome_area=? where id_area=?";
        
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtNomeArea.getText());
            pst.setString(2, txtIdArea.getText());
            
            //Validação dos campos obrigatórios
        if(txtIdArea.getText().isEmpty() || (txtNomeArea.getText(). isEmpty())){
            JOptionPane.showMessageDialog(null, "Campos de Preenchimento");
            
        }else{
                int adicionado = pst.executeUpdate();
                
                if(adicionado > 0){
                
                JOptionPane.showConfirmDialog(null, "Área Tecnológica alterada com sucesso!");
                }
                    
             }
        } catch (Exception e) {
        }
    }
    
    //Método de pesquisa área tecnológica no banco de dados
    private void pesquisar_area(){
        
        String sql = "Select id_area, nome_area from tb_area_tecnologica where nome_area like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisarArea.getText()+"%");
            rs = pst.executeQuery();
            tblArea.setModel(DbUtils.resultSetToTableModel(rs));
                
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    

    public TelaArea() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdArea = new javax.swing.JTextField();
        txtNomeArea = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisarArea = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome Área:");

        txtIdArea.setEnabled(false);

        txtNomeArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeAreaKeyPressed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(67, 24));

        btnEditar.setText("Editar");
        btnEditar.setPreferredSize(new java.awt.Dimension(67, 24));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome Área"
            }
        ));
        jScrollPane1.setViewportView(tblArea);

        jLabel3.setText("Pesquisar:");

        txtPesquisarArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarAreaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarArea, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPesquisarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnCadastrarActionPerformed
    //criando método adicionar
    private void txtNomeAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeAreaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            adicionar();
    }//GEN-LAST:event_txtNomeAreaKeyPressed
    }
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisarAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarAreaKeyReleased
        pesquisar_area();
    }//GEN-LAST:event_txtPesquisarAreaKeyReleased

    
   
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArea;
    private javax.swing.JTextField txtIdArea;
    private javax.swing.JTextField txtNomeArea;
    private javax.swing.JTextField txtPesquisarArea;
    // End of variables declaration//GEN-END:variables
}
