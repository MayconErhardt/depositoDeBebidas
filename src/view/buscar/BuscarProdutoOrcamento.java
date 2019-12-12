/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.buscar;

import controle.ControleProduto;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.OrcamentoProduto;
import modelo.Produto;
import view.Produto.viewDadosProduto;

/**
 *
 * @author Maycon
 */
public class BuscarProdutoOrcamento extends javax.swing.JDialog {

    /**
     * Creates new form BuscarProduto
     */
    ArrayList<Produto> listaProduto = new ArrayList<>();
    ArrayList<Produto> listaSemRepetido = new ArrayList<>();
    ArrayList<OrcamentoProduto> OrcamentoLista = new ArrayList<>();

    DefaultTableModel modelo;

    private Produto produtoBuscar;

    private boolean statusVerifica = true;
    private ControleProduto contPro;
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

    public BuscarProdutoOrcamento(java.awt.Frame parent, boolean modal, boolean status, ArrayList<OrcamentoProduto> orcamentoProdutoLista) {
        super(parent, modal);
        initComponents();

        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tabProduto.setFont(new Font("SansSerif", 0, 14));

        direita.setBackground(new java.awt.Color(209, 209, 209));
        direita.setForeground(new java.awt.Color(102, 102, 102));
        esquerda.setBackground(new java.awt.Color(209, 209, 209));
        esquerda.setForeground(new java.awt.Color(102, 102, 102));
        Border emptyBorder = null;

        direita.setBorder(emptyBorder);
        tabProduto.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        tabProduto.getColumnModel().getColumn(1).setCellRenderer(direita);
        tabProduto.getColumnModel().getColumn(2).setCellRenderer(direita);

        ControleProduto contProdu = new ControleProduto();
        modelo = (DefaultTableModel) tabProduto.getModel();
        OrcamentoLista.addAll(orcamentoProdutoLista);
        listaProduto.addAll(contProdu.listarTodos());
        if (orcamentoProdutoLista.isEmpty()) {
            ControleProduto cp = new ControleProduto();
            listaSemRepetido.addAll(cp.listarTodos());
        } else {
            verficarListas(OrcamentoLista, listaProduto);
        }
        atualizarTabela();
        darTamanhoAColuna();
        txtBuscarProduto.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
    }

