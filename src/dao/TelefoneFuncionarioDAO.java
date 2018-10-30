package dao;

import model.TelefoneFuncionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefoneFuncionarioDAO {

    public static void gravar(TelefoneFuncionario telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO telefoneFuncionario(idTelefone,telefone,funcionario)"
                    + "VALUES (?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, telefone.getIdTelefone());
            comando.setString(2, telefone.getTelefone());
            if (telefone.getFuncionario() == null) {
                comando.setNull(3, Types.NULL);
            } else {
                comando.setLong(3, telefone.getFuncionario().getIdFuncionario());
            }
            comando.execute();
            BD.fecharConexao(conexao,comando);
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }

    }

    public static void alterar(TelefoneFuncionario telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE telefoneFuncionario SET telefone = ?, funcionario = ?"
                    + " WHERE idTelefone=?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, telefone.getTelefone());
            if (telefone.getFuncionario() == null) {
                comando.setNull(2, Types.NULL);
            } else {
                comando.setLong(2, telefone.getFuncionario().getIdFuncionario());
            }
            comando.setLong(3,telefone.getIdTelefone());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static void excluir(TelefoneFuncionario telefone) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from telefoneFuncionario where idTelefone = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, telefone.getIdTelefone());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static TelefoneFuncionario obterTelefone(Long idTelefone) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        TelefoneFuncionario telefone = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM TelefoneFuncionario WHERE TelefoneFuncionario.idTelefone = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1,Math.toIntExact(idTelefone));
            ResultSet rs = comando.executeQuery();
            rs.first();
            telefone = new TelefoneFuncionario(
                    rs.getLong("idTelefone"),
                    rs.getString("telefone"),
                    null);
            telefone.setIdFuncionario(rs.getLong("funcionario"));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return telefone;
    }

    public static List<TelefoneFuncionario> obterTodosTelefones() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<TelefoneFuncionario> telefones = new ArrayList<TelefoneFuncionario>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM telefoneFuncionario";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()){
                TelefoneFuncionario telefone = new TelefoneFuncionario(
                        rs.getLong("idTelefone"),
                        rs.getString("telefone"),
                        null);
                telefone.setIdFuncionario(rs.getLong("funcionario"));                //PRA QUE SERVE ESSE COMANDO?
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
