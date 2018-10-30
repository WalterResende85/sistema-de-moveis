package dao;

import model.TelefoneFornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneFornecedorDAO {

    public static void gravar(TelefoneFornecedor telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO telefoneFornecedor(idTelefone,telefone,fornecedor)"
                    + "VALUES (?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, telefone.getIdTelefone());
            comando.setString(2, telefone.getTelefone());
            if (telefone.getFornecedor() == null) {
                comando.setNull(3, Types.NULL);
            } else {
                comando.setLong(3, telefone.getFornecedor().getIdFornecedor());
            }
            comando.execute();
            BD.fecharConexao(conexao,comando);
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static void alterar(TelefoneFornecedor telefone)throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getConexao();
            String sql = "UPDATE telefoneFornecedor SET telefone = ?, fornecedor = ?"
                    +" WHERE idTelefone=?";
            comando = conexao.prepareStatement(sql);

            comando.setString(1,telefone.getTelefone());
            if (telefone.getFornecedor()==null){
                comando.setNull(2,Types.NULL);
            }else{
                comando.setLong(2,telefone.getFornecedor().getIdFornecedor());
            }
            comando.setLong(3,telefone.getIdFornecedor());
            comando.execute();
        }catch (SQLException e){
            throw e;
        }finally {
            BD.fecharConexao(conexao,comando);
        }
    }


    public static void excluir(TelefoneFornecedor telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from telefoneFornecedor where idTelefone = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, telefone.getIdTelefone());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }


    public static TelefoneFornecedor obterTelefone(Long idTelefone) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        TelefoneFornecedor telefone = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM TelefoneFornecedor WHERE TelefoneFornecedor.idTelefone = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,Math.toIntExact(idTelefone));
            ResultSet rs = comando.executeQuery();
            rs.first();
            telefone = new TelefoneFornecedor(
                    rs.getLong("idTelefone"),
                    rs.getString("telefone"),
                    null);
            telefone.setIdFornecedor(rs.getLong("fornecedor"));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return telefone;
    }

    public static List<TelefoneFornecedor> obterTodosTelefones() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<TelefoneFornecedor> telefones = new ArrayList<TelefoneFornecedor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM telefoneFornecedor";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()){
                TelefoneFornecedor telefone = new TelefoneFornecedor(
                        rs.getLong("idTelefone"),
                        rs.getString("telefone"),
                        null);
                telefone.setIdFornecedor(rs.getLong("fornecedor"));                //PRA QUE SERVE ESSE COMANDO?
                telefones.add(telefone);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            BD.fecharConexao(conexao,comando);
        }
        return telefones;
        //teste do nome da pasta APAGAR DEPOIS
    }
}