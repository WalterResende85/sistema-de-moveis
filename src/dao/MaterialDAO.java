package dao;

import model.Material;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public static void gravar(Material material) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into Material (idMaterial, nome, tipo, valorUnitario, qtdEstoque, unidade)"
                    + "values (?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, material.getIdMaterial());  //nome do id da classe pai
            comando.setString(2, material.getNome());
            comando.setString(3, material.getTipo());
            comando.setDouble(4, material.getValorUnitario());
            comando.setDouble(5, material.getQtdEstoque());
            comando.setString(6, material.getUnidade());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            BD.fecharConexao(conexao, comando);
            throw e;
        }
    }

    public static void alterar(Material material) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE material SET nome = ?,tipo = ?, valorUnitario = ?,"
                    + " qtdEstoque = ?, unidade = ? WHERE idMaterial = ?";
            comando = conexao.prepareStatement(sql);
            
            comando.setString(1, material.getNome());
            comando.setString(2, material.getTipo());
            comando.setDouble(3, material.getValorUnitario());
            comando.setDouble(4, material.getQtdEstoque());
            comando.setString(5, material.getUnidade());
            comando.setLong(6, material.getIdMaterial());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }

    }

    public static void excluir(Material material) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from Material WHERE idMaterial=? ";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, material.getIdMaterial());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Material obterMaterial(long idMaterial) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Material material = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM Material WHERE idMaterial = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, idMaterial);
            ResultSet rs = comando.executeQuery();
            rs.first();
            material = new Material(
                    rs.getLong("idMaterial"),
                    rs.getString("nome"),
                    rs.getString("tipo"),
                    rs.getDouble("valorUnitario"),
                    rs.getDouble("qtdEstoque"),
                    rs.getString("unidade"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return material;
    }

    public static List<Material> obterTodosMateriais() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Material> materiais = new ArrayList<Material>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM material";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Material material = new Material(
                        rs.getLong("idMaterial"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("valorUnitario"),
                        rs.getDouble("qtdEstoque"),
                        rs.getString("unidade"));
                materiais.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return materiais;
    }
}
