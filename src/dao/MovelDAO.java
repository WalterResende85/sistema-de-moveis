package dao;

import model.Movel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovelDAO {

    public static void gravar(Movel movel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into movel (idMovel,nome,preco,tipo, idMaterial, altura, largura, comprimento,acabamento,peso)"
                    + "values (?,?,?,?,?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, movel.getIdMovel());
            comando.setString(2, movel.getNome());
            comando.setDouble(3, movel.getPreco());
            comando.setString(4, movel.getTipo());
            if(movel.getMaterial() == null){
                comando.setNull(5, Types.NULL);
            }else{
                comando.setLong(5, movel.getMaterial().getIdMaterial());
            }
            comando.setDouble(6, movel.getAltura());
            comando.setDouble(7, movel.getLargura());
            comando.setDouble(8, movel.getComprimento());
            comando.setString(9, movel.getAcabamento());
            comando.setDouble(10, movel.getPeso());
          
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Movel movel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = ("UPDATE Movel SET nome=?, preco=?, tipo=?,"
                    + " idMaterial=?, altura=?, largura=?, comprimento=?, acabamento=?, peso=? WHERE idMovel = ?");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, movel.getNome());
            comando.setDouble(2, movel.getPreco());
            comando.setString(3, movel.getTipo());
           if(movel.getMaterial() == null){
                comando.setNull(4, Types.NULL);
            }else{
                comando.setLong(4, movel.getMaterial().getIdMaterial());
            }
            comando.setDouble(5, movel.getAltura());
            comando.setDouble(6, movel.getLargura());
            comando.setDouble(7, movel.getComprimento());
            comando.setString(8, movel.getAcabamento());
            comando.setDouble(9, movel.getPeso());
                        
            comando.setLong(10, movel.getIdMovel());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }

    }

    public static void excluir(Movel movel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from movel where idMovel = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, movel.getIdMovel());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }

    }

    public static Movel obterMovel(Long idMovel) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Movel movel = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM movel WHERE idMovel = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, idMovel);
            ResultSet rs = comando.executeQuery();
            rs.first();
            movel = new Movel(
                    rs.getLong("idMovel"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getString("tipo"),
                    rs.getDouble("altura"),
                    rs.getDouble("largura"),
                    rs.getDouble("comprimento"),
                    rs.getString("acabamento"),
                    rs.getDouble("peso"),
                    null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movel;
    }

    public static List<Movel> obterTodosMoveis() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Movel> moveis = new ArrayList<Movel>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM movel";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Movel movel = new Movel(
                        rs.getLong("idMovel"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getString("tipo"),
                        rs.getDouble("altura"),
                        rs.getDouble("largura"),
                        rs.getDouble("comprimento"),
                        rs.getString("acabamento"),
                        rs.getDouble("peso"),
                        null);
                moveis.add(movel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return moveis;
    }
}
