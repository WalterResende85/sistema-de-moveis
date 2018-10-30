package teste;

import dao.FuncionarioDAO;
import dao.TelefoneFuncionarioDAO;
import model.TelefoneFuncionario;

import java.sql.SQLException;

public class MainTelefoneFuncionario {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        TelefoneFuncionario v = new TelefoneFuncionario(4L, "777777", FuncionarioDAO.obterFuncionario(1L));

        TelefoneFuncionarioDAO.gravar(v);

        TelefoneFuncionario x = TelefoneFuncionarioDAO.obterTelefone(1L);

        x.setFuncionario(FuncionarioDAO.obterFuncionario(1L));

        x.setTelefone("EIta");

        TelefoneFuncionarioDAO.alterar(x);

        TelefoneFuncionarioDAO.excluir(x);
    }
}
