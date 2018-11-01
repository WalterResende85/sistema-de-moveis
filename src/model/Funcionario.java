package model;

import dao.FuncionarioDAO;

import java.sql.SQLException;
import java.util.List;

public class Funcionario extends Pessoa {
    private Long idFuncionario;
    private String cargo;
    private double salario;
    private String comissao;
    private String senha;

    public Funcionario() {}
    public Funcionario(Long id, String nome){
        this.setIdFuncionario(id);
        this.setNome(nome);
    }
    public Funcionario(String nome, String cpf, String dataNascimento, String email, String cep, String logradouro,
                       String numero, String complemento, String bairro, String uf, String cidade,
                       String cargo, double salario, String comissao, String senha, Long idFuncionario) {
        super(nome, cpf, dataNascimento, email, cep, logradouro, numero, complemento, bairro, uf, cidade);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.comissao = comissao;
        this.senha = senha;
    }
    public  void  gravar() throws SQLException, ClassNotFoundException{
        FuncionarioDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        FuncionarioDAO.alterar(this);
    }

    public  void excluir() throws  SQLException, ClassNotFoundException{
        FuncionarioDAO.excluir(this);
    }

    public static Funcionario obterFuncionario(Long idFuncionario) throws  SQLException, ClassNotFoundException{
        return FuncionarioDAO.obterFuncionario(idFuncionario);
    }

    public static List<Funcionario> obterTodosFuncionarios() throws ClassNotFoundException, SQLException{
        return FuncionarioDAO.obterTodosFuncionarios();
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
