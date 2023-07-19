/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.arquetipo.view.telasUsuario.editora;

import br.com.arquetipo.dao.impl.AvaliacaoDAO;
import br.com.arquetipo.dao.impl.HistoriaDAO;
import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.servicos.Avaliacao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author barbu
 */
public class NovaAvaliacao extends javax.swing.JDialog {

    /**
     * Creates new form avaliacao
     */
    public NovaAvaliacao(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
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

        jLtitulo = new javax.swing.JLabel();
        jBvoltar = new javax.swing.JButton();
        jLnomeEscritor = new javax.swing.JLabel();
        jFnota = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jBAvaliar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLtitulo.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLtitulo.setText("NOME OBRA");

        jBvoltar.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jBvoltar.setText("Voltar");
        jBvoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltarActionPerformed(evt);
            }
        });

        jLnomeEscritor.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLnomeEscritor.setText("ESCRITOR");
        jLnomeEscritor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jFnota.setText("jFormattedTextField1");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setText("Dar nota: ");

        jBAvaliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PEN.png"))); // NOI18N
        jBAvaliar.setText("Avaliar");
        jBAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAvaliarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBvoltar)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jBAvaliar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLtitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLnomeEscritor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(24, 24, 24)
                                .addComponent(jFnota, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLnomeEscritor)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFnota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jBAvaliar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jBvoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBvoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltarActionPerformed

        // TODO add your handling code here:
        if(reAvaliacao){
            
            MinhasAvaliacoes view = new MinhasAvaliacoes(this, true);
            this.dispose();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
            
        }
        this.dispose();
    }//GEN-LAST:event_jBvoltarActionPerformed

    private void jBAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAvaliarActionPerformed
       avaliacao.setNota(Integer.parseInt(jFnota.getText()));
        //Identifica se estamos na tela de Reavaliação ou na tela de Inserção de uma nova Avaliação
        if (reAvaliacao) {
            try {
                new AvaliacaoDAO().alterar(avaliacao);
                 JOptionPane.showMessageDialog(null, "Reavaliado", "Aviso", JOptionPane.WARNING_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(NovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } else {
            try {
                // TODO add your handling code here:
                
                new AvaliacaoDAO().inserir(avaliacao);
                JOptionPane.showMessageDialog(null, "Avaliação Criada", "Aviso", JOptionPane.WARNING_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(NovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jBAvaliarActionPerformed

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
            java.util.logging.Logger.getLogger(NovaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovaAvaliacao dialog = new NovaAvaliacao(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton jBAvaliar;
    private javax.swing.JButton jBvoltar;
    private javax.swing.JFormattedTextField jFnota;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLnomeEscritor;
    private javax.swing.JLabel jLtitulo;
    // End of variables declaration//GEN-END:variables

    Avaliacao avaliacao = new Avaliacao();
    boolean reAvaliacao = false;

    public void preenche(int idHistoria) {
        try {
            Historia h = new HistoriaDAO().Buscar(idHistoria);
            avaliacao.setHistoria(h);
            avaliacao.getHistoria().setId_(idHistoria);
            jLnomeEscritor.setText(h.getEscritor().getNome());
            jLtitulo.setText(h.getTitulo());
            jFnota.setText(Integer.toString(h.getAvaliacao().getNota()));
        } catch (SQLException ex) {
            Logger.getLogger(NovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void preencheRevaliacao(int id, String nome, String titulo, int nota) {

        reAvaliacao = true;
        avaliacao.setId_avaliacao(id);
        jLnomeEscritor.setText(nome);
        jLtitulo.setText(titulo);
        jFnota.setText(Integer.toString(nota));

    }
}