package model;

import dao.PedidoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private Long idPedido=null;
    private Long idCliente=null;
    private Double valorTotal=0.0;
    private Cliente cliente;

    public Pedido(Long idPedido, Double valorTotal, Cliente cliente) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public Pedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public  void  gravar() throws SQLException, ClassNotFoundException{
        PedidoDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        PedidoDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        PedidoDAO.excluir(this);
    }

    public static  Pedido obterPedido(Long idPedido) throws  SQLException, ClassNotFoundException{
        return PedidoDAO.obterPedido(idPedido);
    }

    public static List< Pedido> obterTodosPedidos() throws ClassNotFoundException, SQLException{
        return  PedidoDAO.obterTodosPedidos();
    }

    public Long getIdCliente() {
        return this.cliente.getIdCliente();
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdCliente(Long id) {
        this.idCliente = id;
    }
}