    public Produto getTipoSelecionado() {
        return produtoBuscar;
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
        txtBuscarProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduto = new rojerusan.RSTableMetro();
        labNomeProduto = new javax.swing.JLabel();
        labValorProduto = new javax.swing.JLabel();
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
        jLabel5.setText("Buscar Produto");

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
        jLabel1.setText("Nome Produto:");

        txtBuscarProduto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtBuscarProduto.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscarProduto.setOpaque(false);
        txtBuscarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarProdutoMouseClicked(evt);
            }
        });
        txtBuscarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdutoKeyReleased(evt);
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
                .addComponent(txtBuscarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botLimpar)
                .addGap(0, 0, 0))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botLimpar)
                    .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3))
        );

        jLabel6.setBackground(new java.awt.Color(204, 204, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Nome Produto:");

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Valor Produto:");

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabProduto.setAutoCreateRowSorter(true);
        tabProduto.setBackground(new java.awt.Color(250, 250, 250));
        tabProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabProduto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabProduto.setAutoscrolls(false);
        tabProduto.setColorBackgoundHead(new java.awt.Color(250, 250, 250));
        tabProduto.setColorFilasBackgound1(new java.awt.Color(209, 209, 209));
        tabProduto.setColorFilasBackgound2(new java.awt.Color(209, 209, 209));
        tabProduto.setColorFilasForeground1(new java.awt.Color(102, 102, 102));
        tabProduto.setColorFilasForeground2(new java.awt.Color(102, 102, 102));
        tabProduto.setColorForegroundHead(new java.awt.Color(51, 51, 51));
        tabProduto.setColorSelBackgound(new java.awt.Color(40, 53, 147));
        tabProduto.setFuenteFilas(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabProduto.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tabProduto.setFuenteHead(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tabProduto.setGridColor(new java.awt.Color(204, 204, 204));
        tabProduto.setGrosorBordeFilas(0);
        tabProduto.setGrosorBordeHead(0);
        tabProduto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabProduto.setMultipleSeleccion(false);
        tabProduto.setOpaque(false);
        tabProduto.setRowHeight(30);
        tabProduto.setSelectionBackground(new java.awt.Color(40, 53, 147));
        tabProduto.getTableHeader().setReorderingAllowed(false);
        tabProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabProduto);
        if (tabProduto.getColumnModel().getColumnCount() > 0) {
            tabProduto.getColumnModel().getColumn(0).setResizable(false);
            tabProduto.getColumnModel().getColumn(1).setResizable(false);
            tabProduto.getColumnModel().getColumn(2).setResizable(false);
        }

        labNomeProduto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        labValorProduto.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(labValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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
                .addGap(3, 3, 3)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botCancelar)
                    .addComponent(botSalvar))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(paneNome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void botLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimparActionPerformed

        txtBuscarProduto.setText("");
        listaProduto.clear();
        listaSemRepetido.clear();
        ControleProduto contP = new ControleProduto();
        listaProduto.addAll(contP.listarTodos());
        if (OrcamentoLista.isEmpty()) {
            listaSemRepetido.addAll(contP.listarTodos());
        } else {
            verficarListas(OrcamentoLista, listaProduto);
        }
        atualizarTabela();
        // TODO add your handling code here:
    }//GEN-LAST:event_botLimparActionPerformed

    private void txtBuscarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarProdutoMouseClicked

//        listaProduto.clear();
//        ControleProduto conProd = new ControleProduto();
//        listaProduto.addAll(conProd.listarPorNomeEstoque(txtBuscarProduto.getText()));
//        while (modelo.getRowCount() > 0) {
//            // apaga a primeira linha
//            modelo.removeRow(0);
//        }
//        for (Produto p : listaProduto) {
//            // adiciona uma linha na tabela
//            // o object criado tem que ter a mesma quantidade
//            // de elementos que foi definida na tabela,
//            // como também os mesmos tipos
//            modelo.addRow(new Object[]{p.getProdutoNome(), p.getProdutoQuantidade(), p.getProdutoValorVenda()});
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoMouseClicked

    private void txtBuscarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdutoKeyReleased

        listaProduto.clear();
        listaSemRepetido.clear();
        ControleProduto conProduto = new ControleProduto();
        if (statusVerifica != true) {
            listaProduto.addAll(conProduto.listarPorNomeEstoque(txtBuscarProduto.getText()));
        } else {
            listaProduto.addAll(conProduto.listarPorNome(txtBuscarProduto.getText()));
        }
        listaSemRepetido.clear();
        if (OrcamentoLista.isEmpty()) {

            ControleProduto p = new ControleProduto();
            listaSemRepetido.addAll(listaProduto);
        } else {
            verficarListas(OrcamentoLista, listaProduto);
        }
        atualizarTabela();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoKeyReleased

    private void tabProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutoMouseClicked

        int linha = -1;
        linha = tabProduto.getSelectedRow();
//
        if (linha != -1) {
            Produto p = new Produto();
            p = listaSemRepetido.get(linha);
            labNomeProduto.setText(p.getProdutoNome());
            labValorProduto.setText(String.valueOf(p.getProdutoValorVenda()));
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE ALGUÉM NA TABELA");
        }

    }//GEN-LAST:event_tabProdutoMouseClicked

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed

        //   fornecedor = null;
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSalvarActionPerformed

        int linha = -1;
        linha = tabProduto.getSelectedRow();
        if (linha != -1) {
            produtoBuscar = new Produto();
            this.produtoBuscar = this.listaSemRepetido.get(linha);
            dispose();
        }

    }//GEN-LAST:event_botSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarProdutoOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProdutoOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProdutoOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProdutoOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarProdutoOrcamento dialog = new BuscarProdutoOrcamento(new javax.swing.JFrame(), true, true, null);
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
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labNomeProduto;
    private javax.swing.JLabel labValorProduto;
    private javax.swing.JPanel paneNome2;
    private javax.swing.JPanel panelDados;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojerusan.RSTableMetro tabProduto;
    private javax.swing.JTextField txtBuscarProduto;
    // End of variables declaration//GEN-END:variables

    private void atualizarTabela() {
        //    DefaultTableModel modelo = (DefaultTableModel) tabProduto.getModel();

        while (modelo.getRowCount() > 0) {
            // apaga a primeira linha
            modelo.removeRow(0);
        }
        for (Produto f : listaSemRepetido) {
            // adiciona uma linha na tabela
            // o object criado tem que ter a mesma quantidade
            // de elementos que foi definida na tabela, 
            // como também os mesmos tipos
            modelo.addRow(new Object[]{f.getProdutoNome(), f.getProdutoQuantidade(), doubleString(f.getProdutoValorVenda())});
        }

    }

    public void darTamanhoAColuna() {
        tabProduto.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabProduto.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabProduto.getColumnModel().getColumn(2).setPreferredWidth(50);

    }

    public String doubleString(double d) {

        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        String s = df.format(d);
        return s;

    }

    public ArrayList verficarListas(ArrayList<OrcamentoProduto> orcamentoLista, ArrayList<Produto> listaProduto) {

        if (!(listaProduto.size() == orcamentoLista.size())) {
            for (Produto produtoNoBanco : listaProduto) {
                if (orcamentoLista.stream().anyMatch(i -> i.getProdutoCod().getProdutoId() == (produtoNoBanco.getProdutoId()))) {

                } else {
                    listaSemRepetido.add(produtoNoBanco);
                }
            }
        } else {
            listaSemRepetido.clear();
            //return listaSemRepetido;
        }
        return listaSemRepetido;
    }

}
