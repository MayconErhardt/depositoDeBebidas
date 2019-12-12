/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.buscar;

import controle.ControleFornecedor;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Fornecedor;

/**
 *
 * @author Maycon
 */
public class BuscarFornecedor extends javax.swing.JDialog {

    /**
     * Creates new form BuscarFornecedor
     */
    ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();

    private Fornecedor fornecedorBusca;

    DefaultTableModel modelo;

    public BuscarFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelo = (DefaultTableModel) tabFornecedor.getModel();
        atualizarTabela();
        editarCampos();

    }

    public Fornecedor getTipoSelecionado() {
        return fornecedorBusca;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneNome2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botFechar3 = new javax.swing.JButton();
        panelDados = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        botLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarFornecedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabFornecedor = new rojerusan.RSTableMetro();
        labRazao = new javax.swing.JLabel();
        labNomeFantasia = new javax.swing.JLabel();
        labCNPJ = new javax.swing.JLabel();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        botCancelar = new javax.swing.JButton();
        botSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        paneNome2.setBackground(new java.awt.Color(26, 35, 126));
        paneNome2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paneNome2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar Fornecedor");

        botFechar3.setBackground(new java.awt.Color(26, 35, 126));
        botFechar3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botFechar3.setForeground(new java.awt.Color(255, 255, 255));
        botFechar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/fecharr24px.png"))); // NOI18N
        botFechar3.setContentAreaFilled(false);
        botFechar3.setOpaque(true);
        botFechar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFechar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneNome2Layout = new javax.swing.GroupLayout(paneNome2);
        paneNome2.setLayout(paneNome2Layout);
        paneNome2Layout.setHorizontalGroup(
            paneNome2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNome2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botFechar3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        paneNome2Layout.setVerticalGroup(
            paneNome2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNome2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5))
            .addComponent(botFechar3)
        );

        panelDados.setBackground(new java.awt.Color(255, 255, 255));
        panelDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(40, 53, 147)));
        panelDados.setEnabled(false);

        kGradientPanel1.setDoubleBuffered(false);
        kGradientPanel1.setkEndColor(new java.awt.Color(26, 35, 126));
        kGradientPanel1.setkStartColor(new java.awt.Color(40, 53, 147));

        botLimpar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/limpar18px.png"))); // NOI18N
        botLimpar.setText("LIMPAR");
        botLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botLimparActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome Fornecedor:");

        txtBuscarFornecedor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtBuscarFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarFornecedor.setOpaque(false);
        txtBuscarFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarFornecedorMouseClicked(evt);
            }
        });
        txtBuscarFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarFornecedorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(txtBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botLimpar)
                .addGap(0, 0, 0))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(botLimpar)
                    .addComponent(txtBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jLabel6.setBackground(new java.awt.Color(204, 204, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Razão Social:");

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Nome Fantásia:");

        jLabel8.setBackground(new java.awt.Color(204, 204, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("CNPJ:");

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabFornecedor.setAutoCreateRowSorter(true);
        tabFornecedor.setBackground(new java.awt.Color(250, 250, 250));
        tabFornecedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Fornecedor", "Contato", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabFornecedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabFornecedor.setAutoscrolls(false);
        tabFornecedor.setColorBackgoundHead(new java.awt.Color(250, 250, 250));
        tabFornecedor.setColorFilasBackgound1(new java.awt.Color(209, 209, 209));
        tabFornecedor.setColorFilasBackgound2(new java.awt.Color(250, 250, 250));
        tabFornecedor.setColorFilasForeground1(new java.awt.Color(102, 102, 102));
        tabFornecedor.setColorFilasForeground2(new java.awt.Color(102, 102, 102));
        tabFornecedor.setColorForegroundHead(new java.awt.Color(51, 51, 51));
        tabFornecedor.setColorSelBackgound(new java.awt.Color(40, 53, 147));
        tabFornecedor.setFuenteFilas(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabFornecedor.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tabFornecedor.setFuenteHead(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tabFornecedor.setGridColor(new java.awt.Color(204, 204, 204));
        tabFornecedor.setGrosorBordeFilas(0);
        tabFornecedor.setGrosorBordeHead(0);
        tabFornecedor.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabFornecedor.setMultipleSeleccion(false);
        tabFornecedor.setOpaque(false);
        tabFornecedor.setRowHeight(30);
        tabFornecedor.setSelectionBackground(new java.awt.Color(63, 81, 181));
        tabFornecedor.getTableHeader().setReorderingAllowed(false);
        tabFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabFornecedor);
        if (tabFornecedor.getColumnModel().getColumnCount() > 0) {
            tabFornecedor.getColumnModel().getColumn(0).setResizable(false);
            tabFornecedor.getColumnModel().getColumn(1).setResizable(false);
            tabFornecedor.getColumnModel().getColumn(2).setResizable(false);
        }

        labRazao.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        labNomeFantasia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        labCNPJ.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(labRazao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addComponent(jScrollPane1)
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(labNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(labCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        rSPanelGradiente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rSPanelGradiente1.setColorPrimario(new java.awt.Color(40, 53, 147));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(26, 35, 126));
        rSPanelGradiente1.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.HORIZONTAL);

        botCancelar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/cancel18px.png"))); // NOI18N
        botCancelar.setText("CANCELAR");
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });

        botSalvar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/salvar18px.png"))); // NOI18N
        botSalvar.setText("OK");
        botSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(botCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botCancelar)
                    .addComponent(botSalvar))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneNome2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(paneNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botFechar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botFechar3ActionPerformed

        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_botFechar3ActionPerformed

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed

        //   fornecedor = null;
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalvarActionPerformed

        int linha = -1;
        linha = tabFornecedor.getSelectedRow();
        if (linha != -1) {
            this.fornecedorBusca = this.listaFornecedor.get(linha);
            setVisible(false);
        }


    }//GEN-LAST:event_botSalvarActionPerformed

    private void botLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimparActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_botLimparActionPerformed

    private void txtBuscarFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarFornecedorKeyReleased

        listaFornecedor.clear();
        ControleFornecedor conFor = new ControleFornecedor();
        listaFornecedor.addAll(conFor.listarPorNome(txtBuscarFornecedor.getText()));
        while (modelo.getRowCount() > 0) {
            // apaga a primeira linha
            modelo.removeRow(0);
        }
        for (Fornecedor f : listaFornecedor) {
            // adiciona uma linha na tabela
            // o object criado tem que ter a mesma quantidade
            // de elementos que foi definida na tabela, 
            // como também os mesmos tipos
            modelo.addRow(new Object[]{f.getFornecedorNomeFantasia(), f.getForncedorNomeContato(), f.getFornecedorTelefoneCelular()});
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarFornecedorKeyReleased

    private void tabFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFornecedorMouseClicked

        int linha = -1;
        linha = tabFornecedor.getSelectedRow();

        if (linha != -1) {
            Fornecedor f = new Fornecedor();
            f = listaFornecedor.get(linha);
            labCNPJ.setText(f.getFornecedorCNPJ());
            labNomeFantasia.setText(f.getFornecedorNomeFantasia());
            labRazao.setText(f.getFornecedorRazaoSicial());
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE ALGUÉM NA TABELA");
        }


    }//GEN-LAST:event_tabFornecedorMouseClicked

    private void txtBuscarFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarFornecedorMouseClicked

        listaFornecedor.clear();
        ControleFornecedor conFor = new ControleFornecedor();
        listaFornecedor.addAll(conFor.listarPorNome(txtBuscarFornecedor.getText()));
        while (modelo.getRowCount() > 0) {
            // apaga a primeira linha
            modelo.removeRow(0);
        }
        for (Fornecedor f : listaFornecedor) {
            // adiciona uma linha na tabela
            // o object criado tem que ter a mesma quantidade
            // de elementos que foi definida na tabela, 
            // como também os mesmos tipos
            modelo.addRow(new Object[]{f.getFornecedorNomeFantasia(), f.getForncedorNomeContato(), f.getFornecedorTelefoneCelular()});
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarFornecedorMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarFornecedor dialog = new BuscarFornecedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botCancelar;
    private javax.swing.JButton botFechar3;
    private javax.swing.JButton botLimpar;
    private javax.swing.JButton botSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labCNPJ;
    private javax.swing.JLabel labNomeFantasia;
    private javax.swing.JLabel labRazao;
    private javax.swing.JPanel paneNome2;
    private javax.swing.JPanel panelDados;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojerusan.RSTableMetro tabFornecedor;
    private javax.swing.JTextField txtBuscarFornecedor;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabela() {

        listaFornecedor.clear();
        ControleFornecedor contFor = new ControleFornecedor();
        listaFornecedor.addAll(contFor.listarTodos());

        while (modelo.getRowCount() > 0) {
            // apaga a primeira linha
            modelo.removeRow(0);
        }
        for (Fornecedor f : listaFornecedor) {
            // adiciona uma linha na tabela
            // o object criado tem que ter a mesma quantidade
            // de elementos que foi definida na tabela, 
            // como também os mesmos tipos
            modelo.addRow(new Object[]{f.getFornecedorNomeFantasia(), f.getForncedorNomeContato(), f.getFornecedorTelefoneCelular()});
        }

    }

    public void editarCampos() {
        txtBuscarFornecedor.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

    }

}