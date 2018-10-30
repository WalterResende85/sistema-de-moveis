package teste;

import dao.ClienteDAO;
import dao.TelefoneClienteDAO;
import model.TelefoneCliente;

import java.sql.SQLException;

public class MainTelefoneCliente {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        TelefoneCliente t = new TelefoneCliente(2L, "111", ClienteDAO.obterCLiente(4L));

        // cria o telefone com um id unico um numero e obtem a "chave estrangeira"
        //sempre que vc usar o obter precisa existir alguem no seu banco, se não existir cria

        //se o obter der errado e por causa do problema que eu falei no grupo
        //nesse caso cria o objeto "chave estrangeira do zero e passa ele" exemplo: Cliente x = new Cliente(1L,...)
        //usar  metodo obter exemplo: TelefoneCliente x = TelefoneClienteDAO.obterTelefone(1L);
        //e depois fazer:x.setCliente(ClienteDAO.obterCLiente(1L));


        TelefoneCliente x = TelefoneClienteDAO.obterTelefone(1L);

        //TelefoneClienteDAO.gravar(x); //funcionando

        x.setCliente(ClienteDAO.obterCLiente(1L));

        x.setTelefone("eita porra");  //funcionando

        TelefoneClienteDAO.alterar(x);//funcionando

    }
}
