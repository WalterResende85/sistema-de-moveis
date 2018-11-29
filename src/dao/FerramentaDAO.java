package dao;

import model.Ferramenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FerramentaDAO {

    public static void gravar(Ferramenta ferramenta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into Ferramenta (idFerramenta,nome,tipo,valorUnitario,qtdEstoque,unidade, idFornecedor)"
                    + "values (?,?,?,?,?,?,?)";

            comando = conexao.prepareStatement(sql);
            comando.setLong(1, ferramenta.getIdFerramenta());
            comando.setString(2, ferramenta.getNome());
            comando.setString(3, ferramenta.getTipo());
            comando.setDouble(4, ferramenta.getValorUnitario());
            comando.setDouble(5, ferramenta.getQtdEstoque());
            comando.setString(6, ferramenta.getUnidade());
             if(ferramenta.getFornecedor() == null){
                comando.setNull(7, Types.NULL);
            }else{
                comando.setLong(7, ferramenta.getFornecedor().getIdFornecedor());
            }
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            BD.fecharConexao(conexao, comando);
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Ferramenta ferramenta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = ("UPDATE Ferramenta SET nome = ?, tipo = ?, valorUnitario = ?, qtdEstoque = ?, unidade = ?, idFornecedor=?"
                    + "WHERE idFerramenta = ?");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, ferramenta.getNome());
            comando.setString(2, ferramenta.getTipo());
            comando.setDouble(3, ferramenta.getValorUnitario());
            comando.setDouble(4, ferramenta.getQtdEstoque());
            comando.setString(5, ferramenta.getUnidade());
             if(ferramenta.getFornecedor() == null){
                comando.setNull(6, Types.NULL);
            }else{
                comando.setLong(6, ferramenta.getFornecedor().getIdFornecedor());
            }
            comando.setLong(7, ferramenta.getIdFerramenta());
            
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Ferramenta ferramenta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from Ferramenta WHERE idFerramenta= ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, ferramenta.getIdFerramenta());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Ferramenta obterFerramenta(Long idFerramenta) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Ferramenta ferramenta = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM Ferramenta WHERE idFerramenta = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, idFerramenta);
            ResultSet rs = comando.executeQuery();
            rs.first();
            ferramenta = new Ferramenta(
                    rs.getLong("idFerramenta"),
                    rs.getString("nome"),
                    rs.getString("tipo"),
                    rs.getDouble("valorUnitario"),
                    rs.getDouble("qtdEstoque"),
                    rs.getString("unidade"),
                    null);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return ferramenta;
    }

    public static List<Ferramenta> obterTodasFerramentas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM Ferramenta";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                Ferramenta ferramenta = new Ferramenta(
                        rs.getLong("idFerramenta"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("valorUnitario"),
                        rs.getDouble("qtdEstoque"),
                        rs.getString("unidade"),
                        null);

                ferramentas.add(ferramenta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return ferramentas;
    }
}
