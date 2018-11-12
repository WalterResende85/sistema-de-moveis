package dao;

import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.TelefoneCliente;

public class ClienteDAO {

    public static void gravar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            String sql = "insert into cliente (nome ,cpf,dataNascimento,email,cep,logradouro,numero,complemento,"
                    + "bairro,uf,cidade,idCliente) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getDataNascimento());
            comando.setString(4, cliente.getEmail());
            comando.setString(5, cliente.getCep());
            comando.setString(6, cliente.getLogradouro());
            comando.setString(7, cliente.getNumero());
            comando.setString(8, cliente.getComplemento());
            comando.setString(9, cliente.getBairro());
            comando.setString(10, cliente.getUf());
            comando.setString(11, cliente.getCidade());
            comando.setLong(12, cliente.getIdCliente());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            BD.fecharConexao(conexao, comando);
            throw e;
        }
    }

    public static void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = ("UPDATE Cliente SET nome = ?, cpf=?, dataNascimento=?,email=?, cep=?, logradouro=?,"
                    + " numero=?, bairro=?, uf=?, cidade = ? WHERE idCliente = ?");
            comando = conexao.prepareStatement(sql);

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getDataNascimento());
            comando.setString(4, cliente.getEmail());
            comando.setString(5, cliente.getCep());
            comando.setString(6, cliente.getLogradouro());
            comando.setString(7, cliente.getNumero());
            comando.setString(8, cliente.getBairro());
            comando.setString(9, cliente.getUf());
            comando.setString(10, cliente.getCidade());
            comando.setLong(11, cliente.getIdCliente());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from Cliente WHERE idCliente=? ";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, cliente.getIdCliente());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }

    public static Cliente obterCLiente(Long idCliente) throws ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, idCliente);
            ResultSet rs = comando.executeQuery();
            rs.first();
            cliente = createUser(rs);
           

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return cliente;
    }

    public static List<Cliente> obterTodosClientes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM cliente";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                clientes.add(createUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return clientes;
    }

    public static List<TelefoneCliente> telefonesByClient(Long id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<TelefoneCliente> telephones = new ArrayList<>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM telefonecliente WHERE cliente = ?";
            ResultSet rs = comando.executeQuery(sql);
            while (rs.next()) {
                telephones.add(new TelefoneCliente(
                        rs.getLong("idTelefone"),
                        rs.getString("telefone"),
                        new Cliente()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return telephones;
    }

    private static Cliente createUser(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getLong("idCliente"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("dataNascimento"),
                rs.getString("email"),
                rs.getString("cep"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("uf"),
                rs.getString("cidade"));    //A ordem daqui tem que ser igual ao do construtor (antes o id tava em primeiro mas na classe é o ultimo)
    }

}
