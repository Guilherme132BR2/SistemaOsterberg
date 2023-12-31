/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ProdutosGvo;
import dao.Produtos_DAO;
import tools.Util;

/**
 *
 * @author Guilherme132BR
 */
public class JDlgProdutosIA extends javax.swing.JDialog {

    /**
     * Creates new form JDlgProdutosIA
     */
    public JDlgProdutosIA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public ProdutosGvo viewBean() {
        ProdutosGvo produtosGvo = new ProdutosGvo();
        produtosGvo.setIdProdutosGvo(Util.strInt(jFmtIdProdutos.getText()));
        if (jCboPlataforma.getSelectedIndex() == 0) {
            produtosGvo.setPlataformaGvo("PC");
        } else if (jCboPlataforma.getSelectedIndex() == 1) {
            produtosGvo.setPlataformaGvo("Xbox");
        } else if (jCboPlataforma.getSelectedIndex() == 2) {
            produtosGvo.setPlataformaGvo("PlayStation");
        } else if (jCboPlataforma.getSelectedIndex() == 3) {
            produtosGvo.setPlataformaGvo("Xbox/PlayStation");
        } else if (jCboPlataforma.getSelectedIndex() == 4) {
            produtosGvo.setPlataformaGvo("Xbox/PC");
        } else if (jCboPlataforma.getSelectedIndex() == 5) {
            produtosGvo.setPlataformaGvo("PlayStation/PC");
        } else {
            produtosGvo.setPlataformaGvo("PlayStation/PC/Xbox");
        }
        produtosGvo.setNomeGvo(jTxtNome.getText());
        produtosGvo.setPrecoGvo(Util.strDouble(jFmtPreco.getText()));
        if (jChbEstoque.isSelected() == true) {
            produtosGvo.setEstoqueGvo("s");
        } else {
            produtosGvo.setEstoqueGvo("n");
        }
        return produtosGvo;
    }

    public void beanView(ProdutosGvo produtosGvo) {
        jFmtIdProdutos.setText(Util.intStr(produtosGvo.getIdProdutosGvo()));
        if (produtosGvo.getPlataformaGvo() == "PC") {
            jCboPlataforma.setSelectedIndex(0);
        } else if (produtosGvo.getPlataformaGvo() == "Xbox") {
            jCboPlataforma.setSelectedIndex(1);
        } else if (produtosGvo.getPlataformaGvo() == "PlayStation") {
            jCboPlataforma.setSelectedIndex(2);
        } else if (produtosGvo.getPlataformaGvo() == "Xbox/PlayStation") {
            jCboPlataforma.setSelectedIndex(3);
        } else if (produtosGvo.getPlataformaGvo() == "Xbox/PC") {
            jCboPlataforma.setSelectedIndex(4);
        } else if (produtosGvo.getPlataformaGvo() == "PlayStation/PC") {
            jCboPlataforma.setSelectedIndex(5);
        } else {
            jCboPlataforma.setSelectedIndex(6);
        }
        jFmtPreco.setText(Util.doubleStr(produtosGvo.getPrecoGvo()));
        jTxtNome.setText(produtosGvo.getNomeGvo());
        if (produtosGvo.getEstoqueGvo().equals("s") == true) {
            jChbEstoque.setSelected(true);
        } else {
            jChbEstoque.setSelected(false);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBtnOk = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jFmtPreco = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jChbEstoque = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCboPlataforma = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jFmtIdProdutos = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnOk.setText("Ok");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnOk);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCancelar);

        jFmtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtPrecoActionPerformed(evt);
            }
        });

        jLabel3.setText("Preço do produto");

        jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Produto");

        jChbEstoque.setText("Sim");
        jChbEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbEstoqueActionPerformed(evt);
            }
        });

        jLabel6.setText("Possui estoque?");

        jCboPlataforma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "Xbox", "PlayStation", "Xbox/PlayStation", "Xbox/PC", "PlayStation/PC", "PlayStation/PC/Xbox" }));
        jCboPlataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboPlataformaActionPerformed(evt);
            }
        });

        jLabel4.setText("Plataforma");

        jLabel1.setText("ID do Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jFmtPreco)
                    .addComponent(jFmtIdProdutos))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCboPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jChbEstoque))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtIdProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbEstoque))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFmtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        // TODO add your handling code here:
        ProdutosGvo produtosGvo = viewBean();
        Produtos_DAO produtos_DAO = new Produtos_DAO();
        produtos_DAO.insert(produtosGvo);

        Util.limparCampos(jTxtNome, jFmtPreco, jFmtIdProdutos, jChbEstoque, jCboPlataforma);
        Util.mensagem("incluido");
    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jFmtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtPrecoActionPerformed

    private void jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeActionPerformed

    private void jChbEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChbEstoqueActionPerformed

    private void jCboPlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboPlataformaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboPlataformaActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgProdutosIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProdutosIA dialog = new JDlgProdutosIA(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JComboBox<String> jCboPlataforma;
    private javax.swing.JCheckBox jChbEstoque;
    private javax.swing.JFormattedTextField jFmtIdProdutos;
    private javax.swing.JFormattedTextField jFmtPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
