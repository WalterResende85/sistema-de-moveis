package dao;

import model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public static void gravar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into fornecedor (nome, cnpj, email,"
                    + "cep, logradouro, numero, complemento, bairro,  uf, cidade, telefone, idfornecedor)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getCnpj());
            comando.setString(3, fornecedor.getEmail());
            comando.setString(4, fornecedor.getCep());
            comando.setString(5, fornecedor.getLogradouro());
            comando.setString(6, fornecedor.getNumero());
            comando.setString(7, fornecedor.getComplemento());
            comando.setString(8, fornecedor.getBairro());
            comando.setString(9, fornecedor.getUf());
            comando.setString(10, fornecedor.getCidade());
            comando.setString(11, fornecedor.getTelefone());
            comando.setLong(12, fornecedor.getIdFornecedor());
            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE Fornecedor SET nome = ?, cnpj = ?,"
                    + "email = ?, CEP = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, uf = ?, cidade = ?, telefone = ?"
                    + "WHERE idFornecedor = ? ";

            comando = conexao.prepareStatement(sql);

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getCnpj());
            comando.setString(3, fornecedor.getEmail());
            comando.setString(4, fornecedor.getCep());
            comando.setString(5, fornecedor.getLogradouro());
            comando.setString(6, fornecedor.getNumero());
            comando.setString(7, fornecedor.getComplemento());
            comando.setString(8, fornecedor.getBairro());
            comando.setString(9, fornecedor.getUf());
            comando.setString(10, fornecedor.getCidade());
            comando.setString(11, fornecedor.getTelefone());
            comando.setLong(12, fornecedor.getIdFornecedor());
            comando.execute();
            BD.fecharConexao(conexao, comando);

        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from Fornecedor WHERE idFornecedor=? ";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, fornecedor.getIdFornecedor());
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Fornecedor obterFornecedor(Long idFornecedor) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Fornecedor fornecedor = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM Fornecedor WHERE idFornecedor = ?";
            comando = conexao.prepareStatement(sql);
            comando.setInt(1, Math.toIntExact(idFornecedor));
            ResultSet rs = comando.executeQuery();
            rs.first();
            fornecedor = getFornecedor(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return fornecedor;
    }

    public static List<Fornecedor> obterTodosFornecedor() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();//coloca o nome da lista no plural
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM Fornecedor";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                fornecedores.add(getFornecedor(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return fornecedores;//retorna a lista
    }

    private final static Fornecedor getFornecedor(ResultSet rs) throws SQLException {
        return new Fornecedor(
                rs.getLong("idFornecedor"),
                rs.getString("nome"),
                rs.getString("cnpj"),
                rs.getString("email"),
                rs.getString("cep"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("uf"),
                rs.getString("cidade"),
                rs.getString("telefone")
        );
    }
}
