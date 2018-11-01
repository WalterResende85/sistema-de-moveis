package teste;

import dao.FuncionarioDAO;
import model.Funcionario;

import java.sql.SQLException;

public class MainFuncionario {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

       // Funcionario fu = new Funcionario(1L, "Fulano");
        //FuncionarioDAO.gravar(fu);
        //Funcionario x = FuncionarioDAO.obterFuncionario(10L);
        //FuncionarioDAO.excluir(x);
        //x.setNome("e e eimael");
        //FuncionarioDAO.alterar(x);

        Funcionario f  = Funcionario.obterFuncionario(3L);
        FuncionarioDAO.excluir(f);
    }
}
