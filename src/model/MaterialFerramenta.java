package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class MaterialFerramenta {
    private String nome;
    private String tipo;
    private double valorUnitario;
    private double qtdEstoque;
    private String unidade;
    private Fornecedor fornecedor;
    private Long idFornecedor;
    public MaterialFerramenta(){}

    public MaterialFerramenta( String nome, String tipo, double valorUnitario, double qtdEstoque, String unidade, Fornecedor fornecedor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorUnitario = valorUnitario;
        this.qtdEstoque = qtdEstoque;
        this.unidade = unidade;
        this.fornecedor = fornecedor;
        this.idFornecedor = 0l;
    }

    public Fornecedor getFornecedor() {
        if (idFornecedor != 0 && fornecedor == null) {
          
        
                 try {
                     fornecedor = Fornecedor.obterFornecedor(idFornecedor);
                 } catch (SQLException ex) {
                     Logger.getLogger(MaterialFerramenta.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(MaterialFerramenta.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
        return fornecedor;
    }
        
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
