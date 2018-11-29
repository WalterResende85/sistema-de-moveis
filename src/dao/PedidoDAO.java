package dao;

import model.Pedido;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public static void gravar(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into pedido(idPedido,valorTotal, idMovel, idFuncionario, idCliente)" +
                    "VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, pedido.getIdPedido());
            comando.setDouble(2, pedido.getValorTotal());
           
            if(pedido.getMovel() == null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setLong(3, pedido.getMovel().getIdMovel());
            }
             if(pedido.getFuncionario() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setLong(4, pedido.getFuncionario().getIdFuncionario());
            }
            
            if ( pedido.getCliente() == null){
                comando.setNull(5, Types.NULL);
            }else{
                comando.setLong(5, pedido.getCliente().getIdCliente());
            }
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }

    public static void alterar(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = ("UPDATE pedido SET  valorTotal=?, idMovel=?, idFuncionario=?, idCliente=? WHERE idPedido = ?");
            comando = conexao.prepareStatement(sql);

            comando.setDouble(1, pedido.getValorTotal());
             if(pedido.getMovel() == null){
                comando.setNull(2, Types.NULL);
            }else{
                comando.setLong(2, pedido.getMovel().getIdMovel());
            }
            if(pedido.getFuncionario() == null){
                comando.setNull(3, Types.NULL);
            }else{
                comando.setLong(3, pedido.getFuncionario().getIdFuncionario());
            }
            if ( pedido.getCliente() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setLong(4, pedido.getCliente().getIdCliente());
            }
            comando.setLong(5,pedido.getIdPedido());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }

    public static void excluir (Pedido pedido)throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from pedido where idPedido = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, pedido.getIdPedido());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Pedido obterPedido(Long idPedido) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        Pedido pedido = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM pedido WHERE pedido.idPedido = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,Math.toIntExact(idPedido));
            ResultSet rs = comando.executeQuery();
            rs.first();
            pedido = new Pedido(
                    rs.getLong("idPedido"),
                    rs.getDouble("valorTotal"),
                    null,
                    null,
                    null);
            pedido.setIdMovel(rs.getLong("idMovel"));
            pedido.setIdCliente(rs.getLong("idCliente"));
            
        }catch(SQLException e){
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }

        return pedido;
    }

    public static List<Pedido> obterTodosPedidos() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM pedido";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()){
                Pedido pedido = new Pedido(
                        rs.getLong("idPedido"),
                        rs.getDouble("valorTotal"),
                        null,
                        null,
                        null);
                pedido.setIdMovel(rs.getLong("idMovel"));
                pedido.setIdCliente(rs.getLong("idCliente"));
                pedidos.add(pedido);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            BD.fecharConexao(conexao,comando);
        }
        return pedidos;
    }
}
