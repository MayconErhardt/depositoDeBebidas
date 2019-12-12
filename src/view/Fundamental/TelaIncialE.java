package view.Fundamental;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controle.ControleCaixa;
import controle.ControleFuncionario;
import controle.ControleItemCompra;
import controle.ControlePagamento;
import controle.ControleVenda;
import java.awt.Color;
import java.awt.Font;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Caixa;
import modelo.Funcionario;
import modelo.ItemCompra;

import modelo.Pagamento;
import modelo.Venda;

import view.Cliente.viewCliente;
import view.Fornecedor.viewFornecedor;
import view.Funcionario.viewDadosFuncionario;
import view.Funcionario.viewFuncionario;
import view.Fundamental.ComprarProduto.CompraProd;

import view.Fundamental.Conta.ContasList;
import view.Fundamental.Conta.PagarConta;

import view.Fundamental.Orçamento.OrcamentoList;
import view.Fundamental.Promocao.FazerPromocao;

import view.Fundamental.RealizarVenda.Receber;
import view.Fundamental.RealizarVenda.Vendas;
import view.Fundamental.abrirCaixa.AbrirCaixa;
import view.Fundamental.fecharCaixa.FecharCaixa;
import view.Produto.viewProduto;
import view.Saida.Relatorio;

/**
 *
 * @author Maycon
 */
public class TelaIncialE extends javax.swing.JFrame {

    /**
     * Creates new form TelaIncial
     *
     * @param func
     */
    DefaultTableModel modeloPagamento;
    DefaultTableModel modeloVencimento;
    DefaultTableModel modeloRecebimentos;

    private Caixa caixa = new Caixa();
    ControleCaixa contCaixa = new ControleCaixa();
    private Funcionario funcionario;

    ArrayList<Pagamento> listPag = new ArrayList<>();
    ArrayList<ItemCompra> listaVencimento = new ArrayList<>();
    ArrayList<Venda> listaVenda = new ArrayList<>();

    ControlePagamento contPagamento = new ControlePagamento();
    ControleItemCompra contItemCompra = new ControleItemCompra();
    

    private SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");

    
    
    
    
    
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    
    
    
    
