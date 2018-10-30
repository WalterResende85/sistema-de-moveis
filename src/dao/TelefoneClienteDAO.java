package dao;

import model.TelefoneCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TelefoneClienteDAO {

    public static void gravar(TelefoneCliente telefone)throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao=BD.getConexao();
            String sql= "INSERT INTO telefoneCliente(idTelefone,telefone,cliente)"
                    +"VALUES (?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,telefone.getIdTelefone());
            comando.setString(2,telefone.getTelefone());
            if (telefone.getCliente()==null){
                comando.setNull(3,Types.NULL);
            }else {
                comando.setLong(3,telefone.getCliente().getIdCliente());
            }
            comando.execute();
            BD.fecharConexao(conexao,comando);
        }catch (SQLException e){
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }

    public static void alterar(TelefoneCliente telefone)throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getConexao();
            String sql = "UPDATE telefoneCliente SET telefone = ?, cliente = ?"
                    +" WHERE idTelefone=?";
            comando = conexao.prepareStatement(sql);

            comando.setString(1,telefone.getTelefone());
            if (telefone.getCliente()==null){
                comando.setNull(2,Types.NULL);
            }else{
                comando.setLong(2,telefone.getCliente().getIdCliente());
            }

            comando.setLong(3,telefone.getIdTelefone());
            comando.execute();
        }catch (SQLException e){
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }


    public static void excluir(TelefoneCliente telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from telefoneCliente where idTelefone = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, telefone.getIdTelefone());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }


    public static TelefoneCliente obterTelefone(Long idTelefone) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        TelefoneCliente telefone = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM TelefoneCliente WHERE TelefoneCliente.idTelefone = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,Math.toIntExact(idTelefone));
            ResultSet rs = comando.executeQuery();
            rs.first();
            telefone = new TelefoneCliente(
                    rs.getLong("idTelefone"),
                    rs.getString("telefone"),
                    null);
            telefone.setIdCliente(rs.getLong("cliente"));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return telefone;
    }

    public static List<TelefoneCliente> obterTodosTelefones() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<TelefoneCliente> telefones = new ArrayList<TelefoneCliente>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM telefoneCliente";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()){
                TelefoneCliente telefone = new TelefoneCliente(
                        rs.getLong("idTelefone"),
                        rs.getString("telefone"),
                        null);
                telefone.setIdCliente(rs.getLong("cliente"));                //PRA QUE SERVE ESSE COMANDO?
                telefones.add(telefone);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            BD.fecharConexao(conexao,comando);
        }
        return telefones;
    }

}