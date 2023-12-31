/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteGvo;
import bean.ComprasGvo;
import dao.Cliente_DAO;
import dao.Compras_DAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author Guilherme132BR
 */
public class JDlgCompras extends javax.swing.JDialog {

    MaskFormatter mascaraData;
    private boolean incluindo;
    private Compras_DAO compras_DAO;
    ComprasGvo comprasGvo;
    ComprasControle comprasControle;
//    public VendasProdutosPesquisar vendasProdutosPesquisar;

    /**
     * Creates new form JDlgCompras
     */
    public JDlgCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Pedidos"); 
        habilitar(false);
        setLocationRelativeTo(null);
        compras_DAO = new Compras_DAO();
        List lista = new ArrayList();
        Cliente_DAO cliente_DAO = new Cliente_DAO();
        List listaCliente = cliente_DAO.listAll();
        for (int i = 0; i < listaCliente.size(); i++) {
            jCboCliente.addItem((ClienteGvo) listaCliente.get(i));
        }
        Fornecedor_DAO fornecedor_DAO = new Fornecedor_DAO();
        List listaFornecedor = fornecedor_DAO.listAll();
        for (int i = 0; i < listaFornecedor.size(); i++) {
            jCboFornecedor.addItem((FornecedorGvo) listaFornecedor.get(i));
        }
        comprasPedidosControle = new ComprasPedidosControle();
//        vendasProdutosPesquisar.setList(lista);
        jTable1.setModel(comprasPedidosControle);
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraData));

    }
    
    public void habilitar(boolean valor) {
        Util.habilitar(valor, jTxtNumCompra, jFmtData, jCboCliente, jCboFornecedor, jTxtTotal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(valor, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        Util.habilitar(!valor, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }

    public ComprasGvo viewBean() {
        ComprasGvo comprasGvo = new ComprasGvo();
        comprasGvo.setIdComprasGvo(Integer.parseInt(jTxtNumCompra.getText()));
        comprasGvo.setDataComprasGvo(Util.strDate(jFmtData.getText()));
        comprasGvo.setClienteGvo((ClienteGvo) jCboCliente.getSelectedItem());
        comprasGvo.setFornecedorGvo((FornecedorGvo) jCboFornecedor.getSelectedItem());
        comprasGvo.setTotalGvo(Util.strDouble(jTxtTotal.getText()));
        return comprasGvo;
    }

    public void beanView(ComprasGvo comprasGvo) {
        jTxtNumCompra.setText(String.valueOf(comprasGvo.getIdComprasGvo()));
        jFmtData.setText(Util.dateStr(comprasGvo.getDataComprasGvo()));
        jCboCliente.setSelectedItem(comprasGvo.getClienteGvo());
        jCboFornecedor.setSelectedItem(comprasGvo.getFornecedorGvo());
        jTxtTotal.setText(String.valueOf(comprasGvo.getTotal()));

        ComprasProdutos_DAO comprasProdutos_DAO = new ComprasProdutos_DAO();
        List listaProd = (List) comprasProdutos_DAO.listProdutos(comprasGvo);

        comprasProdutosControle.setList(listaProd);
    }

    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNumCompra = new javax.swing.JTextField();
        jFmtData = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jCboCliente = new javax.swing.JComboBox<ClienteGvo>();
        jLabel3 = new javax.swing.JLabel();
        jCboFornecedor = new javax.swing.JComboBox<UsuariosGvo>();
        jTxtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnIncluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Número da Compra");

        jLabel2.setText("Data da Compra");

        jLabel3.setText("Fornecedor");

        jLabel4.setText("Cliente");

        jLabel5.setText("Total");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ConfirmIcon.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EditIcon.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DeleteIcon.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-button-inside-black-circle.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CancelIcon.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SearchIcon.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RenomearProd.png"))); // NOI18N

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EditarProd.png"))); // NOI18N

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ExcluirProd.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNumCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jTxtTotal)
                    .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnPesquisar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNumCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterarProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluirProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnConfirmar)
                        .addComponent(jBtnPesquisar)
                        .addComponent(jBtnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnAlterar)
                        .addComponent(jBtnExcluir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        ClienteGvo clienteGvo = viewBean();
        Cliente_DAO cliente_DAO = new Cliente_DAO();

        if (incluindo == true) {
            cliente_DAO.insert(clienteGvo);
        } else {
            cliente_DAO.update(clienteGvo);
        }
 
        Util.habilitar(false, jFmtIdCliente, jTxtNome, jTxtSobrenome, jFmtCPF, jTxtDesconto, jTxtCidade, jTxtEndereco, jTxtPais, jTxtBairro, jBtnCancelar, jBtnConfirmar, jBtnExcluir);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar);
        Util.limparCampos(jFmtIdCliente, jTxtNome, jTxtSobrenome, jFmtCPF, jTxtDesconto, jTxtCidade, jTxtEndereco, jTxtPais, jTxtBairro);
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        if (comprasGvo != null) {
            habilitar(true);
            incluindo = false;
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jFmtIdCliente, jTxtNome, jTxtSobrenome, jFmtCPF, jTxtDesconto, jTxtCidade, jTxtEndereco, jTxtPais, jTxtBairro, jBtnCancelar, jBtnConfirmar);
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnPesquisar, jBtnExcluir);

        if (Util.perguntar("deseja excluir o registro?") == true) {
            Util.habilitar(false, jFmtIdCliente, jTxtNome, jTxtSobrenome, jFmtCPF, jTxtDesconto, jTxtCidade, jTxtEndereco, jTxtPais, jTxtBairro, jBtnCancelar, jBtnConfirmar);
            Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnPesquisar, jBtnExcluir);
            ClienteGvo clienteGvo = viewBean();
            Cliente_DAO cliente_DAO = new Cliente_DAO();
            cliente_DAO.delete(clienteGvo);
            Util.mensagem("Registro excluido");
        } else {
            Util.mensagem("Exclusão cancelada");
        }
        Util.limparCampos(jFmtIdCliente, jTxtNome, jTxtSobrenome, jFmtCPF, jTxtDesconto, jTxtCidade, jTxtEndereco, jTxtPais, jTxtBairro);
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:

        Util.habilitar(true);
        Util.limparCampos(jTxtNumCompra, jTxtTotal, jCboCliente, jCboFornecedor, jFmtData);       
        comprasProdutosControle.setList(new ArrayList());
        jTxtNumCompra.grabFocus();
        incluindo = true;
        comprasGvo = new ComprasGvo();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        if (comprasGvo != null) {
            if (Util.perguntar("Deseja excluir o pedido?") == true) {
                ComprasProdutos_DAO comprasProdutos_DAO = new ComprasProdutos_DAO();
                ComprasProdutosGvo comprasProdutosGvo;
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    comprasProdutosGvo = comprasProdutosControle.getBean(linha);
                    comprasProdutos_DAO.delete(comprasProdutosGvo);
                }
                compras_DAO.delete(comprasGvo);
            }
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
        Util.limparCampos(jTxtNumCompra, jFmtData, jCboCliente, jCboFornecedor, jTxtTotal);
        comprasGvo = null;
        Util.mensagem("Operação cancelada");
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed

        JDlgClientePesquisa jDlgClientePesquisa = new JDlgClientePesquisa(null, true);
        jDlgClientePesquisa.setTelaAnterior(this);
        jDlgClientePesquisa.setVisible(true);
        Util.habilitar(true, jBtnAlterar, jBtnPesquisar, jBtnCancelar, jBtnExcluir);
        Util.habilitar(false, jBtnIncluir, jBtnConfirmar);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCompras dialog = new JDlgCompras(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<ClienteGvo> jCboCliente;
    private javax.swing.JComboBox<UsuariosGvo> jCboFornecedor;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNumCompra;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
