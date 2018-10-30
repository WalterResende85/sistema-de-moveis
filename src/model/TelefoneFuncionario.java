package model;

import dao.TelefoneFuncionarioDAO;

import java.sql.SQLException;
import java.util.List;

public class TelefoneFuncionario extends Telefone {
    private Long idFuncionario;
    private Funcionario funcionario;



    public TelefoneFuncionario(Long idTelefone, String telefone, Funcionario funcionario) {
        super(idTelefone, telefone);
        this.funcionario = funcionario;
    }

    public void gravar() throws SQLException, ClassNotFoundException{
        TelefoneFuncionarioDAO.gravar(this);
    }

    public void alterar() throws  SQLException, ClassNotFoundException{
        TelefoneFuncionarioDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        TelefoneFuncionarioDAO.excluir(this);
    }

    public static TelefoneFuncionario obterTelefone(Long idFuncionario) throws ClassNotFoundException, SQLException{
        return TelefoneFuncionarioDAO.obterTelefone(idFuncionario);
    }

    public static List<TelefoneFuncionario> obterTodosTelefones() throws ClassNotFoundException, SQLException{
        return TelefoneFuncionarioDAO.obterTodosTelefones();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Long getIdFuncionario(){return idFuncionario;}

    public void setIdFuncionario(Long id) { this.idFuncionario=id; }

}
