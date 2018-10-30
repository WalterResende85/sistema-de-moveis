package teste;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainCliente {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<Cliente> lista = new ArrayList();
        int j=0;

        for(long i = 10L; i<50 ; i++, j++ ){
           
        lista.add(new Cliente(i,"joão"+i ));
        ClienteDAO.gravar(lista.get(j));
        }
        
        //Cliente x = new Cliente(4L,"Aeita");
        //ClienteDAO.obterTodosClientes();
        //ClienteDAO.gravar(x);
        //Cliente z = ClienteDAO.obterCLiente(2L);
        //z.setNome("Fulaninho");
        //ClienteDAO.excluir(ClienteDAO.obterCLiente(2L));
        //ClienteDAO.obterCLiente(id);


        //Cliente x = ClienteDAO.obterCLiente(4L);
        //x.setNome("teste");
        //ClienteDAO.alterar(x);
        //ClienteDAO.obterTodosClientes();
        

    }
}
