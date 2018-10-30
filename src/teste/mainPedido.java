package teste;

import dao.PedidoDAO;
import dao.ClienteDAO;
import model.Cliente;
import model.Pedido;

import java.sql.SQLException;

public class mainPedido {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


/*
        Pedido z = PedidoDAO.obterPedido(1L);   //obterPedido vai instanciar um obj com os dados do banco
                                                        // com isso o metodo vai pegar o id da Chave Estrangeira
                                                        // mas nao o objeto da chave estrangeira (nesse caso cliente)

        z.setValorTotal(150.65);                         // mudando um valor

        z.setCliente(ClienteDAO.obterCLiente(1L));//na hora do alterar ele vai verificar o atributo cliente do tipo Cliente
                                                            //esse atributo tá vazio (so tem o id do cliente mas não o obj cliente)
                                                            //entao esse set cliente vai colocar o obj cliente nescessario para o metodo alterar

        PedidoDAO.alterar(z);

        Pedido x = new Pedido(10L,4000.00,ClienteDAO.obterCLiente(1L));
        PedidoDAO.alterar(x);
        //PedidoDAO.excluir(1L);
        //Pedido p = new Pedido(1L,200.50,z);
        //PedidoDAO.gravar(p);

*/


        //Pedido z = PedidoDAO.obterPedido(1L);
        //PedidoDAO.excluir(z);


        /*
        z.setValorTotal(666.00);
        PedidoDAO.alterar(z);
*/

        PedidoDAO.obterTodosPedidos();
        
    }
}