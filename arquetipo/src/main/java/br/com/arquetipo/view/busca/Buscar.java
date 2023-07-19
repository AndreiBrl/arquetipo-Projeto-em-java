/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.arquetipo.view.busca;

import br.com.arquetipo.dao.impl.EscritorDAO;
import br.com.arquetipo.dao.impl.HistoriaDAO;
import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.u.Escritor;
import br.com.arquetipo.view.telasUsuario.InicialUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author barbu
 */
public class Buscar extends javax.swing.JDialog {

    /**
     * Creates new form Buscar2
     */
    public Buscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencheComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTtitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCgenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSmedia = new javax.swing.JSpinner();
        JcTipoPesquisa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JbVoltar = new javax.swing.JButton();
        jCescritores = new javax.swing.JComboBox<>();
        JbPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Título História:");

        jTtitulo.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Gênero:");

        jCgenero.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Romance", "Mistério", "Suspense", "Ficção", "Fantasia", "Terror", "Aventura", "Comédia", "Drama" }));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Média(min):");

        JcTipoPesquisa.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        JcTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Obras", "Escritores" }));
        JcTipoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcTipoPesquisaItemStateChanged(evt);
            }
        });
        JcTipoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcTipoPesquisaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Pesquisar por");

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LUPA.png"))); // NOI18N
        jLabel1.setText("BUSCA");

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel2.setText("Autor:");

        JbVoltar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        JbVoltar.setText("Voltar");
        JbVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbVoltarActionPerformed(evt);
            }
        });

        jCescritores.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jCescritores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JbPesquisar.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        JbPesquisar.setText("Pesquisar");
        JbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel4))
                                .addComponent(jLabel3)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSmedia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JbVoltar)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTtitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCgenero, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(JcTipoPesquisa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCescritores, javax.swing.GroupLayout.Alignment.LEADING, 0, 136, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(JbPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCescritores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSmedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JbVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbVoltarActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_JbVoltarActionPerformed

    private void JbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbPesquisarActionPerformed
        // TODO add your handling code here:
        String tipo = (String) JcTipoPesquisa.getSelectedItem();
        ResultadoGeral result = new ResultadoGeral(this, true);
        result.tipoPesquisa(tipo, jCescritores.getSelectedItem().toString(), jTtitulo.getText(), jCgenero.getSelectedItem().toString(), jSmedia.getValue().toString());
        result.setLocationRelativeTo(null);
        result.setVisible(true);
    }//GEN-LAST:event_JbPesquisarActionPerformed

    private void JcTipoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcTipoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcTipoPesquisaActionPerformed

    private void JcTipoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcTipoPesquisaItemStateChanged
        // TODO add your handling code here:

        
//        evento dentro do combo box (Obras/Escritores)
        if ("Obras".equals(JcTipoPesquisa.getSelectedItem().toString())) {
            jTtitulo.setVisible(true);
            jSmedia.setVisible(true);
             jLabel3.setVisible(true);
            jLabel5.setVisible(true);
        } else {
            jLabel3.setVisible(false);
            jLabel5.setVisible(false);
            jTtitulo.setVisible(false);
            jSmedia.setVisible(false);
        }


    }//GEN-LAST:event_JcTipoPesquisaItemStateChanged

    public void preencheComboBox() {
        try {

            jCescritores.removeAllItems();
            lista = new EscritorDAO().BuscarTodos();
            jCescritores.addItem("Todos");
            for (Escritor es : lista) {
                String nome = es.getNome();

                jCescritores.addItem(nome);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Buscar dialog = new Buscar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JbPesquisar;
    private javax.swing.JButton JbVoltar;
    private javax.swing.JComboBox<String> JcTipoPesquisa;
    private javax.swing.JComboBox<String> jCescritores;
    private javax.swing.JComboBox<String> jCgenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSmedia;
    private javax.swing.JTextField jTtitulo;
    // End of variables declaration//GEN-END:variables

    ArrayList<Escritor> lista;
}
