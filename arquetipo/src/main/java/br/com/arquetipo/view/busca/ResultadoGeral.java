/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.arquetipo.view.busca;

import br.com.arquetipo.dao.impl.EscritorDAO;
import br.com.arquetipo.dao.impl.HistoriaDAO;
import br.com.arquetipo.dao.impl.LeituraDAO;
import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.servicos.Leitura;
import br.com.arquetipo.model.u.Escritor;
import br.com.arquetipo.view.ObjetoCompartilhadoView;
import br.com.arquetipo.view.telasUsuario.editora.NovaAvaliacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author barbu
 */
public class ResultadoGeral extends javax.swing.JDialog {

    private String tipoPesquisa;

    /**
     * Creates new form rees
     */
    public ResultadoGeral(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tipoUsuario();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbAbrir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JlPrincipal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTObras = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JbAbrir.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        JbAbrir.setText("Abrir");
        JbAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAbrirActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jButton2.setText("voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JlPrincipal.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        JlPrincipal.setText("RESULTADOS");

        jTObras.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jTObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Genêro", "Média"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTObras);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/penaR.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(JlPrincipal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JbAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JlPrincipal)
                        .addGap(43, 43, 43)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JbAbrir)
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAbrirActionPerformed
        // TODO add your handling code here:

        int linhaSelecionada = jTObras.getSelectedRow();

         if ("Editora".equals(objC.getTipoUsuario())) {
             if (linhaSelecionada > -1) {
                
                    int idHistoria = Integer.parseInt(jTObras.getValueAt(linhaSelecionada, 0).toString());
                    String titulo = jTObras.getValueAt(linhaSelecionada, 2).toString();
                    NovaAvaliacao view = new NovaAvaliacao(this, true);
                    view.preenche(idHistoria);
                    view.setLocationRelativeTo(null);
                    view.setVisible(true);
                    this.dispose();
              
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma linha", "Aviso", JOptionPane.WARNING_MESSAGE);

            }
        } else {
            

            if (linhaSelecionada > -1) {
                try {
                    int id = Integer.parseInt(jTObras.getValueAt(linhaSelecionada, 0).toString());

                    Leitura leitura = new Leitura();
                    leitura.setIdHistoria(id);
                    new LeituraDAO().inserir(leitura);
                    JOptionPane.showMessageDialog(null, "Leitura Adicionada", "Aviso", JOptionPane.WARNING_MESSAGE);

                } catch (SQLException ex) {
                    Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma linha", "Aviso", JOptionPane.WARNING_MESSAGE);

            }

        }


    }//GEN-LAST:event_JbAbrirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void tipoPesquisa(String tipo, String nomeEscritor, String titulo, String genero, String media) {
        this.tipoPesquisa = tipo;
        if (tipo.equals("Obras")) {
            JlPrincipal.setText("Obras Cadastradas");
            try {
                listaHistorias = new HistoriaDAO().buscaPorObra(nomeEscritor, titulo, genero, media);
                preencheHistoria(listaHistorias);

            } catch (SQLException ex) {
                Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JlPrincipal.setText("Escritores Cadastrados");
                JbAbrir.setVisible(false);
            try {
                listaEscritores = new EscritorDAO().buscaPorEscritor(nomeEscritor, genero);
                preencheEscritor(listaEscritores);
            } catch (SQLException ex) {
                Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ResultadoGeral.class.getName()).log(Level.SEVERE, null, ex);
            }

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
            java.util.logging.Logger.getLogger(ResultadoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultadoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultadoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultadoGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ResultadoGeral dialog = new ResultadoGeral(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton JbAbrir;
    private javax.swing.JLabel JlPrincipal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTObras;
    // End of variables declaration//GEN-END:variables
ArrayList<Escritor> listaEscritores;
    ArrayList<Historia> listaHistorias;
    ObjetoCompartilhadoView objC = new ObjetoCompartilhadoView();

    private void preencheHistoria(ArrayList<Historia> lista) {
        DefaultTableModel dftc = (DefaultTableModel) jTObras.getModel();
        Object[] colunas = {"ID", "Nome", "Gênero", "Media"};
        dftc.setColumnIdentifiers(colunas);
        while (dftc.getRowCount() > 0) {
            dftc.removeRow(0);
        }

        for (Historia h : lista) {

            String[] linha = {h.getId() + "", h.getTitulo(), h.getGenero(), "" + h.getMedia()};

            dftc.addRow(linha);
        }
    }

    private void preencheEscritor(ArrayList<Escritor> lista) {

        DefaultTableModel dftc = (DefaultTableModel) jTObras.getModel();
        Object[] colunas = {"ID", "Nome", "Gênero de Escrita", "Número de Obras", "Livros Publicados"};
        dftc.setColumnIdentifiers(colunas);

        while (dftc.getRowCount() > 0) {
            dftc.removeRow(0);
        }

        for (Escritor es : lista) {

            String[] linha = {es.getId_escritor() + "", es.getNome(), es.getGeneroEscrita(), "" + es.getNumeroObras(), "" + es.getLivrosPublicados()};

            dftc.addRow(linha);
        }
    }

    private void tipoUsuario() {

        if ("Escritor".equals(objC.getTipoUsuario())) {
            JbAbrir.setVisible(false);
        } else if ("Editora".equals(objC.getTipoUsuario())) {
            JbAbrir.setText("Avaliar");
        } else {
            JbAbrir.setText("Adicionar Leitura");

        }

    }
}