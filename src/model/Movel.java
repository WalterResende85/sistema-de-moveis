package model;

import dao.MovelDAO;

import java.sql.SQLException;
import java.util.List;

public class Movel {

    private Long idMovel;
    private String nome;
    private Double preco;
    private String tipo;
    private String material;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private String acabamento;
    private Double peso;
    private Pedido pedido;
    private Long idPedido;

    public Movel(Long idMovel, String nome, double preco, String tipo, String material, double altura, double largura, double comprimento, String acabamento, double peso, Long idPedido) {
        this.idMovel = idMovel;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.material = material;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.acabamento = acabamento;
        this.peso = peso;
        this.idPedido = idPedido;
    }

    public Movel(Long idMovel, String nome) {
        this.idMovel = idMovel;
        this.nome = nome;
    }

    public Movel(Long idMovel, String nome, Long idPedido) {
        this.idMovel = idMovel;
        this.nome = nome;
        this.idPedido = pedido.getIdPedido();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        MovelDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        MovelDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        MovelDAO.excluir(this);
    }

    public static Movel obterMovel(Long idMovel) throws SQLException, ClassNotFoundException {
        return MovelDAO.obterMovel(idMovel);
    }

    public static List< Movel> obterTodosMovel() throws ClassNotFoundException, SQLException {
        return MovelDAO.obterTodosMoveis();
    }

    public Long getIdPedido() {
        return this.idPedido;
    }

    public Long getIdMovel() {
        return idMovel;
    }

    public void setIdMovel(long idMovel) {
        this.idMovel = idMovel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setIdPedido(Long id) {
        this.idPedido = id;
    }

    public void setIdMovel(Long id) {       //COLOCAR EM TODOS QUE TEM CHAVE ESTRANGEIRA
        this.idMovel = id;
    }

}
