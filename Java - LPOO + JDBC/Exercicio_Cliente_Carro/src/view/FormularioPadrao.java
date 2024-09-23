/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.CarroDAO;
import DAO.PessoaDAO;
import Interfaces.I_CBanco;
import Interfaces.I_PBanco;
import Models.Carro;
import Models.Pessoa;
import exercicio_cliente_carro.MYSQLConector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FormularioPadrao extends javax.swing.JFrame {

    /**
     * Creates new form FormularioPadrao
     */
    public FormularioPadrao() {
        initComponents();
    }

    public boolean verifDuplicidade() {

        int dup_carro = 0;
        int dup_pessoa = 0;
        Connection conn = MYSQLConector.getConect();
        String cpf = textFieldCPF.getText();
        String placa = textFieldPlaca.getText();

        String com1 = "select count(*) as count_p from pessoa where CPF = ?";
        String com2 = "select count(*) as count_c from carro where Placa = ?";

        try {

            PreparedStatement pstm = conn.prepareStatement(com1);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();

            PreparedStatement pstm2 = conn.prepareStatement(com2);
            pstm2.setString(1, placa);
            ResultSet rs2 = pstm2.executeQuery();

            while (rs.next() && rs2.next()) {

                dup_pessoa = rs.getInt("count_p");
                dup_carro = rs2.getInt("count_c");
            }

            if (dup_carro == 0 && dup_pessoa == 0) {

                return false;

            } else {
                return true;
            }

            
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;

    }

    public boolean camposPreenchidos() {

        

        if (!(textFieldNome.getText().isEmpty()) && !(textFieldCPF.getText().isEmpty())
                && !(textFieldAno.getText().isEmpty()) && !(textFieldCor.getText().isEmpty())
                && !(textFieldModelo.getText().isEmpty()) && !(textFieldPlaca.getText().isEmpty())) {
            return true;
        } else {
            return false;
        }
   
    }
    
    public void limparCampos(){
        
        textFieldAno.setText("");
        textFieldCPF.setText("");
        textFieldCor.setText("");
        textFieldModelo.setText("");
        textFieldNome.setText("");
        textFieldPlaca.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textFieldCPF = new javax.swing.JFormattedTextField();
        textFieldNome = new javax.swing.JTextField();
        textFieldPlaca = new javax.swing.JTextField();
        textFieldCor = new javax.swing.JTextField();
        textFieldModelo = new javax.swing.JTextField();
        textFieldAno = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CPF: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Placa: ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cor: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Modelo: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ano: ");

        try {
            textFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldCPF)
                    .addComponent(textFieldNome)
                    .addComponent(textFieldPlaca)
                    .addComponent(textFieldCor)
                    .addComponent(textFieldModelo)
                    .addComponent(textFieldAno, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        
        boolean duplic = verifDuplicidade();
        boolean preenc = camposPreenchidos();
        
        if(duplic == false && preenc == true){
        I_PBanco p = new PessoaDAO();
        Pessoa pessoa = new Pessoa(textFieldCPF.getText(),textFieldNome.getText());
        p.salvar(pessoa);
        
        I_CBanco c = new CarroDAO();
        Carro carro = new Carro(textFieldPlaca.getText(), textFieldModelo.getText(), Integer.parseInt(textFieldAno.getText()),
        textFieldCor.getText(), c.ultimaPessoa());
        c.salvar(carro);
        
         JOptionPane.showMessageDialog(null,"Dados salvos com sucesso!","Registro adicionado",JOptionPane.YES_OPTION);
         
        limparCampos();
        
        }else if(duplic == true){
            JOptionPane.showMessageDialog(null,"Dados informados ja cadastrados. Informar dados validos","ERRO",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Preencha todos os campos antes de continuar","ERRO",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPadrao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textFieldAno;
    private javax.swing.JFormattedTextField textFieldCPF;
    private javax.swing.JTextField textFieldCor;
    private javax.swing.JTextField textFieldModelo;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
