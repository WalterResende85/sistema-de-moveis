package teste;

import dao.FornecedorDAO;
import dao.TelefoneFornecedorDAO;
import model.TelefoneFornecedor;
import model.TelefoneFuncionario;

import java.sql.SQLException;

public class MainTelefoneFornecedor {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        TelefoneFornecedor c = new TelefoneFornecedor(4L,"6666", FornecedorDAO.obterFornecedor(1L));

        TelefoneFornecedorDAO.gravar(c);

        TelefoneFornecedor d = TelefoneFornecedorDAO.obterTelefone(1L);

        d.setFornecedor(FornecedorDAO.obterFornecedor(1L));

        d.setTelefone("ajkbd");

        TelefoneFornecedorDAO.alterar(d);

        TelefoneFornecedorDAO.excluir(d);


    }
}
