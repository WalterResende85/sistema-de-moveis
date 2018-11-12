package model;

import dao.FornecedorDAO;

import java.sql.SQLException;
import java.util.List;

public class Fornecedor {

    private Long idFornecedor;
    private String nome;
    private String cnpj;
    private String email;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String uf;
    private String cidade;
    

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor, String nome, String cnpj, String email, String cep, String logradouro, String numero, String complemento, String bairro, String uf, String cidade) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.uf = uf;
        this.cidade = cidade;
        
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FornecedorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        FornecedorDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        FornecedorDAO.excluir(this);
    }

    public static Fornecedor obterFornecedor(Long idFornecedor) throws SQLException, ClassNotFoundException {
        return FornecedorDAO.obterFornecedor(idFornecedor);
    }

    public static List<Fornecedor> obterTodosFornecedor() throws ClassNotFoundException, SQLException {
        return FornecedorDAO.obterTodosFornecedor();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}
