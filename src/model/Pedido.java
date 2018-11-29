package model;

import dao.PedidoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pedido {
    private Long idPedido;
    private Double valorTotal;
    private Cliente cliente;
    private Long idCliente;
    private Movel movel;
    private Long idMovel;

    public Pedido(Long idPedido, Double valorTotal, Movel movel, Cliente cliente) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.idCliente = 0l;
        this.movel = movel;
        this.idMovel = 0l;
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
         if (idCliente != 0 && cliente == null) {
          
             try {
                 cliente = Cliente.obterCliente(idCliente);
             } catch (SQLException ex) {
                 Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
             }
                    
    }
        
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdCliente(Long id) {
        this.idCliente = id;
    }

    public Movel getMovel() {
        return movel;
    }

    public void setMovel(Movel movel) {
        this.movel = movel;
    }

    public Long getIdMovel() {
        return idMovel;
    }

    public void setIdMovel(Long idMovel) {
        this.idMovel = idMovel;
    }
    
}