    public TelaIncialE(Funcionario func) {
        initComponents();
        PainelPagamentos.setVisible(false);
        painelRecebimentos.setVisible(false);
        painelVencimentos.setVisible(false);
        
        modeloPagamento = (DefaultTableModel) tabPagamentos.getModel();
        modeloVencimento = (DefaultTableModel) tabVencimentos.getModel();
        modeloRecebimentos = (DefaultTableModel) tabRecebimentos.getModel();

        // LISTA DE CONTAS A PAGAR NA SEMANA
        Date hojeDataConta = new Date();

        Calendar calDataConta = Calendar.getInstance();

        calDataConta.add(calDataConta.DAY_OF_MONTH, +7);

        Date proximaDataConta = calDataConta.getTime();

        listPag.addAll(contPagamento.buscarPorPeriodo(hojeDataConta, proximaDataConta));
        if (!listPag.isEmpty()) {
            
            PainelPagamentos.setVisible(true);
            darTamanhoAColunaPagamento();
            atualizaTabelaPagamento(listPag);
        }

        // PRODUTOS A VENCER
        Date hoje = new Date();

        Calendar cal = Calendar.getInstance();

        cal.add(cal.MONTH, +1);

        Date proximaData = cal.getTime();

        listaVencimento.addAll(contItemCompra.produtoVencimento(hoje, proximaData));
        if (!listaVencimento.isEmpty()) {
           

            painelVencimentos.setVisible(true);
            darTamanhoAColunaVencimento();
            for (ItemCompra ic : listaVencimento) {
                atualizaTabelaVencimento(listaVencimento);
            }
        } else {
            painelVencimentos.setVisible(false);
        }

        // busca de venda em aberto
        ControleVenda controleVenda = new ControleVenda();
        listaVenda.addAll(controleVenda.listarVendaPendente());

        if (!(listaVenda.isEmpty())) {
     
            painelRecebimentos.setVisible(true);
            darTamanhoAColunaRecebimento();
            atualizaTabelaRecebimento(listaVenda);
        }

        List<Caixa> c = contCaixa.buscar();
        if (!c.isEmpty()) {
            botAbrirCaixa.setEnabled(false);
        }

        super.setExtendedState(MAXIMIZED_BOTH);
        if (func.getFuncionarioCargo().equals("GERENTE")) {
            funcionario = func;

        } else {
            
            botFuncionario.setText("<html><center>ALTERAR<br> DADOS</center></html>");
            funcionario = func;
        }
        botIcons();
   
        
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tabPagamentos.setFont(new Font("SansSerif", 0, 12));
        tabRecebimentos.setFont(new Font("SansSerif", 0, 12));
        tabVencimentos.setFont(new Font("SansSerif", 0, 12));
        direita.setBackground(new java.awt.Color(209, 209, 209));
        direita.setForeground(new java.awt.Color(102, 102, 102));
        esquerda.setBackground(new java.awt.Color(209, 209, 209));
        esquerda.setForeground(new java.awt.Color(102, 102, 102));
        
        tabRecebimentos.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        tabRecebimentos.getColumnModel().getColumn(1).setCellRenderer(direita);
        tabRecebimentos.getColumnModel().getColumn(2).setCellRenderer(direita);
        
        tabPagamentos.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        tabPagamentos.getColumnModel().getColumn(1).setCellRenderer(direita);
        tabPagamentos.getColumnModel().getColumn(2).setCellRenderer(direita);
        
        tabVencimentos.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        tabVencimentos.getColumnModel().getColumn(1).setCellRenderer(direita);
        tabVencimentos.getColumnModel().getColumn(2).setCellRenderer(direita);
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        botFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        painelTotal = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botCliente = new javax.swing.JButton();
        botFuncionario = new javax.swing.JButton();
        botFornecedor = new javax.swing.JButton();
        botProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        botAbrirCaixa = new javax.swing.JButton();
        botOrçamento = new javax.swing.JButton();
        botVenda = new javax.swing.JButton();
        botFecharCaixa = new javax.swing.JButton();
        botComprarProduto = new javax.swing.JButton();
        botRelatorio = new javax.swing.JButton();
        botRegistrarConta = new javax.swing.JButton();
        painelNotif = new javax.swing.JPanel();
        painelVencimentos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabVencimentos = new rojerusan.RSTableMetro();
        jButton2 = new javax.swing.JButton();
        botNaoNotificar1 = new javax.swing.JButton();
        PainelPagamentos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabPagamentos = new rojerusan.RSTableMetro();
        botPagar1 = new javax.swing.JButton();
        painelRecebimentos = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabRecebimentos = new rojerusan.RSTableMetro();
        botReceber = new javax.swing.JButton();
        botAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setResizable(false);

        rSPanelGradiente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botFechar.setBackground(new java.awt.Color(255, 0, 0));
        botFechar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botFechar.setForeground(new java.awt.Color(255, 255, 255));
        botFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/fechar34px.png"))); // NOI18N
        botFechar.setContentAreaFilled(false);
        botFechar.setFocusable(false);
        botFechar.setOpaque(true);
        botFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botFecharMouseEntered(evt);
            }
        });
        botFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFecharActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de Gerenciamento para Depósito de Bebidas");

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        painelTotal.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANUTENÇÃO");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 1, 35, 0));

        botCliente.setBackground(new java.awt.Color(204, 204, 255));
        botCliente.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/clienteColorido.png"))); // NOI18N
        botCliente.setText("CLIENTE");
        botCliente.setBorder(null);
        botCliente.setContentAreaFilled(false);
        botCliente.setFocusable(false);
        botCliente.setOpaque(true);
        botCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botClienteMouseEntered(evt);
            }
        });
        botCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botClienteActionPerformed(evt);
            }
        });
        jPanel1.add(botCliente);

        botFuncionario.setBackground(new java.awt.Color(204, 204, 255));
        botFuncionario.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/funcionario32px.png"))); // NOI18N
        botFuncionario.setText("FUNCIONÁRIO");
        botFuncionario.setBorder(null);
        botFuncionario.setContentAreaFilled(false);
        botFuncionario.setFocusable(false);
        botFuncionario.setOpaque(true);
        botFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botFuncionarioMouseEntered(evt);
            }
        });
        botFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFuncionarioActionPerformed(evt);
            }
        });
        jPanel1.add(botFuncionario);

        botFornecedor.setBackground(new java.awt.Color(204, 204, 255));
        botFornecedor.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/fornecedor32px.png"))); // NOI18N
        botFornecedor.setText("FORNECEDOR");
        botFornecedor.setBorder(null);
        botFornecedor.setContentAreaFilled(false);
        botFornecedor.setFocusable(false);
        botFornecedor.setOpaque(true);
        botFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botFornecedorMouseEntered(evt);
            }
        });
        botFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(botFornecedor);

        botProduto.setBackground(new java.awt.Color(204, 204, 255));
        botProduto.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/produto30px.png"))); // NOI18N
        botProduto.setText("PRODUTO");
        botProduto.setBorder(null);
        botProduto.setContentAreaFilled(false);
        botProduto.setFocusable(false);
        botProduto.setOpaque(true);
        botProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botProdutoMouseEntered(evt);
            }
        });
        botProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(botProduto);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MOVIMENTAÇÃO");
        jPanel2.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(2, 4, 30, 20));

        botAbrirCaixa.setBackground(new java.awt.Color(204, 204, 255));
        botAbrirCaixa.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botAbrirCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/abrirCaixa60px.png"))); // NOI18N
        botAbrirCaixa.setText("<html><center>ABRIR<br>CAIXA</center></html>");
        botAbrirCaixa.setBorder(null);
        botAbrirCaixa.setContentAreaFilled(false);
        botAbrirCaixa.setFocusable(false);
        botAbrirCaixa.setOpaque(true);
        botAbrirCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botAbrirCaixaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botAbrirCaixaMouseEntered(evt);
            }
        });
        botAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAbrirCaixaActionPerformed(evt);
            }
        });
        jPanel5.add(botAbrirCaixa);

        botOrçamento.setBackground(new java.awt.Color(204, 204, 255));
        botOrçamento.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botOrçamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/orçamento.png"))); // NOI18N
        botOrçamento.setText("<html>ORÇAMENTO</html>");
        botOrçamento.setBorder(null);
        botOrçamento.setContentAreaFilled(false);
        botOrçamento.setFocusable(false);
        botOrçamento.setOpaque(true);
        botOrçamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botOrçamentoMouseEntered(evt);
            }
        });
        botOrçamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botOrçamentoActionPerformed(evt);
            }
        });
        jPanel5.add(botOrçamento);

        botVenda.setBackground(new java.awt.Color(204, 204, 255));
        botVenda.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/realizarVenda.png"))); // NOI18N
        botVenda.setText("<html><center>REALIZAR<BR>VENDA</center></html>");
        botVenda.setBorder(null);
        botVenda.setContentAreaFilled(false);
        botVenda.setFocusable(false);
        botVenda.setOpaque(true);
        botVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botVendaMouseEntered(evt);
            }
        });
        botVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVendaActionPerformed(evt);
            }
        });
        jPanel5.add(botVenda);

        botFecharCaixa.setBackground(new java.awt.Color(204, 204, 255));
        botFecharCaixa.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botFecharCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/fecharCaixa60px.png"))); // NOI18N
        botFecharCaixa.setText("<html><center>FECHAR<br> CAIXA</center></html");
        botFecharCaixa.setBorder(null);
        botFecharCaixa.setContentAreaFilled(false);
        botFecharCaixa.setFocusable(false);
        botFecharCaixa.setOpaque(true);
        botFecharCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botFecharCaixaMouseEntered(evt);
            }
        });
        botFecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botFecharCaixaActionPerformed(evt);
            }
        });
        jPanel5.add(botFecharCaixa);

        botComprarProduto.setBackground(new java.awt.Color(204, 204, 255));
        botComprarProduto.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botComprarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/comprarProduto60px.png"))); // NOI18N
        botComprarProduto.setText("<html><center>COMPRAR<br>PRODUTO</center></html");
        botComprarProduto.setBorder(null);
        botComprarProduto.setContentAreaFilled(false);
        botComprarProduto.setFocusable(false);
        botComprarProduto.setOpaque(true);
        botComprarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botComprarProdutoMouseEntered(evt);
            }
        });
        botComprarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botComprarProdutoActionPerformed(evt);
            }
        });
        jPanel5.add(botComprarProduto);

        botRelatorio.setBackground(new java.awt.Color(204, 204, 255));
        botRelatorio.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/relatorio60px.png"))); // NOI18N
        botRelatorio.setText("<html>RELATÓRIO</html>");
        botRelatorio.setBorder(null);
        botRelatorio.setContentAreaFilled(false);
        botRelatorio.setFocusable(false);
        botRelatorio.setOpaque(true);
        botRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botRelatorioMouseEntered(evt);
            }
        });
        botRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRelatorioActionPerformed(evt);
            }
        });
        jPanel5.add(botRelatorio);

        botRegistrarConta.setBackground(new java.awt.Color(204, 204, 255));
        botRegistrarConta.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        botRegistrarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/contas.png"))); // NOI18N
        botRegistrarConta.setText("<html><center>CONTAS E<br>PAGAMENTOS</center></html");
        botRegistrarConta.setBorder(null);
        botRegistrarConta.setContentAreaFilled(false);
        botRegistrarConta.setFocusable(false);
        botRegistrarConta.setOpaque(true);
        botRegistrarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botRegistrarContaMouseEntered(evt);
            }
        });
        botRegistrarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botRegistrarContaActionPerformed(evt);
            }
        });
        jPanel5.add(botRegistrarConta);

        javax.swing.GroupLayout painelTotalLayout = new javax.swing.GroupLayout(painelTotal);
        painelTotal.setLayout(painelTotalLayout);
        painelTotalLayout.setHorizontalGroup(
            painelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelTotalLayout.createSequentialGroup()
                        .addGroup(painelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        painelTotalLayout.setVerticalGroup(
            painelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelNotif.setBackground(new java.awt.Color(255, 255, 255));

        painelVencimentos.setBackground(new java.awt.Color(255, 255, 255));
        painelVencimentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createTitledBorder(null, "Vencimentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14)))); // NOI18N
        painelVencimentos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tabVencimentos.setAutoCreateRowSorter(true);
        tabVencimentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0)));
        tabVencimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PRODUTO", "VENCIMENTO", "QUANTIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabVencimentos.setAltoHead(27);
        tabVencimentos.setAutoscrolls(false);
        tabVencimentos.setColorBackgoundHead(new java.awt.Color(250, 250, 250));
        tabVencimentos.setColorFilasBackgound1(new java.awt.Color(209, 209, 209));
        tabVencimentos.setColorFilasBackgound2(new java.awt.Color(209, 209, 209));
        tabVencimentos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabVencimentos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabVencimentos.setColorForegroundHead(new java.awt.Color(51, 51, 51));
        tabVencimentos.setColorSelBackgound(new java.awt.Color(40, 53, 147));
        tabVencimentos.setFuenteFilas(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tabVencimentos.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tabVencimentos.setFuenteHead(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tabVencimentos.setGridColor(new java.awt.Color(204, 204, 204));
        tabVencimentos.setGrosorBordeFilas(0);
        tabVencimentos.setGrosorBordeHead(0);
        tabVencimentos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabVencimentos.setMultipleSeleccion(false);
        tabVencimentos.setOpaque(false);
        tabVencimentos.setSelectionBackground(new java.awt.Color(40, 53, 147));
        tabVencimentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabVencimentos);

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/desconto18px.png"))); // NOI18N
        jButton2.setText("PROMOÇÃO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        botNaoNotificar1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botNaoNotificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/naoNotificar18px.png"))); // NOI18N
        botNaoNotificar1.setText("NÃO NOTIFICAR");
        botNaoNotificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNaoNotificar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelVencimentosLayout = new javax.swing.GroupLayout(painelVencimentos);
        painelVencimentos.setLayout(painelVencimentosLayout);
        painelVencimentosLayout.setHorizontalGroup(
            painelVencimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVencimentosLayout.createSequentialGroup()
                .addComponent(botNaoNotificar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(painelVencimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
        );
        painelVencimentosLayout.setVerticalGroup(
            painelVencimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVencimentosLayout.createSequentialGroup()
                .addGap(0, 118, Short.MAX_VALUE)
                .addGroup(painelVencimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(botNaoNotificar1)))
            .addGroup(painelVencimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelVencimentosLayout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );

        PainelPagamentos.setBackground(new java.awt.Color(255, 255, 255));
        PainelPagamentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createTitledBorder(null, "Pagamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14)))); // NOI18N
        PainelPagamentos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tabPagamentos.setAutoCreateRowSorter(true);
        tabPagamentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0)));
        tabPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CONTA", "VENCIMENTO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPagamentos.setAltoHead(27);
        tabPagamentos.setAutoscrolls(false);
        tabPagamentos.setColorBackgoundHead(new java.awt.Color(250, 250, 250));
        tabPagamentos.setColorFilasBackgound1(new java.awt.Color(209, 209, 209));
        tabPagamentos.setColorFilasBackgound2(new java.awt.Color(209, 209, 209));
        tabPagamentos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabPagamentos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabPagamentos.setColorForegroundHead(new java.awt.Color(51, 51, 51));
        tabPagamentos.setColorSelBackgound(new java.awt.Color(40, 53, 147));
        tabPagamentos.setFuenteFilas(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tabPagamentos.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tabPagamentos.setFuenteHead(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tabPagamentos.setGridColor(new java.awt.Color(204, 204, 204));
        tabPagamentos.setGrosorBordeFilas(0);
        tabPagamentos.setGrosorBordeHead(0);
        tabPagamentos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabPagamentos.setMultipleSeleccion(false);
        tabPagamentos.setOpaque(false);
        tabPagamentos.setSelectionBackground(new java.awt.Color(40, 53, 147));
        tabPagamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabPagamentos);

        botPagar1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botPagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/pagar18px.png"))); // NOI18N
        botPagar1.setText("PAGAR");
        botPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botPagar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelPagamentosLayout = new javax.swing.GroupLayout(PainelPagamentos);
        PainelPagamentos.setLayout(PainelPagamentosLayout);
        PainelPagamentosLayout.setHorizontalGroup(
            PainelPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPagamentosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PainelPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );
        PainelPagamentosLayout.setVerticalGroup(
            PainelPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPagamentosLayout.createSequentialGroup()
                .addGap(0, 153, Short.MAX_VALUE)
                .addComponent(botPagar1))
            .addGroup(PainelPagamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PainelPagamentosLayout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 28, Short.MAX_VALUE)))
        );

        painelRecebimentos.setBackground(new java.awt.Color(255, 255, 255));
        painelRecebimentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createTitledBorder(null, "Recebimentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14)))); // NOI18N
        painelRecebimentos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        tabRecebimentos.setAutoCreateRowSorter(true);
        tabRecebimentos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0)));
        tabRecebimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CLIENTE", "DATA", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabRecebimentos.setAltoHead(27);
        tabRecebimentos.setAutoscrolls(false);
        tabRecebimentos.setColorBackgoundHead(new java.awt.Color(250, 250, 250));
        tabRecebimentos.setColorFilasBackgound1(new java.awt.Color(209, 209, 209));
        tabRecebimentos.setColorFilasBackgound2(new java.awt.Color(209, 209, 209));
        tabRecebimentos.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabRecebimentos.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabRecebimentos.setColorForegroundHead(new java.awt.Color(51, 51, 51));
        tabRecebimentos.setColorSelBackgound(new java.awt.Color(40, 53, 147));
        tabRecebimentos.setFuenteFilas(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tabRecebimentos.setFuenteFilasSelect(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tabRecebimentos.setFuenteHead(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tabRecebimentos.setGridColor(new java.awt.Color(204, 204, 204));
        tabRecebimentos.setGrosorBordeFilas(0);
        tabRecebimentos.setGrosorBordeHead(0);
        tabRecebimentos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabRecebimentos.setMultipleSeleccion(false);
        tabRecebimentos.setOpaque(false);
        tabRecebimentos.setSelectionBackground(new java.awt.Color(40, 53, 147));
        tabRecebimentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabRecebimentos);
        if (tabRecebimentos.getColumnModel().getColumnCount() > 0) {
            tabRecebimentos.getColumnModel().getColumn(0).setResizable(false);
            tabRecebimentos.getColumnModel().getColumn(1).setResizable(false);
            tabRecebimentos.getColumnModel().getColumn(2).setResizable(false);
        }

        botReceber.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/receber18px.png"))); // NOI18N
        botReceber.setText("RECEBER");
        botReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botReceberActionPerformed(evt);
            }
        });

        botAtualizar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        botAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons/atualizar18px.png"))); // NOI18N
        botAtualizar.setText("ATUALIZAR");
        botAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelRecebimentosLayout = new javax.swing.GroupLayout(painelRecebimentos);
        painelRecebimentos.setLayout(painelRecebimentosLayout);
        painelRecebimentosLayout.setHorizontalGroup(
            painelRecebimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRecebimentosLayout.createSequentialGroup()
                .addComponent(botAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );
        painelRecebimentosLayout.setVerticalGroup(
            painelRecebimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRecebimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelRecebimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botReceber)
                    .addComponent(botAtualizar)))
        );

        javax.swing.GroupLayout painelNotifLayout = new javax.swing.GroupLayout(painelNotif);
        painelNotif.setLayout(painelNotifLayout);
        painelNotifLayout.setHorizontalGroup(
            painelNotifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNotifLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelNotifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelVencimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelPagamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelRecebimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelNotifLayout.setVerticalGroup(
            painelNotifLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNotifLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelVencimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelPagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelRecebimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelNotif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botFecharActionPerformed

        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_botFecharActionPerformed

    private void botFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botFecharMouseEntered

        botFechar.setForeground(Color.red);
        botFechar.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_botFecharMouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int linha = -1;
        linha = tabVencimentos.getSelectedRow();
        if (linha != -1) {
            ItemCompra icompra = new ItemCompra();
            icompra = listaVencimento.get(linha);
            FazerPromocao fazPromo = new FazerPromocao(null, true, icompra);
            fazPromo.setVisible(true);

            Date hoje = new Date();

            Calendar cal = Calendar.getInstance();

            cal.add(cal.MONTH, +1);

            Date proximaData = cal.getTime();

            listaVencimento.clear();
            atualizaTabelaVencimento(listaVencimento);
            listaVencimento.addAll(contItemCompra.produtoVencimento(hoje, proximaData));
            if (!listaVencimento.isEmpty()) {
            
                painelVencimentos.setVisible(true);
                darTamanhoAColunaVencimento();
                for (ItemCompra ic : listaVencimento) {
                    atualizaTabelaVencimento(listaVencimento);
                }
            } else {
                
                painelVencimentos.setVisible(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM PRODUTO NA TABELA!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botNaoNotificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botNaoNotificar1ActionPerformed

        int linhaNaoNotificar = -1;
        linhaNaoNotificar = tabVencimentos.getSelectedRow();
        if (linhaNaoNotificar != -1) {
            ItemCompra ic = listaVencimento.get(linhaNaoNotificar);
            ic.setNotificar('S');
            ControleItemCompra contIC = new ControleItemCompra();
            contIC.salvarAlteracao(ic);

            Date hoje = new Date();

            Calendar cal = Calendar.getInstance();

            cal.add(cal.MONTH, +1);

            Date proximaData = cal.getTime();

            listaVencimento.clear();
            atualizaTabelaVencimento(listaVencimento);
            listaVencimento.addAll(contItemCompra.produtoVencimento(hoje, proximaData));
            if (!listaVencimento.isEmpty()) {
                painelVencimentos.setVisible(true);
                darTamanhoAColunaVencimento();

                atualizaTabelaVencimento(listaVencimento);

            } else {
                painelVencimentos.setVisible(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELEIONE UM PRODUTO    \nNA TABELA PARA NÃO  \nSER NOTIFICADO SOBRE O      \n VENCIMENTO NOVAMENTE!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botNaoNotificar1ActionPerformed

    private void botPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botPagar1ActionPerformed

        int linhaPagamento = -1;
        linhaPagamento = tabPagamentos.getSelectedRow();
        if (linhaPagamento != -1) {
            Pagamento pagamento = listPag.get(linhaPagamento);
            PagarConta pag = new PagarConta(null, true, pagamento);
            pag.setVisible(true);
            listPag.clear();

            Date hojeDataConta = new Date();

            Calendar calDataConta = Calendar.getInstance();

            calDataConta.add(calDataConta.DAY_OF_MONTH, +7);

            Date proximaDataConta = calDataConta.getTime();

            ControlePagamento p = new ControlePagamento();
            listPag.clear();
            listPag.addAll(p.buscarPorPeriodo(hojeDataConta, proximaDataConta));
            atualizaTabelaPagamento(listPag);

            if (listPag.isEmpty()) {
                PainelPagamentos.setVisible(false);
            } else {
                atualizaTabelaPagamento(listPag);
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UMA CONTA PARA SER PAGA!");
        }

    }//GEN-LAST:event_botPagar1ActionPerformed

    private void botClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botClienteMouseEntered

        botCliente.setForeground(Color.red);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.BLACK);
        botVenda.setForeground(Color.BLACK);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
//        botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_botClienteMouseEntered

    private void botClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botClienteActionPerformed
        viewCliente viewCli = new viewCliente(null, true);
        viewCli.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botClienteActionPerformed

    private void botFuncionarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botFuncionarioMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.red);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFechar.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
//        botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botFuncionarioMouseEntered

    private void botFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botFuncionarioActionPerformed
        //        JOptionPane.showMessageDialog(null, funcionario.getFuncionarioCargo());
        if (funcionario.getFuncionarioCargo().equals("GERENTE")) {
            viewFuncionario viewFun = new viewFuncionario(null, true, funcionario);
            viewFun.setVisible(true);
        } else {
            boolean x = true;
            viewDadosFuncionario viewDadosFun = new viewDadosFuncionario(null, true, funcionario, x, funcionario);
            viewDadosFun.setVisible(true);
        }
        ControleFuncionario contFunc = new ControleFuncionario();
        funcionario = contFunc.buscaEu(funcionario.getFuncionarioId());
        if (funcionario.getFuncionarioCargo().equals("GERENTE")) {

        } else {
            botFuncionario.setText("<html><center>ALTERAR<br>DADOS</center></html>");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botFuncionarioActionPerformed

    private void botFornecedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botFornecedorMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.red);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
//        botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botFornecedorMouseEntered

    private void botFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botFornecedorActionPerformed

        viewFornecedor viewForn = new viewFornecedor(null, true);
        viewForn.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botFornecedorActionPerformed

    private void botProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botProdutoMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.red);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
//        botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);
        //  botProduto.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // TODO add your handling code here:
    }//GEN-LAST:event_botProdutoMouseEntered

    private void botProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botProdutoActionPerformed

        viewProduto viewProd = new viewProduto(null, true);
        viewProd.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botProdutoActionPerformed

    private void botAbrirCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botAbrirCaixaMouseClicked

        List<Caixa> c = contCaixa.buscar();

        if (c.isEmpty()) {
            AbrirCaixa abriCaixa = new AbrirCaixa(null, true, funcionario);
            abriCaixa.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "TEM UM CAIXA JÁ ABERTO!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botAbrirCaixaMouseClicked

    private void botAbrirCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botAbrirCaixaMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.red);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.BLACK);
        botVenda.setForeground(Color.BLACK);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botAbrirCaixaMouseEntered

    private void botAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAbrirCaixaActionPerformed

        //        AbrirCaixa abriCaixa = new AbrirCaixa(null, true, funcionario);
        //        abriCaixa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_botAbrirCaixaActionPerformed

    private void botOrçamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botOrçamentoMouseEntered
        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.red);
        botVenda.setForeground(Color.BLACK);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botOrçamentoMouseEntered

    private void botOrçamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botOrçamentoActionPerformed

        OrcamentoList orcaList = new OrcamentoList(null, true);
        orcaList.setVisible(true);
        ControleVenda cV = new ControleVenda();
        listaVenda.clear();
        listaVenda.addAll(cV.listarVendaPendente());

        if (listaVenda.isEmpty()) {

        } else {
            
            atualizaTabelaRecebimento(listaVenda);
            painelRecebimentos.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botOrçamentoActionPerformed

    private void botVendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botVendaMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.red);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botVendaMouseEntered

    private void botVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVendaActionPerformed

        Vendas vend = new Vendas(null, true);
        vend.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botVendaActionPerformed

    private void botFecharCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botFecharCaixaMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.RED);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botFecharCaixaMouseEntered

    private void botFecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botFecharCaixaActionPerformed

        FecharCaixa fechaCaixa = new FecharCaixa(null, true);
        fechaCaixa.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botFecharCaixaActionPerformed

    private void botComprarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botComprarProdutoMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.red);
        botRelatorio.setForeground(Color.BLACK);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);
        // TODO add your handling code here:
    }//GEN-LAST:event_botComprarProdutoMouseEntered

    private void botComprarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botComprarProdutoActionPerformed

        CompraProd comProd = new CompraProd(null, true);
        comProd.setVisible(true);
        
        Date hoje = new Date();

            Calendar cal = Calendar.getInstance();

            cal.add(cal.MONTH, +1);

            Date proximaData = cal.getTime();

            listaVencimento.clear();
            atualizaTabelaVencimento(listaVencimento);
            listaVencimento.addAll(contItemCompra.produtoVencimento(hoje, proximaData));
            if (!listaVencimento.isEmpty()) {
            
                painelVencimentos.setVisible(true);
                darTamanhoAColunaVencimento();
                for (ItemCompra ic : listaVencimento) {
                    atualizaTabelaVencimento(listaVencimento);
                }
            } else {
                
                painelVencimentos.setVisible(false);
            }
            
            
            listPag.clear();

            Date hojeDataConta = new Date();

            Calendar calDataConta = Calendar.getInstance();

            calDataConta.add(calDataConta.DAY_OF_MONTH, +7);

            Date proximaDataConta = calDataConta.getTime();

            ControlePagamento p = new ControlePagamento();
            listPag.clear();
            listPag.addAll(p.buscarPorPeriodo(hojeDataConta, proximaDataConta));
            atualizaTabelaPagamento(listPag);

            if (listPag.isEmpty()) {
                PainelPagamentos.setVisible(false);
            } else {
                atualizaTabelaPagamento(listPag);
            }

            

        // TODO add your handling code here:
    }//GEN-LAST:event_botComprarProdutoActionPerformed

    private void botRelatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botRelatorioMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.red);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.BLACK);

        // TODO add your handling code here:
    }//GEN-LAST:event_botRelatorioMouseEntered

    private void botRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRelatorioActionPerformed

        Relatorio rela = new Relatorio(null, true);
        rela.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_botRelatorioActionPerformed

    private void botRegistrarContaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botRegistrarContaMouseEntered

        botCliente.setForeground(Color.black);
        botFornecedor.setForeground(Color.black);
        botFuncionario.setForeground(Color.black);
        botProduto.setForeground(Color.black);
        botAbrirCaixa.setForeground(Color.BLACK);
        botFecharCaixa.setForeground(Color.BLACK);
        botOrçamento.setForeground(Color.black);
        botVenda.setForeground(Color.black);
        botComprarProduto.setForeground(Color.BLACK);
        botRelatorio.setForeground(Color.BLACK);
        //botRealizarPromoção.setForeground(Color.BLACK);
        botRegistrarConta.setForeground(Color.red);

        // TODO add your handling code here:
    }//GEN-LAST:event_botRegistrarContaMouseEntered

    private void botRegistrarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botRegistrarContaActionPerformed

        ContasList contLi = new ContasList(null, true);
        contLi.setVisible(true);
        ControlePagamento cP = new ControlePagamento();
        listPag.clear();
        Date hojeDataConta = new Date();

        Calendar calDataConta = Calendar.getInstance();

        calDataConta.add(calDataConta.DAY_OF_MONTH, +7);

        Date proximaDataConta = calDataConta.getTime();
        listPag.addAll(cP.buscarPorPeriodo(hojeDataConta, proximaDataConta));

        if (listPag.isEmpty()) {
            PainelPagamentos.setVisible(false);
        } else {
            
            atualizaTabelaPagamento(listPag);
            PainelPagamentos.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botRegistrarContaActionPerformed

    private void botReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botReceberActionPerformed

        int linhaReceber = -1;
        linhaReceber = tabRecebimentos.getSelectedRow();
        if (linhaReceber != -1) {
            Venda venda = listaVenda.get(linhaReceber);
            Receber pag = new Receber(null, true, venda);
            pag.setVisible(true);
            listaVenda.clear();

            ControleVenda v = new ControleVenda();
            listaVenda.addAll(v.listarVendaPendente());
            atualizaTabelaRecebimento(listaVenda);

            if (listaVenda.isEmpty()) {
                painelRecebimentos.setVisible(false);
            } else {
                atualizaTabelaRecebimento(listaVenda);
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UMA CONTA PARA SER PAGA!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botReceberActionPerformed

    private void botAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAtualizarActionPerformed

        ControleVenda cV = new ControleVenda();
        listaVenda.clear();
        listaVenda.addAll(cV.listarVendaPendente());

        if (listaVenda.isEmpty()) {
            tabRecebimentos.setVisible(false);
        } else {
            
            atualizaTabelaRecebimento(listaVenda);
            painelRecebimentos.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_botAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaIncialE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaIncialE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaIncialE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaIncialE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaIncialE(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelPagamentos;
    private javax.swing.JButton botAbrirCaixa;
    private javax.swing.JButton botAtualizar;
    private javax.swing.JButton botCliente;
    private javax.swing.JButton botComprarProduto;
    private javax.swing.JButton botFechar;
    private javax.swing.JButton botFecharCaixa;
    private javax.swing.JButton botFornecedor;
    private javax.swing.JButton botFuncionario;
    private javax.swing.JButton botNaoNotificar1;
    private javax.swing.JButton botOrçamento;
    private javax.swing.JButton botPagar1;
    private javax.swing.JButton botProduto;
    private javax.swing.JButton botReceber;
    private javax.swing.JButton botRegistrarConta;
    private javax.swing.JButton botRelatorio;
    private javax.swing.JButton botVenda;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel painelNotif;
    private javax.swing.JPanel painelRecebimentos;
    private javax.swing.JPanel painelTotal;
    private javax.swing.JPanel painelVencimentos;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    private rojerusan.RSTableMetro tabPagamentos;
    private rojerusan.RSTableMetro tabRecebimentos;
    private rojerusan.RSTableMetro tabVencimentos;
    // End of variables declaration//GEN-END:variables

    private void botIcons() {
        botCliente.setVerticalTextPosition(SwingConstants.BOTTOM);
        botCliente.setHorizontalTextPosition(SwingConstants.CENTER);
        botFornecedor.setVerticalTextPosition(SwingConstants.BOTTOM);
        botFornecedor.setHorizontalTextPosition(SwingConstants.CENTER);
        botFuncionario.setVerticalTextPosition(SwingConstants.BOTTOM);
        botFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);
        botProduto.setVerticalTextPosition(SwingConstants.BOTTOM);
        botProduto.setHorizontalTextPosition(SwingConstants.CENTER);
        botAbrirCaixa.setVerticalTextPosition(SwingConstants.BOTTOM);
        botAbrirCaixa.setHorizontalTextPosition(SwingConstants.CENTER);
        botFecharCaixa.setVerticalTextPosition(SwingConstants.BOTTOM);
        botFecharCaixa.setHorizontalTextPosition(SwingConstants.CENTER);
        botComprarProduto.setVerticalTextPosition(SwingConstants.BOTTOM);
        botComprarProduto.setHorizontalTextPosition(SwingConstants.CENTER);
        botRegistrarConta.setVerticalTextPosition(SwingConstants.BOTTOM);
        botRegistrarConta.setHorizontalTextPosition(SwingConstants.CENTER);

        botOrçamento.setVerticalTextPosition(SwingConstants.BOTTOM);
        botOrçamento.setHorizontalTextPosition(SwingConstants.CENTER);

        botVenda.setVerticalTextPosition(SwingConstants.BOTTOM);
        botVenda.setHorizontalTextPosition(SwingConstants.CENTER);
//        botRealizarPromoção.setVerticalTextPosition(SwingConstants.BOTTOM);
//        botRealizarPromoção.setHorizontalTextPosition(SwingConstants.CENTER);
        botRelatorio.setVerticalTextPosition(SwingConstants.BOTTOM);
        botRelatorio.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public String doubleString(double d) {

        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        String s = df.format(d);
        return s;
    }

    private void atualizaTabelaPagamento(ArrayList<Pagamento> listPag) {
        modeloPagamento.setNumRows(0);
        while (modeloPagamento.getRowCount() > 0) {
            modeloPagamento.removeRow(0);
        }
        if (!(listPag.isEmpty())) {

            for (Pagamento p : listPag) {
                modeloPagamento.addRow(new Object[]{p.getDescricao(), formatar.format(p.getDataVencimento()), doubleString(p.getValorPagar())});
            }
        }
    }

    private void atualizaTabelaVencimento(ArrayList<ItemCompra> listVen) {
        modeloVencimento.setNumRows(0);
        while (modeloVencimento.getRowCount() > 0) {
            modeloVencimento.removeRow(0);
        }
        if (!(listVen.isEmpty())) {
            for (ItemCompra ic : listVen) {
                modeloVencimento.addRow(new Object[]{ic.getProdutoCod().getProdutoNome(), formatar.format(ic.getDataVencimento()), ic.getQuantidade()});
            }
        }
    }

    private void atualizaTabelaRecebimento(ArrayList<Venda> listVen) {
        modeloRecebimentos.setNumRows(0);
        while (modeloRecebimentos.getRowCount() > 0) {
            modeloRecebimentos.removeRow(0);
        }
        if (!(listVen.isEmpty())) {

            for (Venda v : listVen) {
                modeloRecebimentos.addRow(new Object[]{v.getClienteCod().getClienteNome(), formatar.format(v.getVendaData()), doubleString(v.getVendaTotal())});
            }
        }
    }

    private void darTamanhoAColunaPagamento() {
        tabPagamentos.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabPagamentos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabPagamentos.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void darTamanhoAColunaVencimento() {
        tabVencimentos.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabVencimentos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabVencimentos.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void darTamanhoAColunaRecebimento() {
        tabPagamentos.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabPagamentos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabPagamentos.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

}
