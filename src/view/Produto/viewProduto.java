/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Produto;

import controle.ControleProduto;
import controle.IntegridadeException;
import controle.NaoExisteException;
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

import modelo.Produto;
import static org.jdesktop.observablecollections.ObservableCollections.observableList;

/**
 *
 * @author Maycon
 */
public class viewProduto extends javax.swing.JDialog {

    /**
     * Creates new form viewProduto
     */
    Produto produto;
    ControleProduto contProd;
    
    ArrayList<Produto> listProduto = new ArrayList<>();
    
    private DefaultTableModel modelo;

    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    public viewProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        modelo = (DefaultTableModel) tabProduto.getModel();
        
//        botExcluir.setVerticalTextPosition(SwingConstants.BOTTOM);
//        botExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
        contProd = new ControleProduto();
        produto = new Produto();
        listProduto.addAll(contProd.listarTodos());
        //   labQuantidade.setVisible(false);
        txtBuscar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
        
        atualizaTabela(listProduto);
        
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        tabProduto.setFont(new Font("SansSerif", 0, 14));

        direita.setBackground(new java.awt.Color(209, 209, 209));
        direita.setForeground(new java.awt.Color(102, 102, 102));
        Border emptyBorder = null;

        direita.setBorder(emptyBorder);
        tabProduto.getColumnModel().getColumn(1).setCellRenderer(direita);
        tabProduto.getColumnModel().getColumn(2).setCellRenderer(direita);
        darTamanhoAColuna();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        botFechar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rSPanelGradiente2 = new rspanelgradiente.RSPanelGradiente();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        labNome = new javax.swing.JLabel();
        labValorVenda = new javax.swing.JLabel();
        labQuantidade = new javax.swing.JLabel();
        botAlterar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        botLimpar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduto = new rojerusan.RSTableMetro();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        botVoltar = new javax.swing.JButton();
        botNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(26, 35, 126));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Produto");

        botFechar.setBackground(new java.awt.Color(26, 35, 126));
        botFechar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botFechar.setForeground(new java.awt.Color(255, 255, 255));
        botFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/close.png"))); // NOI18N
        botFechar.setContentAreaFilled(false);
        botFechar.setOpaque(true);
        botFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2))
            .addComponent(botFechar)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        rSPanelGradiente2.setColorPrimario(new java.awt.Color(26, 35, 126));
        rSPanelGradiente2.setColorSecundario(new java.awt.Color(103, 58, 183));
        rSPanelGradiente2.setGradiente(rspanelgradiente.RSPanelGradiente.Gradiente.VERTICAL);
        rSPanelGradiente2.setPreferredSize(new java.awt.Dimension(336, 135));

        rSPanelImage1.setBackground(new java.awt.Color(153, 153, 153));
        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/imagem/asfalt-light.png"))); // NOI18N
        rSPanelImage1.setPreferredSize(new java.awt.Dimension(336, 135));

        labNome.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        labNome.setForeground(new java.awt.Color(255, 255, 255));
        labNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/bebida40px.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labNome, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(labNome)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout rSPanelGradiente2Layout = new javax.swing.GroupLayout(rSPanelGradiente2);
        rSPanelGradiente2.setLayout(rSPanelGradiente2Layout);
        rSPanelGradiente2Layout.setHorizontalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );
        rSPanelGradiente2Layout.setVerticalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente2Layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        labValorVenda.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        labValorVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/dinheiro20px.png"))); // NOI18N

        labQuantidade.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        labQuantidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/quantidade20px.png"))); // NOI18N

        botAlterar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/edit18px.png"))); // NOI18N
        botAlterar.setText("ALTERAR");
        botAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlterarActionPerformed(evt);
            }
        });

        botExcluir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/delete18px.png"))); // NOI18N
        botExcluir.setText("EXCLUIR");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(botAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botExcluir))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labValorVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(labValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(labQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botExcluir)
                    .addComponent(botAlterar))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

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

        txtBuscar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setOpaque(false);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botLimpar)
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(117, Short.MAX_VALUE)))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botLimpar)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabProduto.setAutoCreateRowSorter(true);
        tabProduto.setBackground(new java.awt.Color(250, 250, 250));
        tabProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "QUANTIDADE", "VALOR"
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        kGradientPanel3.setkEndColor(new java.awt.Color(40, 53, 147));
        kGradientPanel3.setkStartColor(new java.awt.Color(26, 35, 126));

        botVoltar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/voltar18px.png"))); // NOI18N
        botVoltar.setText("VOLTAR");
        botVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVoltarActionPerformed(evt);
            }
        });

        botNovo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        botNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/add18px.png"))); // NOI18N
        botNovo.setText("INSERIR NOVO PRODUTO");
        botNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(botVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botNovo)
                .addGap(5, 5, 5))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botVoltar)
                    .addComponent(botNovo))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1106, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botFecharActionPerformed

        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_botFecharActionPerformed

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlterarActionPerformed

        int linha = -1;
        linha = tabProduto.getSelectedRow();
        if (linha != -1) {

            produto = listProduto.get(linha);
            viewDadosProduto alterar = new viewDadosProduto(null, true, produto);
            alterar.setVisible(true);
            listProduto.clear();
            listProduto.addAll(contProd.listarTodos());
            atualizaTabela(listProduto);

            produto = null;
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE ALGUÉM NA TABELA PARA ALTERAR");
        }
        txtBuscar.setText("");
        labNome.setText("");
        labQuantidade.setText("");
        labValorVenda.setText("");


    }//GEN-LAST:event_botAlterarActionPerformed

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExcluirActionPerformed

        int linhaExcluir = -1;
        linhaExcluir = tabProduto.getSelectedRow();
        if (linhaExcluir != -1) {
            produto = listProduto.get(linhaExcluir);
            int op = JOptionPane.showConfirmDialog(this,
                    "Confirma a exclusão do produto "
                    + produto.getProdutoNome() + "?",
                    "Exclusão de Produto",
                    JOptionPane.YES_NO_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                // chama o controle para excluir o usuário
                try {
                    contProd.excluir(produto.getProdutoId());
                    /// JOptionPane.showMessageDialog(this, "O usuário foi excluído.");
                    listProduto.clear();
                    listProduto.addAll(contProd.listarTodos());
                    limparCampos();
                    atualizaTabela(listProduto);
                } catch (NaoExisteException | IntegridadeException e) {

                    JOptionPane.showMessageDialog(this, e.getMessage());
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Produto Na Tabela Para Ser Excluido");
        }
    }//GEN-LAST:event_botExcluirActionPerformed

    private void botLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botLimparActionPerformed

        txtBuscar.setText("");
        limparCampos();
        listProduto.clear();
        listProduto.addAll(contProd.listarTodos());

        // TODO add your handling code here:
    }//GEN-LAST:event_botLimparActionPerformed

    private void tabProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutoMouseClicked
        int linha = -1;
        linha = tabProduto.getSelectedRow();

        if (evt.getClickCount() > 1) {
            boolean consulta = true;
            //    JOptionPane.showMessageDialog(null, produto);
            viewDadosProduto insAlte = new viewDadosProduto(null, true, produto);
            insAlte.setVisible(true);
            listProduto.clear();
            listProduto.addAll(contProd.listarTodos());
            txtBuscar.setText("");
            labNome.setText("");
            labQuantidade.setText("");
            labValorVenda.setText("");

        } else {
            if (linha != -1) {
                produto = new Produto();
                produto = listProduto.get(linha);
                labNome.setText(produto.getProdutoNome());
                labQuantidade.setText(String.valueOf(produto.getProdutoQuantidade()));
                Float valor = (produto.getProdutoValorVenda());
                DecimalFormat df = new DecimalFormat("0.00");

                String v = String.valueOf(df.format(valor));

                String comVirgula = v.replace('.', ',');

                //  comVirgula = comVirgula.substring(linha);
                //                System.out.println(comVirgula);
                //                JOptionPane.showMessageDialog(null, comVirgula);
                labValorVenda.setText(comVirgula);
            }
        }

    }//GEN-LAST:event_tabProdutoMouseClicked

    private void botVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVoltarActionPerformed

        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_botVoltarActionPerformed

    private void botNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botNovoActionPerformed

        produto = null;
        boolean consulta = false;
        // JOptionPane.showMessageDialog(null, funcionario);
        viewDadosProduto dadosFun = new viewDadosProduto(null, true, produto);
        dadosFun.setVisible(true);
        listProduto.clear();
        listProduto.addAll(contProd.listarTodos());
        limparCampos();
        atualizaTabela(listProduto);

        // TODO add your handling code here:
    }//GEN-LAST:event_botNovoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        listProduto.clear();
        listProduto.addAll(contProd.listarPorNome(txtBuscar.getText()));
        atualizaTabela(listProduto);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(viewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                viewProduto dialog = new viewProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botFechar;
    private javax.swing.JButton botLimpar;
    private javax.swing.JButton botNovo;
    private javax.swing.JButton botVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel labNome;
    private javax.swing.JLabel labQuantidade;
    private javax.swing.JLabel labValorVenda;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente2;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSTableMetro tabProduto;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        txtBuscar.setText("");
        labNome.setText("");
        labQuantidade.setText("");
        labValorVenda.setText("");
    }
    
    public String doubleString(double d) {
        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        String s = df.format(d);
        return s;
    }
    
    private void atualizaTabela(ArrayList<Produto> listProduto) {

        modelo.setNumRows(0);
        for (Produto i : listProduto) {
            
            modelo.addRow(new Object[]{i.getProdutoNome(),i.getProdutoQuantidade(), doubleString(i.getProdutoValorVenda())});
        }
    }
    
    public void darTamanhoAColuna() {
        tabProduto.getColumnModel().getColumn(0).setPreferredWidth(400);
        tabProduto.getColumnModel().getColumn(1).setPreferredWidth(55);
        tabProduto.getColumnModel().getColumn(2).setPreferredWidth(35);
      //  tabProdutoVenda.getColumnModel().getColumn(3).setPreferredWidth(10);
        //  seuScrollPane.setBorder(BorderFactory.createBevelBorder(0));
    }

}
