/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maycon
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p order by p.produtoNome")
    , @NamedQuery(name = "Produto.findByProdutoNome", query = "SELECT p FROM Produto p WHERE p.produtoNome like :prodNome  order by p.produtoNome")
    , @NamedQuery(name = "Produto.nomeIgual", query = "SELECT p FROM Produto p where p.produtoNome = :nomeProd")
    , @NamedQuery(name = "Produto.produtoQuantEstoque", query = "SELECT p FROM Produto p where p.produtoQuantidade > 0 ORDER BY p.produtoNome")
    // ,@NamedQuery(name = "Produto.nomeIgual", query = "SELECT p FROM Produto p where p.produtoNome = :nomeProd")
    , @NamedQuery(name = "Produto.findByProdutoNomeEstoque", query = "SELECT p FROM Produto p WHERE p.produtoNome like :prodNome and p.produtoQuantidade >0 order by p.produtoNome")
  //  , @NamedQuery(name = "Produto.produtoVencimento", query = "SELECT p FROM Produto p WHERE p.listaProduto.dataVencimento BETWEEN :dataIim AND :dataFim")
    , @NamedQuery(name = "Produto.buscarProdutoParapromocao", query = "SELECT p FROM Produto p WHERE p.produtoNome = :prodNome ORDER BY p.produtoNome")
})
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produCod")
    private int produtoId;

    @Column(name = "nome")
    private String produtoNome;

    @Column(name = "quantidade")
    private int produtoQuantidade;

    @Column(name = "quantidadeMinima")
    private int quantidadeMinima;

    @Column(name = "valorVenda")
    private float produtoValorVenda;

    @Column(name = "valorCompra")
    private double produtoValorCompra;

   // @OneToMany(mappedBy = "produtoCod")
 //   private List<ItemCompra> listaProduto;
    
//    @OneToMany(mappedBy = "produtoCod", cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<OrcamentoProduto> listaProdutoOrcamento;

    public Produto() {
    }

    public Produto(int produtoId, String produtoNome, int produtoQuantidade, int quantidadeMinima, float produtoValorVenda, double produtoValorCompra, List<ItemCompra> listaProduto) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.produtoQuantidade = produtoQuantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.produtoValorVenda = produtoValorVenda;
        this.produtoValorCompra = produtoValorCompra;
//        this.listaProduto = listaProduto;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public int getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public float getProdutoValorVenda() {
        return produtoValorVenda;
    }

    public void setProdutoValorVenda(float produtoValorVenda) {
        this.produtoValorVenda = produtoValorVenda;
    }

    public double getProdutoValorCompra() {
        return produtoValorCompra;
    }

    public void setProdutoValorCompra(double produtoValorCompra) {
        this.produtoValorCompra = produtoValorCompra;
    }

//    public List<ItemCompra> getListaProduto() {
//        return listaProduto;
//    }
//
//    public void setListaProduto(List<ItemCompra> listaProduto) {
//        this.listaProduto = listaProduto;
//    }

    @Override
    public String toString() {
        return "Produto{" + "produtoId=" + produtoId + ", produtoNome=" + produtoNome + ", produtoQuantidade=" + produtoQuantidade + ", quantidadeMinima=" + quantidadeMinima + ", produtoValorVenda=" + produtoValorVenda + ", produtoValorCompra=" + produtoValorCompra +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.produtoId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.produtoId != other.produtoId) {
            return false;
        }
        return true;
    }

    

}
