package dao;

import model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static void gravar (Funcionario funcionario) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into funcionario (nome, cpf, dataNascimento, email, cep, logradouro, numero, complemento, bairro, uf, cidade," +
                    " cargo, salario, comissao, senha, idFuncionario)" + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);

            comando.setString(1,funcionario.getNome());
            comando.setString(2,funcionario.getCpf());
            comando.setString(3,funcionario.getDataNascimento());
            comando.setString(4,funcionario.getEmail());
            comando.setString(5,funcionario.getCep());
            comando.setString(6,funcionario.getLogradouro());
            comando.setString(7,funcionario.getNumero());
            comando.setString(8,funcionario.getComplemento());
            comando.setString(9,funcionario.getBairro());
            comando.setString(10,funcionario.getUf());
            comando.setString(11,funcionario.getCidade());
            comando.setString(12,funcionario.getCargo());
            comando.setDouble(13,funcionario.getSalario());
            comando.setDouble(14,funcionario.getComissao());
            comando.setString(15,funcionario.getSenha());
            comando.setLong(16, funcionario.getIdFuncionario());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
            throw e;
        }
    }
    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getConexao();
            String sql = "update funcionario SET nome = ?, cpf = ?, dataNascimento = ?, email = ?, cep = ?, logradouro = ?,"+
                    " numero = ?, complemento = ?, bairro = ?, uf = ?, cidade = ?, cargo = ?, salario = ?, comissao = ?,"+
                    " senha = ? where idFuncionario = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1,funcionario.getNome());
            comando.setString(2,funcionario.getCpf());
            comando.setString(3,funcionario.getDataNascimento());
            comando.setString(4,funcionario.getEmail());
            comando.setString(5,funcionario.getCep());
            comando.setString(6,funcionario.getLogradouro());
            comando.setString(7,funcionario.getNumero());
            comando.setString(8,funcionario.getComplemento());
            comando.setString(9,funcionario.getBairro());
            comando.setString(10,funcionario.getUf());
            comando.setString(11,funcionario.getCidade());
            comando.setString(12,funcionario.getCargo());
            comando.setDouble(13,funcionario.getSalario());
            comando.setDouble(14,funcionario.getComissao());
            comando.setString(15,funcionario.getSenha());
            comando.setLong(16,funcionario.getIdFuncionario());
            comando.execute();
            BD.fecharConexao(conexao, comando);
        } catch (SQLException e){
        throw e;
        }
    }
    public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "delete from funcionario where idFuncionario = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, funcionario.getIdFuncionario());
            comando.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            BD.fecharConexao(conexao, comando);
        }
    }


    public static Funcionario obterFuncionario(Long idFuncionario) throws ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        Funcionario funcionario = null;
        try{
            conexao = BD.getConexao();
            String sql = "SELECT * FROM Funcionario WHERE idfuncionario = ?";
            comando = conexao.prepareStatement(sql);
            comando.setLong(1, idFuncionario);
            ResultSet rs = comando.executeQuery();
            rs.first();
            funcionario = new Funcionario(
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
                    rs.getString("cidade"),
                    rs.getString("cargo"),
                    rs.getDouble("salario"),
                    rs.getDouble("comissao"),
                    rs.getString("senha"),
                    rs.getLong("idFuncionario"));
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            BD.fecharConexao(conexao, comando);
        }

        return funcionario;
    }

    public static List<Funcionario> obterTodosFuncionarios() throws ClassNotFoundException{
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            String sql = "SELECT * FROM funcionario";
            ResultSet rs = comando.executeQuery(sql);
            while(rs.next()){
                Funcionario funcionario = new Funcionario(
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
                        rs.getString("cidade"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"),
                        rs.getDouble("comissao"),
                        rs.getString("senha"),
                        rs.getLong("idFuncionario"));
                funcionarios.add(funcionario);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BD.fecharConexao(conexao, comando);
        }
        return funcionarios;
    }
}
